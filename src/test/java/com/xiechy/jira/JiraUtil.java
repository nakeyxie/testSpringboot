package com.xiechy.jira;

import com.atlassian.jira.rest.client.api.IssueRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Comment;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.IssueFieldId;
import com.atlassian.jira.rest.client.api.domain.input.ComplexIssueInputFieldValue;
import com.atlassian.jira.rest.client.api.domain.input.FieldInput;
import com.atlassian.jira.rest.client.api.domain.input.IssueInput;
import com.atlassian.jira.rest.client.api.domain.input.TransitionInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @ClassName JiraUtil
 * @Description jira操作工具类
 * @Author R&D-VAL SZ nakey.xie
 * @Date 2021/6/30 13:50
 */
@Slf4j
@Component
public class JiraUtil {

    @Autowired
    JiraRestClient jiraRestClient;

    // 获取环境域名地址
    @Value("${webSecurity.allowedOrigin}")
    private String allowedOrigin;

    public static final String TASK_DETAIL_URL ="/test-management/test-tasks/details?id=";

    /**
     * 转成成冒烟测试通过状态值
     */
    public static Integer APP_SMOKE_TEST_PASS_STATUS = 141;

    /**
     * 转成成冒烟测试失败状态值
     */
    public static Integer APP_SMOKE_TEST_FAIL_STATUS = 131;


    /**
     * @Description 获取冒烟测试通过的选项
     * @Author R&D-VAL SZ nakey.xie
     * @Date  2021/8/25 16:50
     * @param
     * @return com.atlassian.jira.rest.client.api.domain.input.IssueInput
     */
    public static IssueInput getPassInput() {
        HashMap<String, Object> valuesMap = new HashMap<>();
        valuesMap.put("self", "https://jira.tclking.com/rest/api/2/customFieldOption/18213");
        valuesMap.put("value", "冒烟测试通过");
        valuesMap.put("id", "18213");
        ComplexIssueInputFieldValue complexIssueInputFieldValue = new ComplexIssueInputFieldValue(valuesMap);
        FieldInput fieldInput = new FieldInput("customfield_13801", complexIssueInputFieldValue);
        return IssueInput.createWithFields(fieldInput);
    }

    /**
     * @Description 获取冒烟测试不通过的选项
     * @Author R&D-VAL SZ nakey.xie
     * @Date  2021-8-25 16:52:07
     * @param
     * @return com.atlassian.jira.rest.client.api.domain.input.IssueInput
     */
    public static IssueInput getFailInput() {
        HashMap<String, Object> valuesMap = new HashMap<>();
        valuesMap.put("self", "https://jira.tclking.com/rest/api/2/customFieldOption/18214");
        valuesMap.put("value", "冒烟测试不通过");
        valuesMap.put("id", "18214");
        ComplexIssueInputFieldValue complexIssueInputFieldValue = new ComplexIssueInputFieldValue(valuesMap);
        FieldInput fieldInput = new FieldInput("customfield_13801", complexIssueInputFieldValue);
        return IssueInput.createWithFields(fieldInput);
    }

    /**
     * @Description 获取冒烟测试脚本出错的选项
     * @Author R&D-VAL SZ nakey.xie
     * @Date  2021/8/25 16:50
     * @param
     * @return com.atlassian.jira.rest.client.api.domain.input.IssueInput
     */
    public static IssueInput getScriptErrorInput() {
        HashMap<String, Object> valuesMap = new HashMap<>();
        valuesMap.put("self", "https://jira.tclking.com/rest/api/2/customFieldOption/18758");
        valuesMap.put("value", "冒烟测试环境/脚本报错");
        valuesMap.put("id", "18758");
        ComplexIssueInputFieldValue complexIssueInputFieldValue = new ComplexIssueInputFieldValue(valuesMap);
        FieldInput fieldInput = new FieldInput("customfield_13801", complexIssueInputFieldValue);
        return IssueInput.createWithFields(fieldInput);
    }

    /**
     * @Description 根据问题单ID获取问题单信息
     * @Author R&D-VAL SZ nakey.xie
     * @Date  2021/6/30 14:00
     * @param issueKey
     * @return com.atlassian.jira.rest.client.api.domain.Issue
    */
    public Issue getIssue(String issueKey) {
        return jiraRestClient.getIssueClient().getIssue(issueKey).claim();
    }


    /**
     * @Description 更改问题单状态
     * @Author R&D-VAL SZ nakey.xie
     * @Date  2021/6/30 14:00
     * @param issue
     * @param statusId
     * @return void
    */
    public void changeStatus(Issue issue, Integer statusId) {
        TransitionInput tinput = new TransitionInput(statusId);
        jiraRestClient.getIssueClient().transition(issue, tinput);
    }

    /**
     * @Description 根据issueKey修改app冒烟测试问题单的工作流状态以及自定义的平台测试状态
     * @Author R&D-VAL SZ nakey.xie
     * @Date  2021/8/25 15:57
     * @param issueKey
     * @param workFlowStatus
     * @param issueInput
     * @return void
    */
    public void changeAppSmokeTestIssueStatus(String issueKey, Integer workFlowStatus, IssueInput issueInput) {
        Issue issue = jiraRestClient.getIssueClient().getIssue(issueKey).claim();
        //修改工作流状态
        TransitionInput tinput = new TransitionInput(workFlowStatus);
        jiraRestClient.getIssueClient().transition(issue, tinput);
        //修改平台状态
        jiraRestClient.getIssueClient().updateIssue(issueKey, issueInput);
        log.info("issueKey：{},修改状态成功!", issueKey);
    }


    /**
     * @Description 更改JIRA问题单描述
     * @Author R&D-VAL SZ nakey.xie
     * @Date  2021/9/6 16:42
     * @param issueKey
     * @param value
     * @return void
    */
    public void updateDesc(String issueKey, String value) {
        FieldInput fieldInput = new FieldInput(IssueFieldId.DESCRIPTION_FIELD, value);
        IssueInput issueInput = IssueInput.createWithFields(fieldInput);
        jiraRestClient.getIssueClient().updateIssue(issueKey, issueInput);
    }

    /**
     * @Description 添加备注到问题单
     * @Author R&D-VAL SZ nakey.xie
     * @Date  2021/9/9 11:42
     * @param issueKey
     * @param comment
     * @return void
    */
    public void addComment(String issueKey, String comment) {
        IssueRestClient client = jiraRestClient.getIssueClient();
        Issue issue = client.getIssue(issueKey).claim();
        client.addComment(issue.getCommentsUri(), Comment.valueOf(comment)).claim();
    }

    public void addTaskDetail(String issueKey, String taskId){
        StringBuffer commentBuffer = new StringBuffer();
        commentBuffer.append("自动化测试平台已完成自动化测试任务,详情请查看:\n");
        String taskDetailUrl = allowedOrigin+TASK_DETAIL_URL+taskId;
        commentBuffer.append(taskDetailUrl);
        IssueRestClient client = jiraRestClient.getIssueClient();
        Issue issue = client.getIssue(issueKey).claim();
        client.addComment(issue.getCommentsUri(), Comment.valueOf(commentBuffer.toString())).claim();
    }
}

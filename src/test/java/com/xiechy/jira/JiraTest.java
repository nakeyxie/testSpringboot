package com.xiechy.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.input.ComplexIssueInputFieldValue;
import com.atlassian.jira.rest.client.api.domain.input.FieldInput;
import com.atlassian.jira.rest.client.api.domain.input.IssueInput;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import org.codehaus.jettison.json.JSONException;
import org.junit.Test;

import java.net.URI;
import java.util.HashMap;

/**
 * @ClassName JiraTest
 * @Description jira相关代码
 * @Author R&D-VAL SZ nakey.xie
 * @Date 2021/8/20 17:04
 */
public class JiraTest {

    /**
     * @Description 测试修改jira下拉状态
     * @Author nakey
     * @Date  2021/8/20 15:26
     * @param
     * @return void
     */
    @Test
    public void testUpdateState() throws JSONException {
        AsynchronousJiraRestClientFactory asynchronousJiraRestClientFactory = new AsynchronousJiraRestClientFactory();
        JiraRestClient jiraRestClient = asynchronousJiraRestClientFactory.
                createWithBasicHttpAuthentication(URI.create("https://jira.xxxx.com/"),
                        "xxxxx","*********");
        //此处是需要查询的issuekey
        Issue issue = jiraRestClient.getIssueClient().getIssue("xxxx-xxxx").claim();
        //获取某状态数据
        //IssueField issueField = issue.getField("customfield_xxxxx");
        //修改成某状态
        HashMap<String,Object> valuesMap = new HashMap<>();
        valuesMap.put("self","xxxxx");
        valuesMap.put("value","某状态名称");
        valuesMap.put("id","xxx");
        ComplexIssueInputFieldValue complexIssueInputFieldValue = new ComplexIssueInputFieldValue(valuesMap);
        FieldInput fieldInput = new FieldInput("customfield_xxxxx", complexIssueInputFieldValue);
        IssueInput issueInput = IssueInput.createWithFields(fieldInput);
        jiraRestClient.getIssueClient().updateIssue(issue.getKey(),issueInput);
        System.out.println("修改完毕!");
    }
}

package com.xiechy.distinct;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import com.xiechy.entity.ListToStringHandler;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

import static com.baomidou.mybatisplus.annotation.FieldStrategy.NOT_NULL;

/**
 * @ClassName TaskInfo
 * @Description 任务信息
 * @Author R&D-VAL SZ nakey.xie
 * @Date 2021/7/1 16:46
 */
@Data
@TableName(value = "task_info", autoResultMap = true)
public class TaskInfo {

    private String id;

    /**
     * 任务编号
     */
    private Integer taskCode;

    /**
     * 任务描述
     */
    private String summary;

    /**
     * 项目ID
     */
    private String projectId;

    /**
     * 项目名称(当测试类型为app持续冒烟测试时，这个为appName)
     */
    private String projectName;


    /**
     * 测试类型
     */
    //@TableField(jdbcType = JdbcType.TINYINT, insertStrategy = NOT_NULL, typeHandler = MybatisEnumTypeHandler.class)
    private String testType;


    /**
     * 软体版本
     */
    private String swVersion;

    /**
     * 测试状态
     */
    //@TableField(jdbcType = JdbcType.TINYINT, insertStrategy = NOT_NULL, typeHandler = MybatisEnumTypeHandler.class)
    private String taskState;

    /**
     * 脚本ID
     */
    private String scriptInfoId;

    /**
     * gitLab项目克隆地址
     */
    private String gitLabUrl;

    /**
     * gitLab对应项目ID
     */
    private String gitProjectId;

    /**
     * gitLab对应项目名称
     */
    private String gitProjectName;

    /**
     * 选择脚本提交版本
     */
    private String commits;

    /**
     * 选择的分支
     */
    private String branch;

    /**
     * JIRA问题单对应issueKey
     */
    private String issueKey;

    /**
     * app对应版本
     */
    private String appVersion;

    /**
     * app下载地址
     */
    private String appDownloadUrl;


    /**
     * 测试执行人
     */
    @TableField(jdbcType = JdbcType.VARCHAR, insertStrategy = NOT_NULL, typeHandler = ListToStringHandler.class)
    private List<String> assignedUsers;

    /**
     * 通知人
     */
    @TableField(jdbcType = JdbcType.VARCHAR, insertStrategy = NOT_NULL, typeHandler = ListToStringHandler.class)
    private List<String> noticeUsers;

    /**
     * 子任务信息
     */
    // 该属性不为数据库表字段
    @TableField(exist = false)
    private List<String> jobs;
}

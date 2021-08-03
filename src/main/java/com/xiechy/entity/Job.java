/*
package com.xiechy.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tct.val.aurora.common.config.mybatisplus.ListToStringHandler;
import com.tct.val.aurora.common.enums.JobState;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import javax.validation.constraints.NotBlank;
import java.util.List;

import static com.baomidou.mybatisplus.annotation.FieldStrategy.NOT_NULL;

*/
/**
 * @ClassName Job
 * @Description 子任务信息             (数据存list<String> 的一个示例)
 * @Author R&D-VAL SZ nakey.xie
 * @Date 2021/7/2 13:11
 *//*

@Data
@TableName(value = "job", autoResultMap = true)
public class Job extends BaseEntity{

    */
/**
     * 子任务编号
     *//*

    private Integer jobNo;

    */
/**
     * 主任务ID
     *//*

    private String taskId;

    */
/**
     * 主设备客户端ID
     *//*

    private String mClientId;

    */
/**
     * 主设备ID
     *//*

    @NotBlank(message = "主设备不能为空!")
    private String mDeviceId;

    */
/**
     * 次设备客户端ID
     *//*

    private String sClientId;

    */
/**
     * 次设备ID
     *//*

    private String sDeviceId;

    */
/**
     * 子任务状态
     *//*

    private JobState jobState;

    */
/**
     * 循环次数
     *//*

    private Integer cycleCount;



    */
/**
     * 选择脚本集合
     *//*

    @TableField(jdbcType = JdbcType.LONGVARCHAR, insertStrategy = NOT_NULL, typeHandler = ListToStringHandler.class)
    private List<String> filePaths;
}
*/

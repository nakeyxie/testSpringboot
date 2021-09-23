package com.xiechy.distinct;

import cn.hutool.core.collection.CollectionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName entityDistinct
 * @Description TODO
 * @Author R&D-VAL SZ nakey.xie
 * @Date 2021/8/20 17:59
 */
public class entityDistinct {

    /**
     * @Description 添加任务列表(去除重复的)
     * @Author R&D-VAL SZ nakey.xie
     * @Date  2021/8/10 15:49
     * @param projectTasks
     * @param keyWordTasks
     * @return java.util.List<com.tct.val.aurora.entity.TaskInfo>
     */
    private List<TaskInfo> addTask(List<TaskInfo> projectTasks, List<TaskInfo> keyWordTasks) {
        List<TaskInfo> allTasks = new ArrayList<>();
        if (CollectionUtil.isEmpty(projectTasks) || CollectionUtil.isEmpty(keyWordTasks)) {
            allTasks.addAll(projectTasks);
            allTasks.addAll(keyWordTasks);
        } else {
            List<String> taskInfoIds = projectTasks.stream().map(i -> i.getId()).collect(Collectors.toList());
            allTasks.addAll(projectTasks);
            for (TaskInfo taskInfo : keyWordTasks) {
                String id = taskInfo.getId();
                if (!taskInfoIds.contains(id)) {
                    allTasks.add(taskInfo);
                }
            }
        }
        return allTasks;
    }

}

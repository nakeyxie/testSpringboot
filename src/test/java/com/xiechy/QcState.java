package com.xiechy;

/**
 * Created by Liuchuankai on 2017/1/9.
 */
public enum QcState {
    /**
     * 质检中
     */
    Progressing("质检中"),

    /**
     * 待判定
     */
    Determination("待判定"),

    /**
     * 已完成
     */
    Finished("已完成"),

    /**
     * 已取消
     */
    Canceled("已取消"),

    /**
     * 方案待分配
     */
    WaitProgram("方案待分配"),

    /**
     * 合格
     */
    Success("合格"),

    /**
     * 不合格
     */
    Fail("不合格");

    String description;
    QcState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}


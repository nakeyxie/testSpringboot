package com.xiechy.wx.service;

import com.xiechy.wx.bean.User;
import com.xiechy.wx.bean.WxJsConfig;

public interface WxUserService {

    /**
     * 根据微信授权CODE换取用户信息
     *
     * @param code
     * @return
     * @throws Exception
     */
    User getUser(String code) throws Exception;

    /**
     * 获取访问授权
     *
     * @return
     * @throws Exception
     */
    String getAccessToken() throws Exception;

    /**
     * 获取JS api配置信息
     *
     * @param url 调用JSAPI页面地址
     * @return
     * @throws Exception
     */
    WxJsConfig getJsapiTicket(String url) throws Exception;

    User syncFansInfo();

}

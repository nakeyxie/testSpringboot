package com.xiechy.wx;

/*import cn.llc.cms.dto.CoreUserDTO;
import cn.llc.cms.service.CoreUserService;
import cn.llc.common.enums.SysEnum;
import cn.llc.common.util.IdWorker;*/
import jdk.nashorn.internal.ir.annotations.Reference;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.builder.outxml.TextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * 微信公众号消息处理
 */
@Component
public class SubscribeHandler implements WxMpMessageHandler {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

   /* @Reference
    private CoreUserService userService;

    @Autowired
    private IdWorker idWorker;*/

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) throws WxErrorException {
        logger.info("新关注用户 OPENID: " + wxMessage.getFromUser());
        // 获取微信用户基本信息
        try {
            WxMpUser wxMpUser = weixinService.getUserService()
                    .userInfo(wxMessage.getFromUser(), null);
            if (wxMpUser != null) {
               /* CoreUserDTO user = userService.findWxUserByUid(wxMpUser.getOpenId());
                if (user == null) {
                    user = new CoreUserDTO();
                    user.setUid(wxMpUser.getOpenId());
                    String userNo = SysEnum.ServiceTypeEnum.CS.getCode() + idWorker.nextId();
                    user.setChannel(SysEnum.ChannelType.WX.getCode());
                    user.setUserNo(userNo);
                    user.setStatus((byte) SysEnum.DelFlagEnum.OK.getCode());
                    user.setSourceType((byte) SysEnum.UserSourceType.WX.getCode());
                    user.setDelFlag((byte) SysEnum.DelFlagEnum.OK.getCode());
                    user.setCreateDate(new Date());
                    user.setUpdateDate(new Date());
                    user.setUnionId(wxMpUser.getUnionId());
                    user.setUserName(wxMpUser.getNickname());
                    int sex = wxMpUser.getSex() == null ? 0 : wxMpUser.getSex();
                    user.setSex((byte) sex);
                    user.setProvince(wxMpUser.getProvince());
                    user.setCity(wxMpUser.getCity());
                    user.setImg(wxMpUser.getHeadImgUrl());
                    userService.save(user);
                } else {
                    user.setUserName(wxMpUser.getNickname());
                    int sex = wxMpUser.getSex() == null ? 0 : wxMpUser.getSex();
                    user.setSex((byte) sex);
                    user.setProvince(wxMpUser.getProvince());
                    user.setCity(wxMpUser.getCity());
                    user.setImg(wxMpUser.getHeadImgUrl());
                    user.setUpdateDate(new Date());
                    user.setRemarks("关注微信公众号");
                    userService.updateById(user);
                }*/
            }
        } catch (WxErrorException e) {
            if (e.getError().getErrorCode() == 48001) {
                logger.info("该公众号没有获取用户信息权限！");
            }
        } catch (Exception e) {
            logger.info("处理用户关注微信公众号事件失败", e);
        }
        return new TextBuilder().content("欢迎关注'路路彩公众号'").build();
    }
}

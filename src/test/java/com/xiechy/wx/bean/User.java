package com.xiechy.wx.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户信息
 */
@Entity(name = "core_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    public static final String WX_H5 = "WXH5";
    public static final String WX_MP = "WXMP";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 31)
    /**用户渠道**/
    private String channel;
    @Column(length = 127)
    /**渠道标识 微信为openId**/
    private String uid;
    @Column
    private String sessionKey;
    @Column
    private String sessionId;
    @Column
    private Integer sex;    //1 男 ；2 女
    @Column(length = 127)
    private String userName;
    @Column
    private String userTel;
    @Column(length = 127)
    private String password;
    @Column
    private String img;
    @Column
    private Integer age;
    @Column
    private String province;
    @Column
    private String city;
    @Column
    private byte status;
    @Column
    private Date createDate;
    @Column
    private Date updateDate;
    /**用户体系唯一标识 微信为unionId**/
    @Column
    private String unionId;
}

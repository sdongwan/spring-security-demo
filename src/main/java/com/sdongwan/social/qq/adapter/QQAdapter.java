package com.sdongwan.social.qq.adapter;

import com.sdongwan.social.qq.TO.QQUserInfo;
import com.sdongwan.social.qq.api.QQ;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @Description
 * @Date 2020/1/4 19:13
 * @Created by sdongwan
 */
public class QQAdapter implements ApiAdapter<QQ> {
    @Override
    public boolean test(QQ qq) {
        return true;
    }

    @Override
    public void setConnectionValues(QQ api, ConnectionValues connectionValues) {
        //获取用户信息
        QQUserInfo userInfo = api.getUserInfo();
        connectionValues.setDisplayName(userInfo.getNickname());//展示名，qq用户名
        connectionValues.setImageUrl(userInfo.getFigureurl_1()); //qq头像
        connectionValues.setProfileUrl(null); //个人主页，qq没有，微博有
        connectionValues.setProviderUserId(userInfo.getOpenId());
    }

    @Override
    public UserProfile fetchUserProfile(QQ qq) {
        return null;
    }

    @Override
    public void updateStatus(QQ qq, String s) {

    }
}

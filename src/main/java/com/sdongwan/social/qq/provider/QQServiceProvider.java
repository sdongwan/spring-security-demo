package com.sdongwan.social.qq.provider;

import com.sdongwan.social.qq.QQImpl;
import com.sdongwan.social.qq.api.QQ;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * @Description
 * @Date 2020/1/4 17:09
 * @Created by sdongwan
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private String appId;

    //将用户引导到获取授权码的地址
    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";
    //拿着授权码申请令牌token的地址
    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";


    public QQServiceProvider(String appId , String appSecret) {
        super(new OAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
        this.appId = appId;
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken,appId);
    }
}

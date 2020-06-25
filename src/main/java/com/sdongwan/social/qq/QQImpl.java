package com.sdongwan.social.qq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdongwan.social.qq.TO.QQUserInfo;
import com.sdongwan.social.qq.api.QQ;
import org.apache.commons.lang3.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.io.IOException;

/**
 * @Description
 * @Date 2020/1/4 17:11
 * @Created by sdongwan
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {
    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    private static final String URL_GET_USRE_INFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    private String appId;

    private String openId;

    private ObjectMapper objectMapper = new ObjectMapper();

    public QQImpl(String accessToken,String appId) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;
        String url = String.format(URL_GET_OPENID,accessToken);
        // 调用父类的restTemplate发请求，获取openid
        String result = getRestTemplate().getForObject(url, String.class);

        System.err.println(result);
        // {"client_id":"YOUR_APPID","openid":"YOUR_OPENID"} 截取openid
        this.openId = StringUtils.substringBetween(result, "\"openid\"", "}");
    }

    @Override
    public QQUserInfo getUserInfo(){
        String url = String.format(URL_GET_USRE_INFO,appId,openId);
        String result = getRestTemplate().getForObject(url,String.class);
        QQUserInfo qqUserInfo = null;
        try {
            qqUserInfo = objectMapper.readValue(result, QQUserInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return qqUserInfo;
    }
}

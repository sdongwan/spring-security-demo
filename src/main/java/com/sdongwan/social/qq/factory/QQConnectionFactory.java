package com.sdongwan.social.qq.factory;

import com.sdongwan.social.qq.adapter.QQAdapter;
import com.sdongwan.social.qq.api.QQ;
import com.sdongwan.social.qq.provider.QQServiceProvider;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @Description
 * @Date 2020/1/4 19:21
 * @Created by sdongwan
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    public QQConnectionFactory(String providerId, String appId,String appSecret) {
        super(providerId, new QQServiceProvider(appId,appSecret), new QQAdapter());
    }
}

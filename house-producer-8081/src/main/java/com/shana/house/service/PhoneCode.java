package com.shana.house.service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.netflix.discovery.converters.Auto;
import com.shana.house.config.StaticPeram;
import com.shana.house.util.RandomNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class PhoneCode {
    @Autowired
    RedisTemplate redisTemplate;

    public String getPhoneCode(String mobilephone) {
        if(!mobilephone.matches("[1][3578]\\d{9}")){
            return "0";
        }
        // 设置超时时间-可自行调整
        System.setProperty(StaticPeram.defaultConnectTimeout, StaticPeram.Timeout);
        System.setProperty(StaticPeram.defaultReadTimeout, StaticPeram.Timeout);
        // 初始化ascClient需要的几个参数
        final String product = StaticPeram.product;// 短信API产品名称（短信产品名固定，无需修改）
        final String domain = StaticPeram.domain;// 短信API产品域名（接口地址固定，无需修改）
        // 替换成你的AK
        final String accessKeyId = StaticPeram.accessKeyId;// 你的accessKeyId,参考本文档步骤2
        final String accessKeySecret = StaticPeram.accessKeySecret;// 你的accessKeySecret，参考本文档步骤2
        // 初始化ascClient,暂时不支持多region
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product,
                    domain);
        } catch (ClientException e1) {
            e1.printStackTrace();
        }

        //获取验证码
        String code = RandomNum.vcode();
        IAcsClient acsClient = new DefaultAcsClient(profile);
        // 组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        // 使用post提交
        request.setMethod(MethodType.POST);
        // 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
        request.setPhoneNumbers(mobilephone);
        // 必填:短信签名-可在短信控制台中找到
        request.setSignName(StaticPeram.SignName);
        // 必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(StaticPeram.TemplateCode);
        // 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        // 友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        request.setTemplateParam("{ \"code\":\"" + code + "\"}");
        System.out.println(request.getTemplateParam());
        // 可选-上行短信扩展码(无特殊需求用户请忽略此字段)
        // request.setSmsUpExtendCode("90997");
        // 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");
        // 请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse;
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
            System.out.println(sendSmsResponse.getCode());
            if (sendSmsResponse.getCode() != null
                    && sendSmsResponse.getCode().equals("OK")) {
                // 发送验证码成功
                redisTemplate.opsForValue().set(mobilephone,code,120, TimeUnit.SECONDS);

                System.out.println(redisTemplate.opsForValue().get(mobilephone));
                return "2";
            }else{
                //发送验证码失败
                return "1";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "1";
        }
    }
}

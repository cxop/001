package com.decryto.util;//package com.qyxy.util;
//
//
//import com.aliyuncs.DefaultAcsClient;
//import com.aliyuncs.IAcsClient;
//import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
//import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
//import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
//import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
//import com.aliyuncs.exceptions.ClientException;
//import com.aliyuncs.profile.DefaultProfile;
//import com.aliyuncs.profile.IClientProfile;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//
//public class SmsDemo1 {
//
//
//    static final String product = "Dysmsapi";
//    static final String domain = "dysmsapi.aliyuncs.com";
//    static final String accessKeyId = "LTAI479mGNyMuBOs";
//    static final String accessKeySecret = "7qr4jMEN9KOxdZqUtZeIKyiAHckUqT";
//    public static SendSmsResponse sendSms(String phone,String templateCode,String signName,int random) throws ClientException {
//        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
//        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
//        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
//        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
//        IAcsClient acsClient = new DefaultAcsClient(profile);
//        SendSmsRequest request = new SendSmsRequest();
//        request.setPhoneNumbers(phone);
//        request.setSignName(signName);
//        request.setTemplateCode(templateCode);
//        request.setTemplateParam("{ \"code\":\""+ random+"\"}");
//        request.setOutId("yourOutId");
//        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
//        return sendSmsResponse;
//    }
//    public static QuerySendDetailsResponse querySendDetails(String bizId,String telphone) throws ClientException {
//        //可自助调整超时时间
//        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
//        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
//
//        //初始化acsClient,暂不支持region化
//        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
//        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
//        IAcsClient acsClient = new DefaultAcsClient(profile);
//
//        //组装请求对象
//        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
//        //必填-号码
//        request.setPhoneNumber(telphone);
//        //可选-流水号
//        request.setBizId(bizId);
//        //必填-发送日期 支持30天内记录查询，格式yyyyMMdd
//        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
//        request.setSendDate(ft.format(new Date()));
//        //必填-页大小
//        request.setPageSize(10L);
//        //必填-当前页码从1开始计数
//        request.setCurrentPage(1L);
//
//        //hint 此处可能会抛出异常，注意catch
//        QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);
//
//        return querySendDetailsResponse;
//    }
//
//    public static void main(String[] args) throws ClientException, InterruptedException {
//        //String phone,String templateCode,String signName,int random
//
//
//        //发短信
//        SendSmsResponse response = sendSms("17739043132","SMS_139820001","袁晓军",10011);
//
//
//        System.out.println("短信接口返回的数据----------------");
//        System.out.println("Code=" + response.getCode());
//        System.out.println("Message=" + response.getMessage());
//        System.out.println("RequestId=" + response.getRequestId());
//        System.out.println("BizId=" + response.getBizId());
//
//        Thread.sleep(3000L);
//
//        //查明细
//        if(response.getCode() != null && response.getCode().equals("OK")) {
//
//
//            QuerySendDetailsResponse querySendDetailsResponse = querySendDetails(response.getBizId(),"17739043131");
//
//
//            System.out.println("短信明细查询接口返回数据----------------");
//            System.out.println("Code=" + querySendDetailsResponse.getCode());
//            System.out.println("Message=" + querySendDetailsResponse.getMessage());
//            int i = 0;
//            for(QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs())
//            {
//                System.out.println("SmsSendDetailDTO["+i+"]:");
//                System.out.println("Content=" + smsSendDetailDTO.getContent());
//                System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
//                System.out.println("OutId=" + smsSendDetailDTO.getOutId());
//                System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
//                System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
//                System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
//                System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
//                System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
//            }
//            System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
//            System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
//        }
//
//    }
//}

package com.neon.service.impl;

 

import org.apache.commons.logging.Log;  
import org.apache.commons.logging.LogFactory;

import com.neon.domain.MailInfo;

import javax.mail.*;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeBodyPart;  
import javax.mail.internet.MimeMessage;  
import javax.mail.internet.MimeMultipart;  
import java.util.*;  
  
/** 
 * file MailUtil 
 * 使用JAVA mail进行邮件发送的工具类 
 * 
 * @author ds 
 * @version 1.0 2015 
 *          date 15-3-9 
 */  
public class MailUtil {  
    protected static Log logger = LogFactory.getLog("com.special.utils.mail.MailUtil");  
    /** 
     * 存放发送方信息 
     */  
    private static List<MailInfo> mailFromList = new ArrayList<MailInfo>();  
  
    /** 
     * 标记初始化发送方信息 
     */  
    private static boolean flag = true;  
    /** 
     * 邮件发送发生异常后重复发送的次数 
     */  
    private static Integer exceptionCount = 5;  
  
    /** 
     * 初始化发送方信息 
     * 
     * @param list 发送方列表 
     */  
    public static void init(List<MailInfo> list) {  
        if (flag) {  
            mailFromList = list;  
            flag = false;  
        }  
    }  
  
    /** 
     * 发送邮件 
     * 
     * @param subject 邮件主题 
     * @param type    邮件类型，html或者文本 
     * @param content 邮件内容 
     * @param to      收件人，有逗号隔开 
     * @param cc      抄送，逗号隔开 
     * @param bcc     暗送，逗号隔开 
     * @return boolean true 发送成功 false 发送失败 
     */  
    public static boolean send(String subject, MailInfo.MailType type, String content, String to, String cc, String bcc) {  
        boolean result = true;  
        //首先列表排序  
        Collections.sort(mailFromList);  
        //获取发送频率最小的一个值  
        final MailInfo mailInfo = mailFromList.get(0) == null ? new MailInfo() : mailFromList.get(0);  
        logger.info(mailInfo.toString());  
        /** 
         * 每使用一次mail服务器就递增一次发送次数，而不是发送成功之后才递增， 
         * 这样做的目的是避免某一台mail服务器故障后无法发送邮件但永远频次最低， 
         * 故永远选择这台故障机发送，所带来的问题 
         */  
        mailInfo.setCount(mailInfo.getCount() + 1);  
        // 以下为发送程序，用户无需改动  
        Properties props = new Properties();  
        props.put("mail.smtp.host", mailInfo.getHostName());  
        //身份验证，一般邮件服务器都需要身份验证  
        props.put("mail.smtp.auth", "true");  
        Session ssn = Session.getInstance(props, new Authenticator() {  
            @Override  
            protected PasswordAuthentication getPasswordAuthentication() {  
                return new PasswordAuthentication(mailInfo.getUserName(), mailInfo.getPassword());    //To change body of overridden methods use File | Settings | File Templates.  
            }  
  
        });  
        MimeMessage message = new MimeMessage(ssn);  
        InternetAddress fromAddress;  
        try {  
            fromAddress = new InternetAddress(mailInfo.getUserName());  
            message.setFrom(fromAddress);  
            //收件人，以逗号隔开  
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));  
            //抄送，以逗号隔开  
            if (null != cc && !"".equals(cc)) {  
                message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));  
            }  
            //暗送，逗号隔开  
            if (null != bcc && !"".equals(bcc)) {  
                message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc));  
            }  
            message.setSubject(subject);  
            switch (type) {  
                case HTML:  
                    MimeBodyPart mbp = new MimeBodyPart();  
                    // 设定邮件内容的类型为 text/plain 或 text/html  
                    mbp.setContent(content, "text/html;charset=UTF-8");  
                    Multipart mp = new MimeMultipart();  
                    mp.addBodyPart(mbp);  
                    message.setContent(mp);  
                    break;  
                case TEXT:  
                    //发送文本邮件  
                    message.setText(content);  
                    break;  
            }  
            message.setSentDate(new Date());  
            //发送邮件，还有另外一种写法  
            /*Transport transport = ssn.getTransport("smtp"); 
            transport.connect(mailInfo.getHostName(), mailInfo.getUserName(), mailInfo.getPassword()); 
            transport.sendMessage(message, message.getAllRecipients()); 
            transport.close();*/  
            Transport.send(message);  
            logger.info("mail send successfully from " + mailInfo.getUserName() + " to " + to + " and cc to " + cc);  
        } catch (Exception e) {  
            result = false;  
            synchronized (exceptionCount) {  
                if (exceptionCount <= 0) {  
                    exceptionCount = 5;  
                } else {  
                    exceptionCount--;  
                    if (send(subject, type, content, to, cc, bcc)) {  
                        result = true;  
                        exceptionCount = 5;  
                    }  
                    logger.info("mail send failure ,from " + mailInfo.getUserName() + " to " + to);  
                }  
            }  
            e.printStackTrace();  
        }  
  
        return result;  
    }  
  
    public boolean test() {  
        boolean r = true;  
        try {  
            logger.info(1 / 0);  
        } catch (Exception e) {  
            r = false;  
            e.printStackTrace();  
        }  
        return r;  
    }  
  
    public static void main(String[] args) {  
        MailInfo info;  
        String hostName = "smtp.163.com";  
        info = new MailInfo(hostName, "13244237736@163.com", "ye7536830875");  
        mailFromList.add(info);  
//        info = new MailInfo(hostName, "ds@mail.com.cn", "pwd");  
//        mailFromList.add(info);  
  
  
        boolean r = MailUtil.send("test", MailInfo.MailType.HTML, "<a href='http://localhost:8081/Neon/'>返回登录</a>", "hiw2012@163.com", "", "");  
        logger.info(r);  
    }  
}

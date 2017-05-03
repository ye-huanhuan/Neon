package com.neon.domain;
  

/** 
 * file MailInfo 
 * 邮件发送者的模型，实现comparable接口，根据发送次数比较大小 
 * 
 * @author ds 
 * @version 1.0 2015 
 *          date 15-3-9 
 */  
public class MailInfo implements Comparable<MailInfo> {  
    /** 
     * 发送的主机地址 
     */  
	 
	
    String hostName;  
    /** 
     * 发送人邮箱 
     */  
    String userName;  
    /** 
     * 发送人邮箱密码 
     */  
    String password;  
    /** 
     * 该发送方发送邮件次数 
     */  
    Integer count = 0;  
  
    public int compareTo(MailInfo other) {  
        int o = other.getCount() == null ? 0 : other.getCount();  
        return count - o;  
    }  
  
    /** 
     * 邮件发送类型 
     */  
    public enum MailType {  
        HTML,  
        TEXT  
    }  
  
    /** 
     * 无参构造函数 
     */  
    public MailInfo() {  
    }  
  
    /** 
     * 含参数构造函数 
     * 
     * @param hostName 服务器主机SMTP地址 
     * @param userName 发送者邮箱 
     * @param password 发送者邮箱密码 
     */  
    public MailInfo(String hostName, String userName, String password) {  
        this.hostName = hostName;  
        this.userName = userName;  
        this.password = password;  
    }  
  
    public String getHostName() {  
        return hostName;  
    }  
  
    public void setHostName(String hostName) {  
        this.hostName = hostName;  
    }  
  
    public String getUserName() {  
        return userName;  
    }  
  
    public void setUserName(String userName) {  
        this.userName = userName;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
    public Integer getCount() {  
        return count;  
    }  
  
    public void setCount(Integer count) {  
        this.count = count;  
    }  
  
    public String toString() {  
        return hostName + ":" + userName + ":" + count;  
    }  
  
}

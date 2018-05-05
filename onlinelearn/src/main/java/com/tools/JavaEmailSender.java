package com.tools;

import java.util.Date;
import java.util.Properties;
 
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bean.Edu_Emailesend_History;
import com.sun.mail.util.MailSSLSocketFactory;


public class JavaEmailSender {
	
	 public static void sendEmail(Edu_Emailesend_History email)throws Exception{
		    Properties props = new Properties();
		 
		    // ����debug����
		    props.setProperty("mail.debug", "true");
		    // ���ͷ�������Ҫ�����֤
		    props.setProperty("mail.smtp.auth", "true");
		    // �����ʼ�������������
		    props.setProperty("mail.host", "smtp.qq.com");
		    // �����ʼ�Э������
		    props.setProperty("mail.transport.protocol", "smtp");
		 
		    /**SSL��֤��ע����Ѷ�����ǻ���SSL���ܵģ�������Ҫ�����ſ���ʹ��**/
		    MailSSLSocketFactory sf = new MailSSLSocketFactory();
		    sf.setTrustAllHosts(true);
		    props.put("mail.smtp.ssl.enable", "true");
		    props.put("mail.smtp.ssl.socketFactory", sf);
		 
		    //�����Ự
		    Session session = Session.getInstance(props);
		 
		    //���͵���Ϣ�����ڹ۲���ģʽ������Ƶ�
		    Message msg = new MimeMessage(session);
		    msg.setSubject(email.getTitle());
		    //ʹ��StringBuilder����ΪStringBuilder�����ٶȻ��String�죬�����̰߳�ȫ��Ҳ����
		    StringBuilder builder = new StringBuilder();
		    builder.append("\n"+email.getContent());
		    builder.append("\nʱ�� " + new Date());
		    msg.setText(builder.toString());
		    msg.setFrom(new InternetAddress("298185161@qq.com"));
		 
		    Transport transport = session.getTransport();
		    transport.connect("smtp.qq.com", "298185161@qq.com", "domaeieeytlabjfg");
		    //������Ϣ
		    transport.sendMessage(msg, new Address[] { new InternetAddress(email.getEmail()) });
		    transport.close();
		  }

}

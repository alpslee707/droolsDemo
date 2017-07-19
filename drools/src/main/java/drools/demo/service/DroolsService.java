package drools.demo.service;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import drools.demo.Model.Message;
import drools.demo.Model.PointDomain;

public class DroolsService {

	/**
	 * 简单的hello world 规则
	 * */
	public static String fireRule() {
		// load up the knowledge base
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("message-rules");
		// go !
		Message message = new Message();
		message.setMessage("Hello World");
		message.setStatus(Message.GOODBYE);
		kSession.insert(message);// 插入
		kSession.fireAllRules();// 执行规则
		kSession.dispose();
		return message.getMessage();
	}
	
	/**
	 * 简单积分规则
	 * */
	public static PointDomain pointRule(PointDomain point) {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("point-rules");
		kSession.insert(point);// 插入
		kSession.fireAllRules();// 执行规则
		kSession.dispose();
		return point;
	}

	public static void main(String[] args) {
		PointDomain point = new PointDomain();
		point.setUserName("hello kity");  
		point.setBackMondy(100d);  
		point.setBuyMoney(500d);  
		point.setBackNums(1);  
		point.setBuyNums(5);  
		point.setBillThisMonth(5);  
		point.setBirthDay(true);  
		point.setPoint(0l);
		System.out.println("规则改变前： 用户" + point.getUserName() + " 积分 ：" + point.getPoint());
		pointRule(point);
		System.out.println("规则改变后： 用户" + point.getUserName() + " 积分 ：" + point.getPoint());
	}
}

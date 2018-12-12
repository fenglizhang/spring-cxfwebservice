package com.zlf.impl;

import javax.jws.WebService;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.util.XMLUtils;
import com.zlf.HelloWorld;
/**
 * 由于实现类和接口不在同一个包中。所以要加上targetNamespace属性。
 * 另外，这里的endpointInterface是实现类对应接口的全路径
 * @author Administrator
 */
@WebService(targetNamespace="com.serviceTargetName",endpointInterface="com.zlf.HelloWorld")
@Component("HelloWord")//spring注入用
public class HelloWorldImpl implements HelloWorld {
	@Override
	 public String sayHello(String str) {
		String username="aaa";
		Document document = XMLUtils.parse(str);
		//首先接口开发肯定是双发都知道此方法要接受的报文格式的。我们获取报文中人名对应的节点即可。
		  Node node = document.getElementsByTagName("userName").item(0);
		  if(node !=null){
			  username=node.getTextContent();
		  }
        return "你好，"+username+"  你已成功访问了webservice服务端！" ;
    }

	@Override
	public String sayGoodBye(String name, String age) {
		return name+"向年龄为"+age+"的好朋友说再见了。";
	}
}
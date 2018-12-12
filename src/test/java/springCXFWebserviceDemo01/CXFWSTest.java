package springCXFWebserviceDemo01;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class CXFWSTest {
	public static void main(String[] args) throws Exception {
		JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
		Client client = factory.createClient("http://localhost:8080/springCXFWebserviceDemo01/service/HelloWorldService?wsdl");
		Object[] objs = client.invoke("sayHello", "阿福");
		System.out.println(objs[0].toString());
	}
}

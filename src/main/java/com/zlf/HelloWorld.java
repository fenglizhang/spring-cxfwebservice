package com.zlf;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @1.这里的@Webservice(targetNamespace="")的作用类似与spring的Controller层中的Controller("/helloworld"),用于定位
 * 你请求的时那个接口，用于区分接口。
 * @2.在客户端有指定用哪个接口中的哪个方法的具体设置代码：
 * call.setOperationName(new QName("serviceTargetName", "sayHello"));
 * 方法中的QName方法的入参说明：
 * new QName(
 * String namespaceURI-定位接口的命名空间：接口注解targetnamespace的值或者wsdl文件<wsdl:definitions中的xmlns:tns="com.serviceTargetName"来锁定targetnamespace的值，
 * 这里如果不是axis2开发的接口，则最好不用wsdl文件<wsdl:definitions中的targetNamespace来确定值的原因在于这里的值来源与接口实现类上的targetNamespace注解的值。如果你接口的实现类中的targetNamespace和接口的不一样，岂不是搞错了。
 * String localPart-接口下定位方法的方法名:就是这里的抽象方法sayHello方法名，或者wsdl文件<wsdl:binding标签下<wsdl:operation name="sayHello"中name的值。
 * 			)
 * @3.在要发布的服务接口类开头加上@WebService 在接口的实现类开头也加上@WebService 若两个类不在同一个包中
 *  则还要在实现类上用targetNamespace指明目标命名空间。命名空间的值和接口上的值一样。
 * 
 * @author Administrator
 * 
 *         
 */
@WebService(targetNamespace = "com.serviceTargetName")
public interface HelloWorld {
	//如果接口没有用@WebParam(name = "parameterName")来指明方法入参的参数名称-这里时'parameterName',则在客户端你传入参数时：
	//客户端设置入参：call.addParameter("parameterName", XMLType.XSD_STRING, ParameterMode.IN);
	//会报错：Unmarshalling Error: 意外的元素 (uri:"", local:"parameterName")。所需元素为<{}arg0>
	public String sayHello(@WebParam(name = "parameterName") String name);
	
	public String sayGoodBye(@WebParam(name="name") String name,@WebParam(name="age") String age);
}

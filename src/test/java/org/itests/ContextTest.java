package org.itests;

import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextTest extends CamelSpringTestSupport{

	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
	}
	
	@Test
	public void testSendingToJmsQueue() throws Exception{
		template.sendBody("apollo:queue:test.queue.1", "Hello from Apollo");
		Thread.sleep(30000);
	}
	


}

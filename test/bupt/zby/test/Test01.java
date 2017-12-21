package bupt.zby.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bupt.zby.entity.Pest;
import bupt.zby.entity.PestQuery;
import bupt.zby.service.PestService;
import bupt.zby.service.impl.PestServiceImpl;

public class Test01 {
	static PestServiceImpl service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (PestServiceImpl) context.getBean("pestService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		// System.out.println(service.queryPestById(1));
		// List<String> list1 = service.queryFamilyList();
		// for (String string : list1) {
		// System.out.println(string);
		// }
		// List<String> list2 = service.queryCategoryList();
		// for (String string : list2) {
		// System.out.println(string);
		// }
		PestQuery pestQuery = new PestQuery();
		pestQuery.setName("虫");
//		List<Pest> list3 = service.queryData(0, 10, pestQuery);
//		for (Pest pest : list3) {
//			System.out.println(pest.getName());
//		}
//		System.out.println(service.queryCount(pestQuery));
		
		System.out.println(service.queryPageBean(1, 5, pestQuery));
	}

}

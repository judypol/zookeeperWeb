package com.guanyi.zkweb;

import com.guanyi.zkweb.utils.ZkUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZkwebApplicationTests {
	@Autowired
	ZkUtils zkUtils;
	@Test
	public void contextLoads() {
	}
	@Test
	public void getAllPath() throws Exception{
		List<String> childs=zkUtils.getChildNodes("/zkweb");

		System.out.println(childs);
	}
	@Test
	public void createNode() throws Exception{
		zkUtils.setNode("/zkweb");
		zkUtils.setNode("/zkweb/testNode1","你好！");

		String data=zkUtils.getData("/zkweb/testNode1");

		System.out.println(data);
	}
	@Test
	public void getData() throws Exception{
		String data=zkUtils.getData("/testNode1");

		System.out.println(data);
	}
	@Test
	public void createParentNode() throws Exception{
		zkUtils.setNode("/testNode2/dev/key1","这是Key1");
	}
	@Test
	public void deleteNode() throws Exception{
		zkUtils.delNode("testNode2/dev/key1");
	}
}

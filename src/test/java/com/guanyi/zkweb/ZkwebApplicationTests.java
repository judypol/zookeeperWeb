package com.guanyi.zkweb;

import com.alibaba.fastjson.JSON;
import com.guanyi.zkweb.services.models.TestModel;
import com.guanyi.zkweb.utils.ZkUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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
	@Test
	public void generateBigJSON() throws Exception{
		List<TestModel> models=new ArrayList<>();
		for(int i=0;i<100000;i++){
			TestModel model=new TestModel();
			model.setAge(i);
			model.setBirthday(new Date());
			model.setCls(String.valueOf(i));
			model.setID(UUID.randomUUID().toString());
			model.setName(UUID.randomUUID().toString());
			model.setID(String.valueOf(i));

			models.add(model);
		}
		String jsonStr= JSON.toJSONString(models);

		File file=new File("test.json");
		FileOutputStream fos=new FileOutputStream(file);
		byte[] js=jsonStr.getBytes("UTF-8");

		fos.write(js);
		fos.close();
	}
@Test
	public void getJSONFile() throws Exception{
		File file=new File("test.json");
		FileInputStream fis=new FileInputStream(file);
		byte[] js=new byte[fis.available()];
		fis.read(js);
		fis.close();
		String jsString=new String(js,"UTF-8");

		List<TestModel> models=JSON.parseArray(jsString,TestModel.class);

		System.out.println(models.size());
	}
	@Test
	public void setData() throws Exception{
		zkUtils.setNode("/cirpc/dnet/prod/redis.model","1234");
	}
}

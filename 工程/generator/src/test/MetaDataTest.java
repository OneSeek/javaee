package test;

import java.util.List;

import org.junit.Test;

import util.JdbcUtil;
import vo.Column;

public class MetaDataTest {
@Test
//��ȡ���ݿ������еı���
	public void test1() throws Exception {		

		List<String> tableList=JdbcUtil.getTables();
		for(String tableName:tableList) {
			System.out.println(tableName);
		}
	}
@Test
//��ȡָ����������ֶ���������
public void test2() throws Exception {		

	List<Column>  columnList=JdbcUtil.getColumns("student");
	for(Column c:columnList) {
		System.out.println(c);
	}
}
}

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.FreemarkerUtil;
import util.JdbcUtil;
import util.PropertyUtil;
import vo.Book;
import vo.Column;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
/* FreeMarker����˼�룺ģ��+����=���
 * generator.propertiesΪ����������
 * FreemarkerUtil�Ǵ���ģ���ļ���������Ĺ����࣬JdbcUtil�Ƕ�ȡ���ݿ�����ݵĹ�����
 * test�����Ƕ���������������Ĳ���ʵ��
 * step1:��дʵ�����ģ���ļ���vo.ftl����������d:/template�£�
 * step2������JdbcUtil��ñ���Ϣ��Ϊģ��׼�������ݣ�Map����
 * step3:����FreemarkerUtil���vo��Դ���뵽ָ��λ�á���d:/output��
 */
	String tableName=PropertyUtil.get("tableName");
	String pk=PropertyUtil.get("package");	
	String templateDir=PropertyUtil.get("templateDir");
	String outputDir=PropertyUtil.get("outputDir");
	FreemarkerUtil util = FreemarkerUtil.getInstance(new File(templateDir));//ģ���ļ���d��templateĿ¼��
	List<String> tableList;
	if("*".equals(tableName)) {//���ݿ������б�����ʵ����
		tableList=JdbcUtil.getTables();
	}
	else {//���Ÿ����ı�����ʵ����
		tableList=new ArrayList<String>();
		String[] tableNames=tableName.split(",");
		for(String tn:tableNames) {

			tableList.add(tn);
		}

	}

	for(String tn:tableList) {//��Ҫ���ÿ��������ʵ���࣬tnΪ����
		
		Map<String, Object> root = new HashMap<String, Object>();
		//׼������


		List<Column> properties = JdbcUtil.getColumns(tn);
		for(Column c:properties) {
			System.out.println(c);
		}

		String fn = "d:/";//���·�� generator.properties������ outputDir
		root.put("package", pk); // ����
		root.put("className", tn); // ���� ����
		root.put("properties", properties); // ����
		tn = tn.substring(0, 1).toUpperCase()+tn.substring(1);// �ļ�������ĸ��д
		util.fprint(root, "vo.ftl", outputDir+"/"+tn+".java");//������ļ���tnΪ����
	}
	
}

}

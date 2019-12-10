package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerUtil
{
	private static FreemarkerUtil util;
	private static Configuration cfg;
	
	private FreemarkerUtil(){
		
	}
	
	public static FreemarkerUtil getInstance(String pname){
		if(util==null){
			 cfg=new Configuration();
			 cfg.setDefaultEncoding("UTF-8");
			 cfg.setClassForTemplateLoading(FreemarkerUtil.class, pname);//����ģ���ļ�����·�����������ļ��������������·����
			 util=new FreemarkerUtil();
		}
		return util;
	}
	
	public static FreemarkerUtil getInstance(File pname) throws Exception{
		if(util==null){
			 cfg=new Configuration();
			 cfg.setDefaultEncoding("UTF-8");
			cfg.setDirectoryForTemplateLoading(pname);//����ģ���ļ�����·�����������ļ���������·����
			 util=new FreemarkerUtil();
		}
		return util;
	}
	/**
	 * ��ȡģ�����
	 * @param fname ģ���ļ�����
	 * @return
	 */
	private Template getTemplate(String fname){//fnameΪģ���ļ�����
		try
		{
			return cfg.getTemplate(fname);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ͨ����׼��������ģ��Ľ��
	 * @param root ���ݶ���
	 * @param fname ģ���ļ���
	 */
	public void sprint(Map<String,Object>root,String fname){
		try
		{
			
			  Writer out = null; 
		      out = new BufferedWriter(new OutputStreamWriter(System.out));  
		      getTemplate(fname).process(root, out);
		         
		}
		catch (TemplateException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * �����ļ����
	 * @param root ���ݶ���
	 * @param fname ģ���ļ���
	 * @param outpath ����ļ�·��
	 */
	public void fprint(Map<String,Object> root, String fname, String outpath){
		try
		{
			
			 Writer out =  new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outpath),"UTF-8")); 
		      getTemplate(fname).process(root,out);
		      out.close();
		      
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (TemplateException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	
}

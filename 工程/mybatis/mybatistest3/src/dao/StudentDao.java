package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import vo.Student;

public interface StudentDao {

	public List<Student> searchStudents1(Map<String, Object> map);//if

	public List<Student> searchStudents2(Map<String, Object> map);//choose

	public List<Student> searchStudents3(Map<String, Object> map);//where

	public List<Student> searchStudents4(Map<String, Object> map);//trim

	public List<Student> searchStudents5(List<Integer> ids);//foreach

	public List<Student> searchStudents6(String name, String  sex);//���������

	public List<Student> searchStudents7(RowBounds rowBounds);//�߼���ҳ

	public List<Student> searchStudents8(Map<String, Object> map);//�����ҳ
	public int updateStudent(Student student);//set��������
}

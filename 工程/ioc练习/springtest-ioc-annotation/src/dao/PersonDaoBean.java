package dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("singleton")
public class PersonDaoBean implements PersonDao {
	public PersonDaoBean() {
		System.out.println("PersonDaoBean���췽��ִ��");
	}
public void save(){
      System.out.println("ִ��PersonDaoBean��save()����"); 
 }

}

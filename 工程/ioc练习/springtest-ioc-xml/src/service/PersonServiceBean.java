package service;

import dao.PersonDao;

public class PersonServiceBean implements PersonService {
	 PersonDao personDao ;
	
	 
	public PersonServiceBean() {
		System.out.println("PersonServiceBean���췽��ִ��");
	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	//����set����ע����������
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void save(){
         personDao.save();
  }


}

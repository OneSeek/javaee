package service;

import org.springframework.stereotype.Service;

//ʹ��jdk��̬����  
@Service(value="aService")
public class AServiceImpl implements AService  {  
  
    public void barA() {  
    	   System.out.println("ִ��barA����");
    	
    }  
  
    public String fooA(String _msg) {  
        System.out.println("ִ��fooA����");
        return "fooA����ַ���";
    }  
}  

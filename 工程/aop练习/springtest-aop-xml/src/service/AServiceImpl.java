package service;

//ʹ��jdk��̬����  
public class AServiceImpl implements AService  {  
  
    public void barA() {  
    	   System.out.println("ִ��barA����");
    }  
  
    public String fooA(String _msg) {  
        System.out.println("ִ��fooA����");
        return "fooA����ַ���";
    }  
}  

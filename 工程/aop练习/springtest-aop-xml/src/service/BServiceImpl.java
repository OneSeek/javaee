package service;

//ʹ��cglib  
public class BServiceImpl {  
  
    public void barB(String _msg, int _type) {  
        System.out.println("ִ��barB����");  
        if (_type == 1)  
            throw new IllegalArgumentException("�����쳣");  
    }  
  
    public String fooB() {  
        System.out.println("ִ��fooB����");  
        return "fooB����ַ���";
    }  
  
}  

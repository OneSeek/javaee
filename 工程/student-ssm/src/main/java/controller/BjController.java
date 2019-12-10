package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.IBjService;
import vo.Bj;


@Controller
@RequestMapping("/bj")
public class BjController  {
	
@Resource
IBjService bjService;
  
    @RequestMapping("/list")
	public String list(Model model) {		
    	
			try {
				List<Bj> bjList=bjService.queryAll();
				model.addAttribute("bjList", bjList);
				return "bj/list";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error";
			}
			
		
	}
    @RequestMapping("/preadd")
   	public String preadd(){
   	
   			return "bj/add";
   		
   	}
    
    @RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Bj bj,Model model){
    
		try {
			bjService.add(bj);
			model.addAttribute("info", "��ӳɹ�");
			return "bj/add";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
    @RequestMapping("/edit")
	public String edit(int id,Model model){
    	
		try {
			Bj bj=bjService.findById(id);
			model.addAttribute("bj", bj);
			return "bj/edit";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
    @RequestMapping("/update")
	public String update(Bj bj,Model model){	
    
		try {			
			
			bjService.update(bj);
			model.addAttribute("info", "���³ɹ�");
			return "bj/edit";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
    @RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id){
    	
		try {
			bjService.delete(id);
			return "redirect:/bj/list.do";		
					
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	

}

package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.DAO;
import data.Person;

@Controller
public class PersonController {
	@Autowired
	private DAO dao;
	
	@RequestMapping("start.do")
	public ModelAndView hi(){
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("Person", dao.getP());
		mv.setViewName("index.jsp");
		return mv;
	}
	

	@RequestMapping("doStuff.do")
	public ModelAndView doStuff(@Valid Person p, Errors errors, @RequestParam("stuff") String stuff){
		ModelAndView mv = new ModelAndView();
		if (errors.getErrorCount() != 0) {
			mv.addObject("Person",new Person());
			mv.setViewName("index.jsp");
			System.out.println("NO");
            return mv;
       }
		System.out.println("YES");
		mv.addObject("Person",p);
		mv.setViewName("result.jsp");
		System.out.println(stuff);
		return mv;

	}

}

package com.nhn.web;

import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nhn.dao.DataDAO;
import com.nhn.service.NewArticleCommand;

@Controller
@RequestMapping("/modifyArticle")
public class ModifyArticleController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView modifyForm(Locale locale, ModelAndView model) {
		
		model = new ModelAndView("modifyArticleForm");
		return model;
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void modifyUpdate(@ModelAttribute("modleAndAttribute") NewArticleCommand modleAndAttribute, HttpServletResponse response) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataDAO datadao = (DataDAO) ac.getBean("DataDAO");
		datadao.modify(modleAndAttribute);
	}
}

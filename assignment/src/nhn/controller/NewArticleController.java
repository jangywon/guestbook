package nhn.controller;

import nhn.service.ArticleService;
import nhn.service.NewArticleCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/newArticle")
public class NewArticleController {
	@Autowired
	private ArticleService articleService;
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		System.out.println("form");
		new JdbcTestClient();
		return "article/newArticleForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void submit(@ModelAttribute("command") NewArticleCommand command) {
		System.out.println("submit");
		articleService.writeArticle(command);
	}
	public void setArticleService(ArticleService articleService) {
		System.out.println("setArticleService");
		this.articleService = articleService;
	}
}
package nhnent;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HelloController {
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("greeting", getGreeting());
		return mav;
	}
	private String getGreeting(){
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	
		return "안녕하세요"+hour;
	}
}

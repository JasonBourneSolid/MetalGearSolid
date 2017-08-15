package metal.gear.model.loginModel.controller;

import metal.gear.model.loginModel.vo.LoginUser;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value="Login/loginValid", method = RequestMethod.POST)
	public String loginValid(ModelAndView model,LoginUser loginUser)
	{
		System.out.println(123);
		/**凭证*/
		UsernamePasswordToken token = null;
		/**主体*/
		Subject subject = null;
		
		subject = SecurityUtils.getSubject();
		token    = new UsernamePasswordToken(loginUser.getName(),loginUser.getPassword());
		
		subject.login(token);
		
		if(subject.isAuthenticated())
		{
			return "mainWindow";
		}
		return "Login";
	}
}

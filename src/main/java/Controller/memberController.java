package Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Factory.SpFactory;
import Factory.implFactory;
import Model.member;

@Controller
@RequestMapping("/member")
public class memberController {
	SpFactory sp = implFactory.a1.getBean("SF", SpFactory.class);

	// 帳號密碼登入-->無session
	@RequestMapping("/login")
	public String login(String username, String password) throws Exception {
		if (sp.getMd().query(username, password)) {
			return "porder/porderManager";
		} else {
			return "member/addmember";
		}

	}

	// 帳號密碼登入-->有session
	@RequestMapping("/login2")
	public String login2(HttpSession session, String username, String password) throws Exception {
		List<member> l = sp.getMd().query2(username, password);

		if (l.size() != 0) {
			member[] m = l.toArray(new member[l.size()]);
			session.setAttribute("M", m[0]);

			return "porder/porderManager";
		} else {
			return "member/addMember";
		}
	}

	@RequestMapping("addmember")
	public String add(HttpServletRequest request, String username) throws Exception {
		if (sp.getMd().queryUsername(username) == true) {
			return "member/ERROR";
		} else {
			String name=request.getParameter("name");
			String Username=request.getParameter("username");
			String password=request.getParameter("password");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			Boolean admin=Boolean.parseBoolean(request.getParameter("admin"));
			
			member m=new member(name,Username,password,phone,address,admin);
			
			sp.getMd().add(m);
			
			return "member/SUCCESS";
		}

	}
	
	@RequestMapping("add")
	public String toAddmember() throws Exception{
		
		return "member/addMember";
	}

}
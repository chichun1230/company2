package Controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Dao.porderDao;
import Factory.SpFactory;
import Factory.implFactory;
import Model.porder;

@Controller
@RequestMapping("/porder")
public class porderController {
	SpFactory f = implFactory.a1.getBean("SF", SpFactory.class);

	@RequestMapping("/add")
	public String add() throws Exception {
		return "porder/addPorder";
	}

	@RequestMapping("/porderManager")
	public String porderManager() throws Exception {
		return "porder/porderManager";
	}

	@RequestMapping("/queryPorder")
	public String queryPorder() throws Exception {
		return "porder/queryPorder";
	}

	@RequestMapping("/updatePorder")
	public String updatePorder() throws Exception {
		return "porder/updatePorder";
	}

	@RequestMapping("/deletePorder")
	public String deletePorder() throws Exception {
		return "porder/deletePorder";
	}

	@RequestMapping("/addPorder")
	public String addPorder(HttpServletRequest request) throws Exception {
		String name = request.getParameter("name");
		int p1 = Integer.parseInt(request.getParameter("p1"));
		int p2 = Integer.parseInt(request.getParameter("p2"));
		int p3 = Integer.parseInt(request.getParameter("p3"));

//		SpFactory s=implFactory.a1.getBean("SF",SpFactory.class);		
//		s.getPd().add(new porder(name,p1,p2,p3,new Date()));

		SpFactory s2 = implFactory.a2.getBean("sf", SpFactory.class);
		s2.getPd().add(new porder(name, p1, p2, p3, new Date()));

		return "porder/porderManager";
	}

	@RequestMapping("/querySum")
	public String querySum(HttpSession session, Integer start, Integer end) {

		if (start != null || end != null) {
			List<Object> l = new porderDao().querySum(start, end);
			porder[] p = l.toArray(new porder[l.size()]);

			session.setAttribute("P", p);
		}
		return "porder/queryPorder";
	}

	@RequestMapping("/updateID")
	public String updateID(HttpServletRequest request, Integer id) throws Exception {

		int p1 = Integer.parseInt(request.getParameter("product1"));
		int p2 = Integer.parseInt(request.getParameter("product2"));
		int p3 = Integer.parseInt(request.getParameter("product3"));
		SpFactory s = implFactory.a1.getBean("SF", SpFactory.class);

		porder p = (porder) s.getPd().query(id);
		p.setProduct1(p1);
		p.setProduct2(p2);
		p.setProduct3(p3);

		p.getSum();

		s.getPd().update(p);

		return "porder/updatePorder";
	}

	@RequestMapping("/deleteId")
	public String deleteId(Integer id) {
		SpFactory s = implFactory.a1.getBean("SF", SpFactory.class);
		porder p = (porder) s.getPd().query(id);

		s.getPd().delete(p);
		return "porder/deletePorder";
	}

	// queryAll
	@RequestMapping("/All")
	@ResponseBody
	public List<Object> getAll() {
		return new porderDao().queryAll();
	}

	// querySum
	@RequestMapping("/Sum")
	@ResponseBody
	public List<Object> getSum() {
		List<Object> l =new porderDao().querySum(1000, 2000);
		return l;
	}
	
	@RequestMapping("/Sum2")
	@ResponseBody
	public List<Object> getSum2(int start,int end) {
		return f.getPd().querySum(start, end);
	}
	
	

}
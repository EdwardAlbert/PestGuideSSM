package bupt.zby.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import bupt.zby.entity.PageBean;
import bupt.zby.entity.Pest;
import bupt.zby.entity.PestQuery;
import bupt.zby.service.PestService;

@Controller
@RequestMapping(value = "/pest")
public class PestAction {
	@Resource(name = "pestService")
	private PestService service;

	@RequestMapping(value = "/test")
	public String test() {
		System.out.println("MVC测试成功");
		return "forward:/index.jsp";
	}

	@RequestMapping(value = "/list")
	public String listPest(PestQuery query, ModelMap map) {
		if (query.getFamily() == null || query.getFamily().equals("0")) {
			query.setFamily("");
		}
		if (query.getCategory() == null || query.getCategory().equals("0")) {
			query.setCategory("");
		}
		/**** 接收用户输入的参数 ： currentPage参数 ****/
		String currentPage = query.getCurrentPage();
		if (currentPage == null || currentPage.equals("")) {
			// 如果用户第一次访问，没有传递currentPage参数，则当前页为1
			query.setCurrentPage("1");
		}
		// 接收用户输入的每页显示记录数
		String pageSize = query.getPageSize();
		// 如果没有传递这个pageSize参数，则为默认值5
		if (pageSize == null || pageSize.equals("")) {
			query.setPageSize("10");
		}
		PageBean pageBean = service.queryPageBean(query);
		map.addAttribute("pageBean", pageBean);
		return "forward:/index.jsp";
	}

	@RequestMapping(value = "/detail")
	public String pestDetail(PestQuery query, ModelMap map) {
		int pestId = Integer.parseInt(query.getPestId());
		Pest pest = service.queryPestById(pestId);
		map.addAttribute("pest", pest);
		return "forward:/Pest.jsp";
	}

}

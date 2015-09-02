package cn.itcast.oa.test;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.oa.domain.Information;

@Controller
@Scope("prototype")
public class TestAction extends ActionSupport {
	
	private static final long serialVersionUID = 6531332631159332192L;

	@Resource
	private TestService testService;

	private Information information;

	@Override
	public String execute() throws Exception {
		System.out.println(information.toString());
		// testService.saveTwoUsers();
		return "success";
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}
}

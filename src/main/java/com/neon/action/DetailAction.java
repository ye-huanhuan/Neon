package com.neon.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neon.base.ActionBase;
import com.neon.domain.Detail;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class DetailAction extends ActionBase<Detail>{

	public String detail(){
		List<Detail> lists = detailService.findAll();
		ActionContext.getContext().put("lists", lists);
		return "detail";
	}
}

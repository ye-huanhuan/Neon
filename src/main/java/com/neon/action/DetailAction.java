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
	
	private String search;

	public String detail(){
		List<Detail> lists = detailService.findAll();
		ActionContext.getContext().put("lists", lists);
		return "detail";
	}
	
	public String sortByTime(){
		List<Detail> lists = detailService.getDetailByTimeSort();
		ActionContext.getContext().put("lists", lists);
		return "detail";
	}
	
	public String sortByMoney(){
		List<Detail> lists = detailService.getDetailByMoneySort();
		ActionContext.getContext().put("lists", lists);
		return "detail";
	}
	
	public String search(){
		List<Detail> lists = detailService.searchDetail(getSearch());
		ActionContext.getContext().put("lists", lists);
		return "detail";
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	
}

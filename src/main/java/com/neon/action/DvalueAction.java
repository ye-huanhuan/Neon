package com.neon.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neon.base.ActionBase;
import com.neon.domain.Dvalue;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class DvalueAction extends ActionBase<Dvalue>{

	public String setDvalue(){
		//准备回显数据
		Long id = dvalueService.getMaxIdInDvalues();
		Dvalue dvalue = dvalueService.getById(id);
		ActionContext.getContext().getValueStack().push(dvalue);
		return "setDvalue";
	}
	
	public String toSetDvalue(){
		Dvalue dvalue = new Dvalue();
		dvalue.setPdvalue_month(model.getPdvalue_month());
		dvalue.setNdvalue_month(model.getNdvalue_month());
		dvalue.setPdvalue_quarter(model.getPdvalue_quarter());
		dvalue.setNdvalue_quarter(model.getNdvalue_quarter());
		dvalue.setPdvalue_year(model.getPdvalue_year());
		dvalue.setNdvalue_year(model.getNdvalue_year());
		Date date = new Date();
		dvalue.setDate(new SimpleDateFormat("yyyy-MM-dd").format(date).toString());
		dvalueService.save(dvalue);
		return "setDvalue";
	}
}

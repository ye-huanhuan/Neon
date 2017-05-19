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
		dvalue.setPdvalue(model.getPdvalue());
		dvalue.setNdvalue(model.getNdvalue());
		Date date = new Date();
		dvalue.setDate(new SimpleDateFormat("yyyy-MM-dd").format(date).toString());
		dvalueService.save(dvalue);
		return "setDvalue";
	}
}

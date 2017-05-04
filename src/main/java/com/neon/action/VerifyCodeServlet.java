package com.neon.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;

public class VerifyCodeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String codeValue = req.getParameter("verifyCode");
        boolean checkRs = SimpleImageCaptchaServlet.validateResponse(req, codeValue);

        resp.setCharacterEncoding("GBK");
        resp.setContentType("text/html");
        resp.getWriter().write("<html><body>");
        if(checkRs){
            resp.getWriter().write("验证成功!");
        }else{
            resp.getWriter().write("验证失败!");
        }
        resp.getWriter().write("<br/><a href='javascript:history.go(-1);'>再试一次</a>");
        resp.getWriter().write("</body></html>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doGet(req, resp);
    }

}

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="bg-dark">
<head>
    <meta charset="utf-8" />
    <title>Notebook | Web Application</title>
    <meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <link rel="stylesheet" href="css/app.v2.css" type="text/css" />

    <script>
        function insertUser() {
            document.getElementById('newUser').innerHTML="<label id='font1' class='control-label' style='display: inline-block;font-size: 16px;'>新账号</label>"+
            "<input id='inputUser' type='text' name='username'  onBlur='validateUser()' placeholder='newUser' class='form-control input-lg' value='<s:property value='username'/>' style='display: inline-block;width: 70%;margin-left: 18px;'>"+
            "<span id='tishi1' style='margin-left: 10px'></span>"
        }
        function insertEmail() {
            document.getElementById('newEmail').innerHTML="<label id='font2' class='control-label' style='display: inline-block;font-size: 16px;'>新邮箱</label>"+
                "<input id='inputEmail' type='text' name='email' onBlur='validateEmail()' placeholder='newEmail' class='form-control input-lg' value='<s:property value='email'/>' style='display: inline-block;width: 70%;margin-left: 18px;'>"+
                "<span id='tishi2' style='margin-left: 10px'></span>"

        }
        function insertPassword() {
            document.getElementById('newPassword').innerHTML="<label id='font3' class='control-label' style='display: inline-block;font-size: 16px;'>新密码</label>"+
                "<input id='inputPassword' type='password' name='password' placeholder='newPassword' class='form-control input-lg' style='display: inline-block;width: 70%;margin-left: 18px;'></br>";
            document.getElementById("confirmPassword").innerHTML="<label id='font4' class='control-label' style='display: inline-block;font-size: 16px;'>确认密码</label>"+
            "<input id='inputConfirmPassword' type='password' onBlur='validate()' placeholder='confirmPassword' class='form-control input-lg' style='display: inline-block;width: 70%;margin-left: 2px;'>"+
            "<span id='tishi3' style='margin-left: 10px'></span>"
        }

        function deleteIserted() {
            var parent1 = document.getElementById("newUser");
            var parent2 = document.getElementById("newEmail");
            var parent3 = document.getElementById("newPassword");
            var parent4 = document.getElementById("confirmPassword");
            var childUser1 = document.getElementById("font1");
            var childUser2 = document.getElementById("inputUser");
            var childEmail1 = document.getElementById("font2");
            var childEmail2 = document.getElementById("inputEmail");
            var childPassword1 = document.getElementById("font3");
            var childPassword2 = document.getElementById("inputPassword");
            var childConfirmPassword1 = document.getElementById("font4");
            var childConfirmPassword2 = document.getElementById("inputConfirmPassword");
            if(childUser1 != null && childUser2 != null){
                parent1.removeChild(childUser1);
                parent1.removeChild(childUser2);
            }
            if(childEmail1 != null && childEmail2 != null){
                parent2.removeChild(childEmail1);
                parent2.removeChild(childEmail2);
            }
            if(childPassword1 != null && childPassword2 != null && childConfirmPassword1 != null && childConfirmPassword2 != null){
                parent3.removeChild(childPassword1);
                parent3.removeChild(childPassword2);
                parent4.removeChild(childConfirmPassword1);
                parent4.removeChild(childConfirmPassword2);
            }
        }
        
        //验证密码与确认密码
        function validate() {
            var pwd1 = document.getElementById("inputPassword").value;
            var pwd2 = document.getElementById("inputConfirmPassword").value;
            //对比两次密码是否相同
            if(pwd1 == "" || pwd2 == ""){
            	document.getElementById("tishi3").innerHTML="<font color='red'>密码不能为空</font>";
                document.getElementById("submit").disabled = true;
            }else{
            	if(pwd1 === pwd2) {
               		document.getElementById("tishi3").innerHTML="<font color='green'>两次密码相同</font>";
                	document.getElementById("submit").disabled = false;
            	}
            	else if(pwd1 != pwd2){
                	document.getElementById("tishi3").innerHTML="<font color='red'>两次密码不相同</font>";
                	document.getElementById("submit").disabled = true;
            	}
            }
        }
        
        //验证修改后的用户名和邮箱是否为空
        function validateUser() {
            var user = document.getElementById("inputUser").value;
            
            if(user == "") {
                document.getElementById("tishi1").innerHTML="<font color='red'>用户名不能为空</font>";
                document.getElementById("submit").disabled = true;
            }
            
        }
        function validateEmail() {
        	var email = document.getElementById("inputEmail").value;
        	
        	if(email == ""){
                document.getElementById("tishi2").innerHTML="<font color='red'>邮箱不能为空</font>";
                document.getElementById("submit").disabled = true;
            }
        }
    </script>
</head>
<body>

<section id="content" class="m-t-lg wrapper-md animated fadeInUp">
    <div class="container aside-xxl"> <a class="navbar-brand block" href="#" style="font-size: 24px">账号中心</a>

        <section class="panel panel-default bg-white m-t-lg" style="width: 670px;">

            <form id="form" action="user_toSetUp.action" class="panel-body wrapper-lg" style="width: auto">
                <div class="form-group">
                    <label class="control-label" style="display: inline-block;font-size: 16px">账户</label>
                    <input type="text" placeholder="User" class="form-control input-lg" readonly="readonly" value="<s:property value="username"/>" style="display: inline-block;width: 70%;margin-left: 30px;">
                    <a href="#" style="margin-left: 10px" onclick="insertUser()">修改账号</a>
                </div>
                <div id="newUser" class="form-group">
                </div>
                <div class="form-group">
                    <label class="control-label" style="display: inline-block;font-size: 16px">邮箱</label>
                    <input type="text" placeholder="Email" class="form-control input-lg" readonly="readonly" value="<s:property value="email"/>" style="display: inline-block;width: 70%;margin-left: 30px;">
                    <a href="#" style="margin-left: 10px" onclick="insertEmail()">修改邮箱</a>
                </div>
                <div id="newEmail" class="form-group">
                </div>
                <div class="form-group">
                    <label class="control-label" style="display: inline-block;font-size: 16px">密码</label>
                    <input type="password" placeholder="Password" class="form-control input-lg" readonly="readonly" value="<s:property value="password"/>" style="display: inline-block;width: 70%;margin-left: 30px;">
                    <a href="#" style="margin-left: 10px" onclick="insertPassword()">修改密码</a>
                </div>
                <div id="newPassword" class="form-group">
                </div>
                <div id="confirmPassword" class="form-group">
                </div>
                <button type="submit" id="submit" class="btn btn-primary">保存</button>
                <button type="reset" class="btn btn-primary" style="margin-left: 20px" onclick="deleteIserted()">取消</button>
            </form>

        </section>

    </div>
</section>

<script src="js/app.v2.js"></script>
</body>
</html>

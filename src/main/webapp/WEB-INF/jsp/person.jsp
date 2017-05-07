<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            "<input id='inputUser' type='text' name='newUser' placeholder='newUser' class='form-control input-lg' style='display: inline-block;width: 70%;margin-left: 18px;'>"
        }
        function insertEmail() {
            document.getElementById('newEmail').innerHTML="<label id='font2' class='control-label' style='display: inline-block;font-size: 16px;'>新邮箱</label>"+
                "<input id='inputEmail' type='text' name='newEmail' placeholder='newEmail' class='form-control input-lg' style='display: inline-block;width: 70%;margin-left: 18px;'>"

        }
        function insertPassword() {
            document.getElementById('newPassword').innerHTML="<label id='font3' class='control-label' style='display: inline-block;font-size: 16px;'>新密码</label>"+
                "<input id='inputPassword' type='text' name='newPassword' placeholder='newPassword' class='form-control input-lg' style='display: inline-block;width: 70%;margin-left: 18px;'></br>"
            document.getElementById("confirmPassword").innerHTML="<label id='font4' class='control-label' style='display: inline-block;font-size: 16px;'>确认密码</label>"+
            "<input id='inputConfirmPassword' type='text' name='confirmPassword' placeholder='confirmPassword' class='form-control input-lg' style='display: inline-block;width: 70%;margin-left: 2px;'>"
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
    </script>
</head>
<body>

<section id="content" class="m-t-lg wrapper-md animated fadeInUp">
    <div class="container aside-xxl"> <a class="navbar-brand block" href="#" style="font-size: 24px">账号中心</a>

        <section class="panel panel-default bg-white m-t-lg" style="width: 670px;">

            <form id="form" action="index.html" class="panel-body wrapper-lg" style="width: auto">
                <div class="form-group">
                    <label class="control-label" style="display: inline-block;font-size: 16px">账户</label>
                    <input type="text" placeholder="User" class="form-control input-lg" readonly="readonly" style="display: inline-block;width: 70%;margin-left: 30px;">
                    <a href="#" style="margin-left: 10px" onclick="insertUser()">修改账号</a>
                </div>
                <div id="newUser" class="form-group">
                </div>
                <div class="form-group">
                    <label class="control-label" style="display: inline-block;font-size: 16px">邮箱</label>
                    <input type="text" placeholder="Email" class="form-control input-lg" readonly="readonly" style="display: inline-block;width: 70%;margin-left: 30px;">
                    <a href="#" style="margin-left: 10px" onclick="insertEmail()">修改邮箱</a>
                </div>
                <div id="newEmail" class="form-group">
                </div>
                <div class="form-group">
                    <label class="control-label" style="display: inline-block;font-size: 16px">密码</label>
                    <input type="text" placeholder="Password" class="form-control input-lg" readonly="readonly" style="display: inline-block;width: 70%;margin-left: 30px;">
                    <a href="#" style="margin-left: 10px" onclick="insertPassword()">修改密码</a>
                </div>
                <div id="newPassword" class="form-group">
                </div>
                <div id="confirmPassword" class="form-group">
                </div>
                <button type="submit" class="btn btn-primary">保存</button>
                <button type="reset" class="btn btn-primary" style="margin-left: 20px" onclick="deleteIserted()">取消</button>
            </form>

        </section>

    </div>
</section>

<script src="js/app.v2.js"></script>
</body>
</html>

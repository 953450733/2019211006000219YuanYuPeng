<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2021/3/11
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
    <style type="text/css">
    </style>
    <script type="text/javascript">function createCode() {
        //创建随机4位数字，math.floor向下取整
        const code = Math.floor(Math.random() * 9000 + 1000);
        //获取元素对象
        const span = document.getElementById("codeSpan");
        //将数字存放到span中

    }

    //验证用户名
        function checkUname(){
            //获取用户获得用户名信息
            const uname = document.getElementById("uname").value;
            //创建校验规则,用户名2-4个
            const reg = true;
            //获取span对象
            const unameSpan = document.getElementById("unameSpan");
            //开始交验
            if(unameSpan===""||unameSpan==null){
                //输入校验结果
                unameSpan.innerHTML="*用户名不能为空";
                unameSpan.style.color="red";
                return false;
            }else if(reg.test(uname)){
                //输入校验结果
                unameSpan.innerHTML="*用户名通过";
                unameSpan.style.color="green";
                return true;
            }else{
                //输入校验结果
                unameSpan.innerHTML="*用户名格式不符"
                unameSpan.style.color="red";
                return false;
            }

        }
        //验证密码
        function checkPwd(){
            //获取用户获得用户名信息
            const upwd = document.getElementById("pwd").value;

            const reg = /^[a-zA-Z0-9]\w{7,100}$/;
            //获取span对象
            const span = document.getElementById("pwdSpan");
            //开始交验
            if(span===""||span==null){
                //输入校验结果
                span.innerHTML="*password can not null";
                span.style.color="red";
                return false;
            }else if(reg.test(upwd)){
                //输入校验结果
                span.innerHTML="*password is right";
                span.style.color="green";
                return true;
            }else{
                //输入校验结果
                span.innerHTML="*password is wrong"
                span.style.color="red";
                return false;
            }

        }
        //校验邮箱
        function checked(){
            return checkField("mail",/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/)
        }

        //提交判断
        function checkSub(){
            checkUname();
            checkPwd();
            checked();
            return checkUname()&&checkPwd()&&checked();
        }
        //----------------------------------------------------------------------------------------------------------------------
        //封装校验：相同的保留，不同的传参
        function checkField(id,reg){
            //获取用户数据
            const inp = document.getElementById(id);
            const va = inp.value;
            const alt = inp.alt;
            //创建校验规则
            //获取span对象
            const span = document.getElementById(id + "Span");
            //开始校验
            if(va==""||va==null){
                //输入校验结果
                span.innerHTML="*"+alt+"不能为空";
                span.style.color="red";
                return false;
            }else if(reg.test(va)){
                //输入校验结果
                span.innerHTML="*"+alt+"通过";
                span.style.color="green";
                return true;
            }else{
                //输入校验结果
                span.innerHTML="*"+alt+"格式不符";
                span.style.color="red";
                return false;
            }
        }
    </script>
</head>
<body onload="createCode()">
<h3 align="center">Register</h3>
<hr />

    <form action="#" method="get" onsubmit="return checkSub()">
        <table border="0px" cellspacing="0" cellpadding="2px" align="center">
            <tr>
                <td width="80px">Username：</td>
                <td width="400px">
                    <input type="text" name="uname" id="uname" value="" onblur="checkUname()" alt="Username"/>
                    <span id="unameSpan">
							<font>required</font>
						</span>
                </td>
            </tr>
            <tr>
                <td>Password：</td>
                <td>
                    <input type="password" name="pwd" id="pwd" value="" onblur="checkPwd()"/>
                    <span id="pwdSpan">
						<font>length must be at least 8 characters</font>
						</span>
                </td>
            </tr>

            <tr>
                <td>Email：</td>
                <td>
                    <input type="text" name="mail" id="mail" value="" alt="Email" onblur="checked()"/>
                    <span id="mailSpan">
                        <font>Valid email</font>
                    </span>
                </td>
            </tr>

            <tr>
                <td>Birthdate：</td>
                <td>
                    <input type="text" name="Birthdate" formate='YYYY-MM-DD'><br/>
                    <span id="Birthdate">
                        <font>Must be yyyy-dd-mm format</font>
                    </span>
                </td>
            </tr>
            <tr>
                <td>Sex</td>
                <td>
                    <label for="Radio1">Male</label><input id="Radio1" type="radio" value="Male" name="Sex" checked="checked"/>
                    <label for="Radio2">Female</label><input id="Radio2" type="radio" value="Female" name="Sex"   /><br/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Register"/>
                </td>
            </tr>
        </table>
    </form>

</body>
</html>

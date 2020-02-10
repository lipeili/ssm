<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<body>
    <input  id="add" type="submit" value="新增" >
    <table >
        <tr>
            <td>姓名</td>
            <td>余额</td>
            <td>卡号</td>
        </tr>
        <c:forEach items="${accounts}" var="item" varStatus="status">
            <form action="/account/delete" id="${item.name}">
                <tr>
                    <td>${item.name}<input type="text" name="name" value="${item.name}" hidden="hidden"></td>
                    <td>${item.money}<input type="text" name="money" value="${item.money}" hidden="hidden"></td>
                    <td>${item.cardNo}<input type="text" name="cardNo" value="${item.cardNo}" hidden="hidden"></td>

                    <td><input  type="submit" value="删除"></td>
                    <td><input  type="submit" class="update" value="修改" id="${item.name}" ></td>
                </tr>
            </form>
        </c:forEach>
    </table>

    <div id = "additionPan" style="display: none;">
        <form action="/account/add">
            姓名 :<input type="text" name="name"><br><br>
            余额 :<input type="text" name="money"><br><br>
            卡号 :<input type="text" name="cardNo"><br><br>
            <input  type="submit" >
        </form>
    </div>

    <div id = "updatePan" style="display: none;">
        <form action="/account/update">
            姓名 :<input id="updateName" type="text" name="name" readonly="readonly"><br><br>
            余额 :<input id="updateMoney" type="text" name="money"><br><br>
            卡号 :<input id="updateCardNo" type="text" name="cardNo"><br><br>
            <input  type="submit" >
        </form>
    </div>
</body>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script>
    $(function () {

        $(".update").bind("click",function () {
            var val = $(this).attr("id");
            // 发送ajax请求
            $.ajax({
                url: '/account/queryDetail?' + "name=" + val,
                type: 'GET',
                // data: '{"id":"1","name":"李四"}',
                // contentType: 'application/json;charset=utf-8',
                dataType: 'json',
                success: function (data) {
                    $("#updateName").val(data.name);
                    $("#updateMoney").val(data.money);
                    $("#updateCardNo").val(data.cardNo);
                    $("#updatePan").attr("style","display:block;");//显示div
                }
            })
            return false;
        })
    })


    $(function () {
        $("#add").bind("click",function () {
            // $("#addition").style.display="";
            $("#additionPan").attr("style","display:block;");//显示div
        })
    })

</script>

</html>
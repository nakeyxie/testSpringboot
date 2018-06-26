<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>请填写id和名字</title>
</head>
<script type="text/javascript">
    function check() {
        var param={};
        var name = $("#name").val();
        var strId = $("#strId").val();
        if(strId==''){
            alert("id为空！");
            $("#strId").focus();
            return false;
        }
        param['strId'] =strId;
        if(name==''){
            alert("名字为空！");
            $("#name").focus();
            return false;
        }
        param['name'] =name;
        $.ajax({
            type: "GET",
            url: "localhost:8080/putParam",
            data: JSON.stringify(param),
            dataType:JSON,
            async: false,
            success: function (resp) {
                if (resp.errorCode == "0") {
                    $.messager.alert("提示", "提交成功");
                } else {
                    $.messager.alert("提示", "提交失败:" + result.errMsg);
                }
            }

        });
        return ture;
    }

    function check1() {
        var param={};
        var name = document.getElementById("name").value;
        var strId =document.getElementById("strId").value;
        if(strId==''){
            alert("id为空！");
            $("#strId").focus();
            return false;
        }
        param['strId'] =strId;
        if(name==''){
            alert("名字为空！");
            $("#name").focus();
            return false;
        }
        param['name'] =name;
        $.ajax({
            type: "GET",
            url: "localhost:8080/putParam",
            data: JSON.stringify(param),
            dataType:JSON,
            async: false,
            success: function (resp) {
                if (resp.errorCode == "0") {
                    $.messager.alert("提示", "提交成功");
                } else {
                    $.messager.alert("提示", "提交失败:" + result.errMsg);
                }
            }

        });      //发送
        return ture;
    }

</script>
<body>
<form >
    <table>
        <tr style="height: 40px">
            <td align="center"> <label >id：</label></td>
            <td align="center"> <input id="strId" type=text name="strId" size="18" value=""><br/></td>
        </tr>
        <tr style="height: 40px">
            <td align="center"><label style="">名字：</label></td>
            <td align="center">  <input id="name" type=text name="name" size="18" value=""><br/></td>
        </tr>
    </table>
    <!--<label >id：</label>
    <input type=text name="strId" size="18" value=""><br/>
    <br/>
    <label style="">名字：</label>
    <input type=text name="name" size="18" value=""><br/>-->
   <button  onclick="check1()">提交</button>
</form>

</body>
</html>

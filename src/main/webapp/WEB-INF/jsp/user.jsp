<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>请填写id和名字</title>
</head>
<script type="text/javascript">
   function check(from) {
       if(from.strId.value() && form.strId.value()==''){
           alert("id为空！");
           from.strId.focus();
           return false;
       }
       if(form.name.value()==''){
           alert("名字为空！");
           from.name.focus();
           return false;
       }
       return ture;
   }

</script>
<body>
  <form  action="putParam" method="get" onsubmit="return check(this)">
      <table>
          <tr style="height: 40px">
              <td align="center"> <label >id：</label></td>
              <td align="center"> <input type=text name="strId" size="18" value=""><br/></td>
          </tr>
          <tr style="height: 40px">
              <td align="center"><label style="">名字：</label></td>
              <td align="center">  <input type=text name="name" size="18" value=""><br/></td>
          </tr>
      </table>
      <!--<label >id：</label>
      <input type=text name="strId" size="18" value=""><br/>
      <br/>
      <label style="">名字：</label>
      <input type=text name="name" size="18" value=""><br/>-->
      <input  type="submit" name="submit1" value="提交">
      <input type="reset" value="重置" />
  </form>

</body>
</html>

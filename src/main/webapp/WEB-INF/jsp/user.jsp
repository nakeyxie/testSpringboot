<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请填写id和名字</title>
</head>
<script type="text/javascript">
   function check(from) {
       if(form.ids.value()==''){
           alert("id为空！");
           from.ids.focus();
           return false;
       }
       if(form.name.value()==''){
           alert("名字为空！");
           from.name.focus();
           return false;
       }
       return ture
   }

</script>
<body>
  <form  action="putParam" method="get" onsubmit="return check(this)">
    id:
      <input type=text name="ids" size="18" value=""><br>
    名字:
      <input type=text name="name" size="18" value=""><br>
      <input  type="submit" name="submit1" value="登录">
  </form>

  ------------------------------------------------------
    <label>id:</label><input/><br/>
    <label>名字:</label><input/><br/>
    <button>submit</button>
    <button>清空</button>
</body>
</html>

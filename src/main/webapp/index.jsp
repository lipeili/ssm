<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<body>
<form method="post" action="/account/login">
    name  : <input  type="text" name="name">
    passwd: <input  type="text" name="passwd">
    <input  type="submit" id="ajaxBtn">
</form>
${msg}

</body>
<script type="text/javascript" src="/js/jquery.min.js"/>
<script>
    alert(${msg});
</script>
</html>

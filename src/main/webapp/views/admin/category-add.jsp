<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<form action="<c:url value="/admin/category/insert"/>" method="post" enctype="multipart/form-data">
  <label for="fname">Category Name: </label><br>
  <input type="text" id="categoryname" name="categoryname"><br>
  <label for="lname">Link Images</label><br>
  <input type="text" id="images" name="images"><br>
  
  <label for="lname">Upload File: </label><br>
  <input type="file" id="images1" name="images1"><br>
  
  <label for="lname">Status</label><br>
  <input type="radio" id="ston" name="status" value="1">
  <label for="css">Hoạt động</label><br>
  <input type="radio" id="stoff" name="status" value="0">
  <label for="javascript">Khóa</label><br>
  <hr>
  <input type="submit" value="Insert"><br>
</form>

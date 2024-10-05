<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<form action="<c:url value='/admin/category/update'/>" method="post" enctype="multipart/form-data">
  <input type="hidden" name="categoryid" value="${cate.categoryid}">
  <label for="categoryname">Category Name: </label><br>
  <input type="text" id="categoryname" name="categoryname" value="${cate.categoryname}"><br>

  <label for="images">Link Images: </label><br>
  <input type="text" id="images" name="images" value="${cate.images}"><br>

  <label for="images1">Upload File: </label><br>
  <input type="file" id="images1" name="images1"><br>

  <label>Status:</label><br>
  <input type="radio" id="ston" name="status" value="1" ${cate.status == 1 ? 'checked' : ''}> Hoạt động<br>
  <input type="radio" id="stoff" name="status" value="0" ${cate.status != 1 ? 'checked' : ''}> Khóa<br>

  <input type="submit" value="Update">
</form>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="<%request.getContextPath();%>/css/bootstrap.min.css" crossorigin="anonymous">
    <script type="text/javascript" src="<%request.getContextPath();%>/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="<%request.getContextPath();%>/js/bootstrap.bundle.min.js"></script>

    <!--  -->
</head>
<body>
<div class="row border">
    <div class="col-12">
        <h5 class="ml-1">文件管理</h5>
    </div>
</div>
<div class="row ">
     <div>
         <form action=""  method="post" >
          <input name="fName" placeholder="请输入文件名">
             <button type="button" class="btn btn-secondary btn-sm" >搜索</button>
         </form>
     </div>
</div>
<div class="row">
    <div class="col-12">

        <table class="table" id="table">
            <thead>
            <tr>
                <th scope="col"><input type="checkbox" name="ids" /></th>
                <th scope="col">标题</th>
                <th scope="col">创建时间</th>
                <th scope="col">创建人</th>
                <th scope="col">描述</th>
                <th scope="col">文件大小</th>
                <th scope="col">文件后缀</th>
                <th scope="col">操作</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${list.list}" var="str">
                    <tr>
                        <th scope="row"><input type="checkbox" name="ids"  value="${str.fId}" /></th>
                        <td>${str.fName}</td>
                        <td><fmt:formatDate value="${str.fDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                        <td>${str.fPerpson}</td>
                        <td>${str.fShow}</td>
                        <td>${str.fSize}</td>
                        <td>${str.fFfiux}</td>
                        <td>  <a href="/files/download?id=${str.fId}" type="button" class="btn btn-primary"  >下载 </a>
                            <button type="button" class="btn btn-secondary btn-sm" onclick="deleterow(this)">删除</button>
                        <td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="row">
    <div class="col-4">
        当前显示<b>${list.startRow}</b>~~<b>${list.endRow}</b>条数据，共<b>${list.total}</b>条
        当前第${list.pageNum}页，共${list.pages}页
    </div>
    <div class="col-8" >
        <ul class="list-inline pagination text-center">
            <li   class="list-inline-item disabled"><a id="li1" onclick="tage1()" href="/post/selectall?pagenum=${list.pageNum-1}"><i  class="fa fa-chevron-left fa-lg"></i>上一页</a></li>
            <li class="list-inline-item"><a id="li2" onclick="tage1()" href="/post/selectall?pagenum=${list.pageNum+1}"><i class="fa fa-chevron-right fa-lg"></i>下一页 </a></li>
        </ul>
    </div>
</div>
<div class="row">
     <div class="col-3">
         <form action="/files/add" method="post" enctype="multipart/form-data">
             <fieldset class="border">
                 <legend>文件上传</legend>
                 <div class="form-group">
                     <label for="text1">文件名</label>
                     <input name="fName" class="form-control" id="text1" placeholder="文件名">
                 </div>
                 <div class="form-group">
                     <label for="text3">文件描述</label>
                     <textarea id="text3" class="h-50 w-100" name="fShow"></textarea>
                 </div>
                 <div class="form-group">
                     <label for="text2">选择文件</label>
                     <input type="file" class="form-control" name="file" id="text2" >
                 </div>
                 <div class="form-group text-center">
                     <button type="submit" class="btn btn-primary btn-sm" >上传</button>
                 </div>
             </fieldset>
         </form>
     </div>
</div>
</body>
<script type="text/javascript">
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }

    function deleterow(obj) {
        var index = obj.parentNode.parentNode;
        var table = document.getElementById("table");
        var id = index.childNodes[1].childNodes[0].value;

        table.deleteRow(index.rowIndex);
        xmlhttp.open("get","/files/delete?id=" + id, true);
        xmlhttp.send();
        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                alert(xmlhttp.responseText);
            }
        }
    }

    function tage1() {
        var li1=document.getElementById("li1");
        var li2=document.getElementById("li2");
        if(${list.pageNum<=1}) {
            li1.style.visibility = "hidden";
        }

      if(${list.pageNum==list.pages}){
          li2.style.visibility="hidden";
      }

    }
</script>
</html>


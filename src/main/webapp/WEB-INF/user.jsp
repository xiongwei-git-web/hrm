<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/20
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>

    <link rel="stylesheet" type="text/css" href="<%request.getContextPath();%>/css/bootstrap.min.css" />
    <script type="text/javascript" src="<%request.getContextPath();%>/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="<%request.getContextPath();%>/js/bootstrap.bundle.min.js"></script>
    <!---->
</head>
<body>
<div class="row border">
    <div class="col-12">
        <h5 class="ml-1">用户管理</h5>
    </div>
</div>
<div class="row  border ">
    <div class="col-2">
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" >添加用户</button>
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">添加用户</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="/user/add" method="post">
                      <div class="modal-body">

                            <div class="form-group">
                                <label for="text1" class="col-form-label">账号</label>
                                <input type="text"  name="uLogin" class="form-control" id="text1">
                            </div>
                            <div class="form-group">
                                <label for="text2" class="col-form-label">密码</label>
                                <input type="text"   class="form-control" name="uPass" id="text2">
                            </div>
                            <div class="form-group">
                                <label for="text3" class="col-form-label">用户名</label>
                                <input type="text" class="form-control"   name="uName" id="text3">
                                <input type="hidden" name="uState"  id="text5" value="2">
                            </div>
                            <div class="form-group">
                                <label for="text4" class="col-form-label">创建时间</label>
                                <input type="text" name="uDate"  class="form-control" id="text4" placeholder="2020-05-11">
                            </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                        <input type="submit" class="btn btn-secondary"  value="提交">
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="col-5 ">
        <form action="/user/selectname" method="post">

        <div class="input-group ">
            <span class="input-group-append align-items-center ">搜索：</span>
            <input type="text" name="name" class="form-control" placeholder="请输入搜索用户的姓名">
            <input type="text" name="start" class="form-control ml-2" placeholder="请输入搜索用户的状态">
            <div class="input-group-append">
                <button type="submit" class="btn btn-primary">搜索</button>
                <button type="button" class="btn btn-primary ml-3" onclick="deletes()">点我批量删除</button>
            </div>
        </div>
        </form>
    </div>
</div>
<div class="row">
    <div class="col-12">

            <table class="table" id="table">
                <thead>
                <tr>
                    <th scope="col"><input type="checkbox" name="ids" /></th>
                    <th scope="col">账号</th>
                    <th scope="col">密码</th>
                    <th scope="col">用户名</th>
                    <th scope="col">状态</th>
                    <th scope="col">报名日期</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list.list}" var="str" >
                <form id="formid" action="/user/deletes" method="post">
                <tr>
                    <th scope="row"><input type="checkbox" name="ids"  value="${str.uId}" /></th>
                    <td>${str.uLogin}</td>
                    <td>${str.uPass}</td>
                    <td>${str.uName}</td>
                    <td>${str.uState}</td>
                    <td> <fmt:formatDate value="${str.uDate}" pattern="yyyy-MM-dd" /> </td>
                    </form>
                    <td> <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#update"  onclick="update(this)">修改</button>
                        <div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="text6" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="text6">修改用户</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <form action="/user/update" method="post">
                                        <div class="modal-body">

                                            <div class="form-group">
                                                <label for="text7" class="col-form-label">账号</label>
                                                <input type="text"  name="uLogin" class="form-control" id="text7">
                                            </div>
                                            <div class="form-group">
                                                <label for="text8" class="col-form-label">密码</label>
                                                <input type="text"   class="form-control" name="uPass" id="text8">
                                            </div>
                                            <div class="form-group">
                                                <label for="text9" class="col-form-label">用户名</label>
                                                <input type="text" class="form-control"   name="uName" id="text9">
                                            </div>

                                            <div class="form-group">
                                                <input type="hidden" name="uId" id="text12"  >
                                                <label for="text10" class="col-form-label">状态</label>
                                                <input type="text" class="form-control"   name="uState" id="text10">
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                            <input type="submit" class="btn btn-secondary"  value="提交">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <button type="button" lass="btn btn-secondary btn-sm" onclick="deleterow(this)">删除</button>
                    </td>
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
            <li   class="list-inline-item disabled"><a id="li1" onclick="tage1()" href="/user/seleatall?pagenum=${list.pageNum-1}"><i class="fa fa-chevron-left fa-lg"></i>上一页</a></li>
            <li class="list-inline-item"><a id="li2" onclick="tage1()" href="/user/seleatall?pagenum=${list.pageNum+1}"><i class="fa fa-chevron-right fa-lg"></i>下一页 </a></li>
        </ul>
    </div>

</div>
<script type="text/javascript">
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    function update(obj) {
      var users= obj.parentNode.parentNode.childNodes;
      var name=document.getElementById("text9");
      var user=document.getElementById("text7");
      var pass=document.getElementById("text8");
      var state=document.getElementById("text10");
      var id=document.getElementById("text12");
       user.value = users[3].innerHTML;
       pass.value=users[5].innerHTML;
       name.value=users[7].innerHTML;
       state.value=users[9].innerHTML;
       id.value=users[1].childNodes[0].value;
    }
    function deleterow(obj) {
        var index = obj.parentNode.parentNode;
        var table = document.getElementById("table");
        var id = index.childNodes[1].childNodes[0].value;
        console.log(id);
        table.deleteRow(index.rowIndex);
        xmlhttp.open("get", "/user/delete?id=" + id, true);
        xmlhttp.send();
        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                alert(xmlhttp.responseText);
            }
        }
    }
    function deletes(){
        document.getElementById("formid").submit();
    }
    function tage1() {
        var li1=document.getElementById("li1");
        var li2=document.getElementById("li2");
        <c:if test="${list.pageNum<=1}">
        li1.style.visibility="hidden";
        </c:if>
        <c:if test="${list.pageNum==list.pages}">
        li2.style.visibility="hidden";
        </c:if>
    }
</script>
</body>
</html>


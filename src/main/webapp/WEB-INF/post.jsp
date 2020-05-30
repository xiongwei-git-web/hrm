<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <h5 class="ml-1">部门管理</h5>
    </div>
</div>
<div class="row  border ">
    <div class="col-2">
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" >添加部门</button>
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">添加职位</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="/post/add" method="post">
                        <div class="modal-body">

                            <div class="form-group">
                                <label for="text1" class="col-form-label">职位名称</label>
                                <input type="text"  name="pName" class="form-control" id="text1">
                            </div>
                            <div class="form-group">
                                <label for="text2" class="col-form-label">职位详情</label>
                                <input type="text"   class="form-control" name="pShow" id="text2">
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
        <form action="/post/selectname" method="post">
            <div class="input-group ">
                <span class="input-group-append align-items-center ">搜索：</span>
                <input type="text" name="pName" class="form-control" placeholder="请输入搜索职位的名称">
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
                <th scope="col">职位名称</th>
                <th scope="col">职位详情</th>
                <th scope="col">操作</th>
            </tr>

            </thead>
            <tbody>
            <form id="formid" action="/post/deletes" method="post">
                <c:forEach items="${list.list}" var="str">
                    <tr>
                        <th scope="row"><input type="checkbox" name="ids"  value="${str.pId}" /></th>
                        <td>${str.pName}</td>
                        <td>${str.pShow}</td>

                        <td>  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#update" onclick="update(this)">修改</button>
                            <button type="button" class="btn btn-secondary btn-sm" onclick="deleterow(this)">删除</button>
                        <td>
                    </tr>
                </c:forEach>
            </form>
            </tbody>
            <div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="updates" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="updates">修改职位</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form action="/post/update" method="post">
                            <div class="modal-body">

                                <div class="form-group">
                                    <label for="text1" class="col-form-label">职位名称</label>
                                    <input type="text"  name="pName" class="form-control" id="text3">
                                </div>
                                <div class="form-group">
                                    <label for="text2" class="col-form-label">职位详情</label>
                                    <input type="text"   class="form-control" name="pShow" id="text4">
                                    <input type="hidden" name="pId" id="text5">
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
            <li   class="list-inline-item disabled"><a id="li1" onclick="tage1()" href="/post/selectall?pagenum=${list.pageNum-1}"><i class="fa fa-chevron-left fa-lg"></i>上一页</a></li>
            <li class="list-inline-item"><a id="li2" onclick="tage1()" href="/post/selectall?pagenum=${list.pageNum+1}"><i class="fa fa-chevron-right fa-lg"></i>下一页 </a></li>
        </ul>
    </div>

</div>

</body>
<script type="text/javascript">
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    function update(obj) {
        var section= obj.parentNode.parentNode.childNodes;
        var name=document.getElementById("text3");
        var show=document.getElementById("text4");
        var id=document.getElementById("text5");
        console.log(section);
        show.value = section[5].innerHTML;
        name.value=section[3].innerHTML;
        id.value=section[1].childNodes[0].value;
    }
    function deleterow(obj) {
        var index = obj.parentNode.parentNode;
        var table = document.getElementById("table");
        var id = index.childNodes[1].childNodes[0].value;

        table.deleteRow(index.rowIndex);
        xmlhttp.open("get","/post/delete?id=" + id, true);
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
</html>


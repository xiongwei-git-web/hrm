<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <h5 class="ml-1">公告管理</h5>
    </div>
</div>
<div class="row  border ">
    <div class="col-2">
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" >添加部门</button>
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">添加公告</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="/notice/add" method="post">
                        <div class="modal-body">

                            <div class="form-group">
                                <label for="text1" class="col-form-label">公告名称</label>
                                <input type="text"  name="nName" class="form-control" id="text1">
                            </div>
                            <div class="form-group">
                                <label for="text2" class="col-form-label">公告内容</label>
                                <input type="text"   class="form-control" name="nShow" id="text2">
                            </div>
                            <div class="form-group">
                                <label for="text1" class="col-form-label">公告发布时间</label>
                                <input type="text"  name="nDate" class="form-control" id="text3" placeholder="格式2010-08-09">
                            </div>
                            <div class="form-group">
                                <label for="text2" class="col-form-label">公告发布人</label>
                                <input type="text"   class="form-control" name="nPerpson" id="text4">
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
        <form action="/notice/selename" method="post">
            <div class="input-group ">
                <span class="input-group-append align-items-center ">搜索：</span>
                <input type="text" name="nName" class="form-control" placeholder="请输入搜索公告的名称">
                <input type="text" name="nShow" class="form-control" placeholder="请输入搜索公告的内容">
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
                <th scope="col">公告名称</th>
                <th scope="col">公告内容</th>
                <th scope="col">公告发布时间</th>
                <th scope="col">公告发布人</th>
                <th scope="col">操作</th>
            </tr>

            </thead>
            <tbody>
            <form id="formid" action="/notice/deletes" method="post">
                <c:forEach items="${list.list}" var="str">
                    <tr>
                        <th scope="row"><input type="checkbox" name="ids"  value="${str.nId}" /></th>
                        <td>${str.nName}</td>
                        <td>${str.nShow}</td>
                        <td><fmt:formatDate value="${str.nDate}" pattern="yyyy-MM-dd"/></td>
                        <td>${str.nPerpson}</td>
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
                            <h5 class="modal-title" id="updates">修改公告</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form action="/notice/update" method="post">
                            <div class="modal-body">

                                <div class="form-group">
                                    <label for="text6" class="col-form-label">公告名称</label>
                                    <input type="text"  name="nName" class="form-control" id="text6">
                                </div>
                                <div class="form-group">
                                    <label for="text7" class=n"col-form-label">公告详情</label>
                                    <input type="text"   class="form-control" name="nShow" id="text7">
                                    <input type="hidden" name="nId" id="text8">
                                </div>
                                <div class="form-group">
                                    <label for="text10" class="col-form-label">公告发布时间</label>
                                    <input type="text"  name="nDate" class="form-control" id="text10">
                                </div>
                                <div class="form-group">
                                    <label for="text11" class="col-form-label">公告发布人</label>
                                    <input type="text"  name="nPerpson" class="form-control" id="text11">
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
            <li   class="list-inline-item disabled"><a id="li1" onclick="tage1()" href="/notice/selectall?pagenum=${list.pageNum-1}"><i class="fa fa-chevron-left fa-lg"></i>上一页</a></li>
            <li class="list-inline-item"><a id="li2" onclick="tage1()" href="/notice/selectall?pagenum=${list.pageNum+1}"><i class="fa fa-chevron-right fa-lg"></i>下一页 </a></li>
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
        var notice= obj.parentNode.parentNode.childNodes;
        var name=document.getElementById("text6");
        var show=document.getElementById("text7");
        var id=document.getElementById("text8");
        var date=document.getElementById("text10");
        var price=document.getElementById("text11");
        console.log(notice);

        name.value=notice[3].innerHTML;
        show.value = notice[5].innerHTML;
        date.value=notice[7].innerHTML;
        price.value=notice[9].innerHTML;
        id.value=notice[1].childNodes[0].value;
    }
    function deleterow(obj) {
        var index = obj.parentNode.parentNode;
        var table = document.getElementById("table");
        var id = index.childNodes[1].childNodes[0].value;

        table.deleteRow(index.rowIndex);
        xmlhttp.open("get","/notice/delete?id=" + id, true);
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


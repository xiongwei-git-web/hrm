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
        <h5 class="ml-1">员工管理</h5>
    </div>
</div>
<div class="row  border ">
    <div class="col-1">
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" >添加员工</button>
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">添加员工</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="/staff/add" method="post">
                        <div class="modal-body">

                            <div class="form-group">
                                <label for="text1" class="col-form-label">姓名</label>
                                <input type="text"  name="sName" class="form-control" id="text1">
                            </div>
                            <div class="form-group">
                                <label for="text2" class="col-form-label">性别</label>
                                <input type="text"   class="form-control" name="sAge" id="text2">
                            </div>
                            <div class="form-group">
                                <label for="text3" class="col-form-label">手机号码</label>
                                <input type="text"  name="sPhone" class="form-control" id="text3">
                            </div>
                            <div class="form-group">
                                <label for="text4" class="col-form-label">邮箱</label>
                                <input type="text"   class="form-control" name="sEmail" id="text4">
                            </div>
                            <div class="form-group">
                                <label for="text5" class="col-form-label">职位</label>
                                <select id="text5" name="sPostid">
                                    <option selected:disabled style="diaplay:none" value="0">请选择职位</option>
                                    <c:forEach items="${posts}" var="str">
                                    <option value="${str.pId}">${str.pName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="text6" class="col-form-label">学历</label>
                                <input type="text"   class="form-control" name="sEducation" id="text6">
                            </div>
                            <div class="form-group">
                                <label for="text7" class="col-form-label">身份证号</label>
                                <input type="text"  name="sUserid" class="form-control" id="text7">
                            </div>
                            <div class="form-group">
                                <label for="text8" class="col-form-label">部门</label>
                                <select id="text8" name="sSectionid">
                                    <option selected:disabled style="diaplay:none" value="0">请选择部门</option>
                                    <c:forEach items="${sections}" var="str">
                                        <option value="${str.sId}">${str.sName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="text9" class="col-form-label">联系地址</label>
                                <input type="text"  name="sSite" class="form-control" id="text9">
                            </div>
                            <div class="form-group">
                                <label for="text10" class="col-form-label">建档日期</label>
                                <input type="text"   class="form-control" name="sDate" id="text10">
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
    <div class="col-11 ">
        <form action="/staff/selectname" method="post">
            <div class="input-group ">
                <span class="input-group-append align-items-center ">搜索：</span>
                <input type="text" name="sName" class="form-control" placeholder="请输入搜索员工的名称">
                <input type="text" name="sAge" class="form-control" placeholder="请输入搜索员工的性别">
                <input type="text" name="sPhone" class="form-control" placeholder="请输入搜索员工的电话">
                <input type="text" name="sUserid" class="form-control" placeholder="请输入搜索员工的身份证">
                <select  name="sPostid">
                    <option selected:disabled style="diaplay:none" value="0">请选择搜索职位</option>
                    <c:forEach items="${posts}" var="str">
                        <option value="${str.pId}">${str.pName}</option>
                    </c:forEach>
                </select>
                <select  name="sSectionid">
                    <option selected:disabled style="diaplay:none" value="0">请选择搜索部门</option>
                    <c:forEach items="${sections}" var="str">
                        <option value="${str.sId}">${str.sName}</option>
                    </c:forEach>
                </select>
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
                <th scope="col">姓名</th>
                <th scope="col">性别</th>
                <th scope="col">手机号码</th>
                <th scope="col">邮箱</th>
                <th scope="col">职位</th>
                <th scope="col">学历</th>
                <th scope="col">身份证号</th>
                <th scope="col">部门</th>
                <th scope="col">联系地址</th>
                <th scope="col">建档日期</th>
                <th scope="col">操作</th>
            </tr>

            </thead>
            <tbody>
            <form id="formid" action="/staff/deletes" method="post">
                <c:forEach items="${list.list}" var="str">
                    <tr>
                        <th scope="row"><input type="checkbox" name="ids"  value="${str.sId}" /></th>
                        <td>${str.sName}</td>
                        <td>${str.sAge}</td>
                        <td>${str.sPhone}</td>
                        <td>${str.sEmail}</td>
                        <td>${str.post.pName}</td>
                        <td>${str.sEducation}</td>
                        <td>${str.sUserid}</td>
                        <td>${str.section.sName}</td>
                        <td>${str.sSite}</td>
                        <td><fmt:formatDate value="${str.sDate}"  pattern="yyyy-MM-dd"/></td>
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
                            <h5 class="modal-title" id="updates">修改员工</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form action="/staff/update" method="post">
                            <div class="modal-body">

                                <div class="form-group">
                                    <label for="text11" class="col-form-label">姓名</label>
                                    <input type="text"  name="sName" class="form-control" id="text11">
                                </div>
                                <div class="form-group">
                                    <label for="text12" class="col-form-label">性别</label>
                                    <input type="text"   class="form-control" name="sAge" id="text12">
                                </div>
                                <div class="form-group">
                                    <label for="text13" class="col-form-label">手机号码</label>
                                    <input type="text"  name="sPhone" class="form-control" id="text13">
                                </div>
                                <div class="form-group">
                                    <label for="text14" class="col-form-label">邮箱</label>
                                    <input type="text"   class="form-control" name="sEmail" id="text14">
                                </div>
                                <div class="form-group">
                                    <label for="text15" class="col-form-label">职位</label>
                                    <select  name="sPostid">
                                        <option selected:disabled style="diaplay:none"  id="text15" value="0"></option>
                                        <c:forEach items="${posts}" var="str">
                                            <option value="${str.pId}">${str.pName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="text16" class="col-form-label">学历</label>
                                    <input type="text"   class="form-control" name="sEducation" id="text16">
                                </div>
                                <div class="form-group">
                                    <label for="text17" class="col-form-label">身份证号</label>
                                    <input type="text"  name="sUserid" class="form-control" id="text17">
                                    <input type="hidden" name="sId" id="text21" value="">
                                </div>
                                <div class="form-group">
                                    <label for="text18" class="col-form-label">部门</label>
                                    <select  name="sSectionid">
                                        <option selected:disabled style="diaplay:none" id="text18" value="0"></option>
                                        <c:forEach items="${sections}" var="str">
                                            <option value="${str.sId}">${str.sName}</option>
                                        </c:forEach>
                                    </select>>
                                </div>
                                <div class="form-group">
                                    <label for="text19" class="col-form-label">联系地址</label>
                                    <input type="text"  name="sSite" class="form-control" id="text19">
                                </div>
                                <div class="form-group">
                                    <label for="text20" class="col-form-label">建档日期</label>
                                    <input type="text"   class="form-control" name="sDate" id="text20">
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
            <li   class="list-inline-item disabled"><a id="li1" onclick="tage1()" href="/staff/selectall?pagenum=${list.pageNum-1}"><i class="fa fa-chevron-left fa-lg"></i>上一页</a></li>
            <li class="list-inline-item"><a id="li2" onclick="tage1()" href="/staff/selectall?pagenum=${list.pageNum+1}"><i class="fa fa-chevron-right fa-lg"></i>下一页 </a></li>
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
        var staff= obj.parentNode.parentNode.childNodes;
        var name=document.getElementById("text11");
        var age=document.getElementById("text12");
        var Phone =document.getElementById("text13");
        var Email=document.getElementById("text14");
        var post=document.getElementById("text15");
        var Education =document.getElementById("text16");
        var sUserid=document.getElementById("text17");
        var section=document.getElementById("text18");
        var site=document.getElementById("text19");
        var date =document.getElementById("text20");
        var id=document.getElementById("text21");
        console.log(staff);
            name.value=staff[3].innerHTML;
            age.value=staff[5].innerHTML;
            Phone.value=staff[7].innerHTML;
            Email.value=staff[9].innerHTML;
            post.innerHTML=staff[11].innerHTML;
            Education.value=staff[13].innerHTML;
            sUserid.value=staff[15].innerHTML;
            section.innerHTML=staff[17].innerHTML;
            site.value=staff[19].innerHTML;
            date.value=staff[21].innerHTML;

        id.value=staff[1].childNodes[0].value;
    }
    function deleterow(obj) {
        var index = obj.parentNode.parentNode;
        var table = document.getElementById("table");
        var id = index.childNodes[1].childNodes[0].value;

        table.deleteRow(index.rowIndex);
        xmlhttp.open("get","/staff/delete?id=" + id, true);
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


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<HTML>
<HEAD>
<TITLE>权限管理</TITLE>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/css/demo.css" type="text/css">
<link rel="stylesheet" href="/css/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/bootstrap-theme.css">
<script type="text/javascript" src="/js/jquery-3.0.0.js"></script>
<script type="text/javascript" src="/static/common/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="/static/common/ztree/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="/common/bootstrap/js/bootstrap.js"></script>
<SCRIPT type="text/javascript">
	var setting = {
		check : {
			enable : true
		},
		data : {
			simpleData : {
				enable : true,
				idKey : "id",
				pIdKey : "pId",
				rootPId : "0"
			},
			key : {
				name : "name"
			}
		}
	};

	function loadTree() {
		$.post("/admin/sysfunctioin/loadtree", function(data) {
			$.fn.zTree.init($("#tree"), setting, data);
		});
	}

	function loadTreeAjax(role_id) {
		$.ajax({
			type : "POST",
			dataType : "json",
			url : "/admin/sysfunctioin/loadtree",
			data : {
				role_id : role_id
			},
			success : function(result) {
				$.fn.zTree.init($("#tree"), setting, result);
			}
		});
	}
</SCRIPT>
</HEAD>

<BODY>

	<div>
		<form action="" id="roleForm" method="post">
			<input type="hidden" name="perid" id="perid" />
			<div class="row">
				<div class="col-md-3">
					<select class="form-control col-md-3" id="role_id" name="role_id">
						<c:forEach items="${roles}" var="role">
							<option value="${role.role_id }">${role.role_name }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<button type="button" class="btn btn-success" aria-label="Left Align"
				id="btn_submit">保存</button>

			<button type="button" class="btn btn-danger" aria-label="Left Align"
				id="btn_delete">删除</button>

			<!-- 			新建用户 -->
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#myModal" id="btn_modal">新建角色</button>
			<!-- Modal -->
<!-- 			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" -->
<!-- 				aria-labelledby="myModalLabel"> -->
<!-- 				<div class="modal-dialog" role="document"> -->
<!-- 					<div class="modal-content"> -->
<!-- 						<div class="modal-header"> -->
<!-- 							<button type="button" class="close" data-dismiss="modal" -->
<!-- 								aria-label="Close"> -->
<!-- 								<span aria-hidden="true">&times;</span> -->
<!-- 							</button> -->
<!-- 							<h4 class="modal-title" id="myModalLabel">创建一个新的用户</h4> -->
<!-- 						</div> -->
<!-- 						<div class="modal-body"> -->

<!-- 							<div class="form-group"> -->
<!-- 								<label for="exampleInputEmail1">角色名称</label> <input type="text" -->
<!-- 									class="form-control" id="role_name" name="role_name" -->
<!-- 									placeholder="角色名"> -->
<!-- 							</div> -->

<!-- 						</div> -->
<!-- 						<div class="modal-footer"> -->
<!-- 							<button type="button" class="btn btn-default" -->
<!-- 								data-dismiss="modal">取消</button> -->
<!-- 							<button type="button" id="btn_addRole" class="btn btn-primary">确认</button> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

		</form>
		<ul id="tree" class="ztree"
			style="width: 350px; height: 500px; margin-left: 300px"></ul>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			loadTree();

			$('#role_id').change(function() {
				var role_id = $("#role_id").val();
				loadTreeAjax(role_id);
			});

			$("#btn_submit").click(function() {
				//根据ztree的id获取ztree对象
				var treeObj = $.fn.zTree.getZTreeObj("tree");
				//获取ztree上选中的节点，返回数组对象
				var nodes = treeObj.getCheckedNodes(true);
				var array = new Array();
				for (var i = 0; i < nodes.length; i++) {
					var id = nodes[i].id;
					array.push(id);
				}
				var functionIds = array.join(",");
				//为隐藏域赋值（权限的id拼接成的字符串）
				$("#perid").val(functionIds);
				document.forms[0].action = "/admin/sysrole/saveroelfunction";
				document.forms[0].submit();
			});
			
			$("#btn_addRole").click(function() {
				document.forms[0].action = "/admin/sysrole/addrole";
				document.forms[0].submit();
			});
			
			
			$("#btn_delete").click(function() {
				document.forms[0].action = "/admin/sysrole/deleterole";
				document.forms[0].submit();
			});
			
		});
	</script>
</BODY>
</HTML>
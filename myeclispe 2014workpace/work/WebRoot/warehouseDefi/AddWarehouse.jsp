<%@ page language="java" import="java.util.*,com.wl.forms.Employee" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>"><script type="text/javascript" src="<%=path %>/scripts/boot.js"></script>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<script type="text/javascript" src="<%=path %>/scripts/jquery.min.js"></script>
		<script type="text/javascript" src="<%=path %>/scripts/miniui/miniui.js"></script>
		<link href="<%=path %>/scripts/miniui/themes/default/miniui.css" rel="stylesheet" type="txt/css"></link>
		<link href="<%=path %>/scripts/miniui/themes/icons.css" rel="stylesheet" type="txt/css"></link>
   
    <title>新增库房</title>
    <style type="text/css">
    	*{margin: 0;padding: 0;}
    </style>
  </head>
  
  <body>
   <div class="mini-toolbar">
  		<a class="mini-button" iconCls="icon-save" plain="false"  onclick="getForm()">保存</a>
  		<span class="separator"></span>
  		<a class="mini-button" plain="false" iconCls="icon-undo" onclick="javascript:window.history.back(-1);">返回</a>
	    
  	</div>
   <fieldset align="center">
    <legend>新增库房信息</legend>
    <form id="addwarehouse" name="aaddwarehouse" action="AddWarehouseServlet" method="post" style="">
   <table style="text-align: left;border-collapse:collapse;" border="gray 1px solid;"  width="100%" >
    <tr bgcolor=#EBEFF5><td><label for="warehouse_id$text">库房编号</label></td>
    <td><input id="warehouse_id" name="warehouse_id" class="mini-textbox" width="100%" required="true" /></td>
    <td><label for="warehouse_name$text">库房名称</label></td>
    <td><input id="warehouse_name" name="warehouse_name" class="mini-textbox" width="100%" required="true" /></td>
     <td><label for="shelf_num$text">货架数量</label></td>
    <td><input id="shelf_num" name="shelf_num" class="mini-textbox" width="100%" /></td>
   <td><label for="shelf_storey$text">层/货架</label></td>
    <td><input id="shelf_storey" name="shelf_storey" class="mini-textbox" width="100%" /></td>
    </tr>
    <tr bgcolor=#EBEFF5>
    
     <td><label for="shelf_column$text">列/货架</label></td>
    <td><input id="shelf_column" name="shelf_column" class="mini-textbox" width="100%" /></td>
     <td><label for="wh_addr$text">地址</label></td>
    <td><input id="wh_addr" name="wh_addr" class="mini-textbox" width="100%" /></td>
    <td><label for="wh_phone$text">联系电话</label></td>
    <td><input id="wh_phone" name="wh_phone" class="mini-textbox" width="100%" /></td>
    <td><label for="emp_id$text">管理员</label></td>
    <td><input id="emp_id"  name="emp_id" class="mini-buttonedit" width="100%" textName="emp" onbuttonclick="onButtonEditEmployee" 
  allowInput="false" /></td>
    
    </tr>
    </table>
    </form>
    
   </fieldset>
	<script>
   		mini.parse();
   		function getForm(){
   			var form = new mini.Form("#addwarehouse");
   		        var data = form.getData();
                var json =mini.encode(data);
                $.ajax({
    				url: "AddWarehouseServlet",
    				type: "post",
    				dataType:"json",
   					data: { submitData: json },
    				success: function (data) {
	       				alert(data.result);
	       				if(data.status==1){
	       					window.location.href=window.location.href;
	       				}
    				}
				});
   		}
  	
  	function onButtonEditEmployee(e) {
            var btnEdit = this;
            mini.open({
                url: "employeeManage/selectEmployeeWindow.jsp",
                title: "选择上级部门",
                width: 650,
                height: 380,
                ondestroy: function (action) {
                    //if (action == "close") return false;
                    if (action == "ok") {
                        var iframe = this.getIFrameEl();
                        var data = iframe.contentWindow.GetData();
                        data = mini.clone(data);    //必须
                        if (data) {
                            btnEdit.setValue(data.staffCode);
                            btnEdit.setText(data.staffName);
                            //mini.get("dept").setValue(data.sectionName);
                            //mini.get("connector").setValue(data.connector);
                            //mini.get("connectorTel").setValue(data.connectorTel);
                        }
                    }
                }
            });
        }
  	</script>
  </body>
</html>

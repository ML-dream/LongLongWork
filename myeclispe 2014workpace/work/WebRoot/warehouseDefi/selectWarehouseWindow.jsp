<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>选择库房</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <script type="text/javascript" src="<%=path %>/scripts/boot.js"></script>         
	<link href="<%=path %>/scripts/miniui/themes/default/miniui.css" rel="stylesheet" type="txt/css"></link>
	<link href="<%=path %>/scripts/miniui/themes/icons.css" rel="stylesheet" type="txt/css"></link>
	
    <script type="text/javascript" src="<%=path %>/scripts/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/scripts/miniui/miniui.js"></script>
    <style type="text/css">
    body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }
    </style>
  </head>
  
  <body>
  	<!-- 
    <div class="mini-toolbar" style="text-align:center;line-height:30px;" borderStyle="border:0;">
          <label >名称：</label>
          <input id="key" class="mini-textbox" style="width:150px;" onenter="onKeyEnter"/>
          <a class="mini-button" style="width:60px;" onclick="search()">查询</a>
    </div>
     -->
    <div class="mini-fit">

        <div id="grid1" class="mini-datagrid" style="width:100%;height:100%;" idField="id" allowResize="true"
            borderStyle="border-left:0;border-right:0;" onrowdblclick="onRowDblClick"
        >
            <div property="columns">
                <div type="indexcolumn" ></div>
                <!-- 
                <div field="loginname" width="120" headerAlign="center" allowSort="true">员工帐号</div>    
                <div field="name" width="100%" headerAlign="center" allowSort="true">姓名</div>                                            
                <div field="createtime" width="100" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true">创建日期</div>    
                 -->
               
                <div field="warehouseid" width="100" headerAlign="center">库房编号</div>   
	            <div field="warehousename" width="100" headerAlign="center">库房名称</div>
	            <div field="whaddr" width="70" headerAlign="center">地址 </div>
	             <div field="whphone" width="70" headerAlign="center">联系电话</div>
	            <div field="empid" width="70" headerAlign="center">管理员 </div>          
            </div>
        </div>
    
    </div>                
    <div class="mini-toolbar" style="text-align:center;padding-top:8px;padding-bottom:8px;" borderStyle="border:0;">
        <a class="mini-button" style="width:60px;" onclick="onOk()">确定</a>
        <span style="display:inline-block;width:25px;"></span>
        <a class="mini-button" style="width:60px;" onclick="onCancel()">取消</a>
    </div>

</body>
</html>

<script type="text/javascript">
    mini.parse();
    var grid = mini.get("grid1");
	
	/*function GetRequest() { 
        var url = location.search; //获取url中"?"符后的字串 
        var theRequest = new Object(); 
        if (url.indexOf("?") != -1) { 
        	var str = url.substr(1); 
        	strs = str.split("&"); 
        	for(var i = 0; i < strs.length; i ++) { 
        		theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]); 
        	} 
        } 
        return theRequest; 
    } 

    var Request = new Object(); 
    Request = GetRequest();*/
    //alert(Request['type']);
	
    //动态设置URL
    //grid.setUrl("../data/AjaxService.jsp?method=SearchEmployees");
    grid.setUrl("GetWarehouseServlet");
    //也可以动态设置列 grid.setColumns([]);

    grid.load();

    function GetData() {
        var row = grid.getSelected();
        return row;
    }
    function search() {
        var key = mini.get("key").getValue();
        grid.load({ key: key });
    }
    function onKeyEnter(e) {
        search();
    }
    function onRowDblClick(e) {
        onOk();
    }
    //////////////////////////////////
    function CloseWindow(action) {
        if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
        else window.close();
    }

    function onOk() {
        CloseWindow("ok");
    }
    function onCancel() {
        CloseWindow("cancel");
    }
    
    


</script>

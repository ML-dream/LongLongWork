<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工信息</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/js.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pagecard.css">
	<style type="text/css">
	<!--
	table {
	    table-layout:fixed;
	    word-break: break-all;
	} 
	-->
	</style>
	<style type="text/css">
    	*{margin: 0;padding: 0;}
    </style>
	<script type='text/javascript' src="<%=basePath%>resources/js/tabcard.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/jquery/jquery.min.js"></script>
	<jsp:include page="/commons/miniui_header.jsp" />
  </head>
  
  <body>
  	<div>
  	在职状态：<input id="leave" name="leave" class="mini-combobox" showNullItem="true" url="data/leave.txt"/>
  	&nbsp;&nbsp;<a class="mini-button" iconCls="" onclick="onSearch()">筛选</a>
  	</div>
  
    <div id="grid1" class="mini-datagrid" style="width:100%;height:95%;"
         borderStyle="border:0;" multiSelect="true"  idField="id" showSummaryRow="true" allowAlternating="true" showPager="true"
         url="EditEmployeeInfoServlet">
        <div property="columns">
            <div type="indexcolumn"></div>
            <div name="action" width="50" headerAlign="center" align="center" renderer="onOperatePower"cellStyle="padding:0;">操作</div>
            <div field="staffCode" width="100" headerAlign="center">员工编号</div>
            <div field="staffName" width="100" headerAlign="center">员工名称</div>
            <div field="sectionName" width="100" headerAlign="center">所属部门</div>
            <div field="gender" width="100" headerAlign="center" renderer="onGenderRenderer">性别</div>
            <div field="mobilePhone" width="100" headerAlign="center">手机号码</div>
        </div>
    </div>
    
    <script type="text/javascript">
    	mini.parse();
	    var grid = mini.get("grid1");
	    grid.load();
	    
	    function onOperatePower(e) {
	        var str = "";
	        str += "<span>";
	        str = "<a style='margin-right:2px;' title='编辑' href=javascript:ondEdit(\'" + e.row.staffCode + "\') ><span class='mini-button-text mini-button-icon icon-edit'>&nbsp;</span></a>";
	        str += "</span>";
	        //alert(e.row.staffCode);
	        return str;
	    }
	    
	    function ondEdit(staffCode){
//	        window.open("EditEmployeeDetailServlet?staffCode=" + staffCode,
//	                "editwindow","top=50,left=100,width=950px,height=400px,status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=yes");
	         window.location.href="EditEmployeeDetailServlet?staffCode="+staffCode;
		}

		function onSearch(){
			var leave=mini.get("leave").getValue();
			grid.load({leave:leave});
		}

	    var Genders = [{ id: 'M', text: '男' }, { id: 'W', text: '女'}];
        function onGenderRenderer(e) {
            for (var i = 0, l = Genders.length; i < l; i++) {
                var g = Genders[i];
                if (g.id == e.value) return g.text;
            }
            return "";
        }

        
    </script>
  </body>
</html>

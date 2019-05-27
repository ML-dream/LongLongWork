<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>待办事项</title>
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
	<script type="text/javascript" src="<%=basePath%>resources/jquery/jquery-1.6.2.min.js"></script>
	<jsp:include page="/commons/miniui_header.jsp" />
  </head>
  
  <body>
  </br>
  	<h1 align="center">企业生产管理与制造执行系统(纳联)</h1>
   	</br>
	<div id="tablediv">
   	 <div id="datagrid1" class="mini-datagrid" style="width:580px;height:360px;" 
        url="LoadWaitDoPage" idField="id" allowResize="true" pageSize="10"   multiSelect="true" allowCellSelect="true" allowCellEdit="true"
    	showPager= "true" showPageInfo="true" showReloadButton = "true" showPagerButtonIcon="true"  editNextOnEnterKey= "true"
    >
 		<div property="columns">
            
            <div field="waitName" width="60" headerAlign="center" allowSort="false">待办事项</div>
            <div field="waitNum" width="60" headerAlign="center" allowSort="false">数量
            </div>
             <div name="action" width="80" headerAlign="center" align="center" renderer="onActionRenderer" cellStyle="padding:0;">链接</div>
            
             <div field="link" width="60" headerAlign="center" allowSort="false" visible= "false">链接
            </div>    
        </div>
     </div>
   </div>    
    <script type="text/javascript">
    	mini.parse();
	    var grid = mini.get("datagrid1");
	    grid.load();
	    
	    function onActionRenderer(e) {

            var str = "";
	        str += "<span>";
	        str += '<a class="" href="javascript:timecost(\'' + e.row.link + '\')">查看</a>';
	        str += "</span>";
	        
	        return str;

        }
	    
	    function timecost(link){
	    	window.location.href=link;
	    }
	    
    </script>
  </body>
</html>

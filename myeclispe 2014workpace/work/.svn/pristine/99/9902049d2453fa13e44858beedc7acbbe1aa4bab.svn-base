<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html >
<html>
 <head>
    <base href="<%=basePath%>">
    
    <title>产品出入库查询</title>
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
	
<div id="win1" class="mini-window" title="操作" style="width:810px;height:450px;" collapseOnTitleClick="true"
    showMaxButton="true" showCollapseButton="true" showShadow="true" showCloseButton="false" expanded="true"
    showToolbar="true" showFooter="true" showModal="false" allowResize="true" allowDrag="true"
    >
    
	<fieldset style="width:780px;height:95%" align="center">  
	    <legend>
			查找
		</legend>  
	    <table >
	   		<tr>
	   			<td>订单号</td>
	          <td><input id="forderId" name="order_id" class="mini-textbox" value="" allowinput="true" onvaluechanged="onValueChanged"/>
	          </td>
	          <td>产品号</td>
	          <td><input id="fproductId" class="mini-textbox" value="" allowinput="true" onvaluechanged="onValueChanged" />
	          </td>
	          <td>零件名称</td>
	          <td><input id="fproductName" class="mini-textbox" value="" allowinput="true" onvaluechanged="onValueChanged" />
	          </td>
	   		</tr>
	   	</table>
	    <div id="winGrid" class="mini-datagrid" style="width:770px;height:85%;" allowResize="true" onload= "" 
	        url="LoadUnlockBarcode"  idField="id" multiSelect="false" pagesize="20" >
	        <div property="columns">
	           	<div name="action"  headerAlign="center" align="center" width="40" renderer="onOperatePower">操作</div>
	           	
	            <div field="barcode" name="barcode" width="60" headerAlign="center" allowSort="">条码号</div>    
	            <div field="orderId" width="90" headerAlign="center" allowSort="false">订单号</div> 
	            <div field="companyName" width="90" headerAlign="center" allowSort="false">客户</div>  
	            <div field="productId" width="60" headerAlign="center" allowSort="false">产品号</div> 
	            <div field="productName" width="40" headerAlign="center" allowSort="false">产品名称</div>  
	         </div>   
	     </div>
	 </fieldset>
</div>

	   	 </br></br></br>
   <div id="tablediv">
   	 <div id="datagrid1" class="mini-datagrid" style="width:1080px;height:480px;" allowResize="true" 
   		 allowCellSelect="true" allowCellEdit="true" showSummaryRow="true" ondrawsummarycell="onDrawSummaryCell"
          idField="id" multiSelect="false" pagesize="20" allowUnselect="false" onrowclick="">
        <div property="columns">
                
            <div type="indexcolumn"></div>   
            <div field="checkdate"  width="40" headerAlign="center" allowSort="true">操作日期</div>    
            <div field="checksheetid" width="60" headerAlign="center" allowSort="false">单号</div> 
            <div field="drawingid" width="60" headerAlign="center" allowSort="false">零件图号</div>
            <div field="productname" width="60" headerAlign="center" allowSort="false">零件名称</div>
            
            <div field="num" width="60" headerAlign="center" allowSort="false">数量</div>   
            <div field="createrName" width="60" headerAlign="center" allowSort="false">操作人员</div> 
            <div field="checkerName" width="60" headerAlign="center" allowSort="false">审核人员</div> 
        </div>
     </div>
   </div>
   
</body>
	<script type="text/javascript">
		mini.parse();
		//mini.get("piece_barcode").focus();
		var winGrid =new mini.get("winGrid");  //查找的datagrid 
		var grid = new mini.get("datagrid1");
		
		function onOperatePower(e){
	    	var str="";
	    	str+="<span>";
	    	str+="<a style='margin-right:2px;' title='出库详情' href=javascript:productOut(\'"+e.row.productId+"\')><span class='mini-button-text mini-button-icon icon-upload'>&nbsp;</span></a>";
	   		str+="</span>";
	   		str+="<span>";
	    	str+="<a style='margin-right:2px;' title='入库详情' href=javascript:productIn(\'"+e.row.productId+"\')><span class='mini-button-text mini-button-icon icon-download'>&nbsp;</span></a>";
	   		str+="</span>";
	   		return str;
	    }
		function productOut(productId){
			grid.setUrl("ProductInDetail?productId="+productId+"&para=out");
			grid.load();
		}
		function productIn(productId){
			grid.setUrl("ProductInDetail?productId="+productId+"&para=in");
			grid.load();
		}
		
		function onDrawSummaryCell(e) {
            var result = e.result;
            var grid = e.sender;
            //服务端汇总计算
            if (e.field == "num") {                
                var s = "<b style='color:red;'>"
                s +=  	"总数：<br/>"+ result.sumNum + "<br/>"
                		+ "</b>";
                e.cellHtml = s;
            }
        }
		
		
	function onValueChanged(){
		var forderId = mini.get("forderId").getValue();	//输入的订单号
		var fproductId =mini.get("fproductId").getValue();	
		var fproductName =mini.get("fproductName").getValue();
		winGrid.load({orderId:forderId , productId: fproductId,productName:fproductName });
	}
	function setBarcode(){
		var row = winGrid.getSelected();
		mini.get("piece_barcode").setValue(row.barcode);
		loadgrid();
	}
	function showAtPos() {
        var win = mini.get("win1");
		//var win2 = mini.get("win2");
        var x = "right";
        var y = "top";

        win.showAtPos(x, y);
		//win2.showAtPos("center", y);
    }
	showAtPos();
	</script>
</html>
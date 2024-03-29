<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>采购收货</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">-->
	
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

  <fieldset id="prdiv"align="center" style="width: 810px;">
  <legend>采购收货单</legend>
  
  <form id="Prsheet" name="Prsheet" action="#" method="post">
  <table style="text-align: right;border-collapse:collapse;" border="gray 1px solid;" width="99%">
  <tr bgcolor=#EBEFF5>
  <td style="width:50px;"><label for="prDate$text">开单日期</label></td>
  <td style="width:100px;"><input id="prDate" name="prDate" class="mini-datepicker"  dateFormat="yyyy-MM-dd HH:mm:ss" format="yyyy-MM-dd" 
  		showTodayButton="false" showClearButton="false" allowInput="false" width="100%"  value="${prsheet.prDate }" readonly/>
  <input id="prSheetid" name="prSheetid" class="mini-hidden" enabled="false" width="100%" value="${prsheet.prSheetid }"></td>
  <td style="width:70px;"><label for="customerId$text">供应商</label></td>
  <td style="width:145px;"><input id="customerId" name="customerId" class="mini-textbox" width="100%" readonly value="${prsheet.customerName }"  text= "${prsheet.customerName  }" onbuttonclick="onSupplierButtonEdit" textName="customerName"  allowInput="false"/></td>
  <td style="width:70px;"><label for="sheetId$text">收货单单号</label></td>
  <td style="width:150px;"><!-- 订货单单号 <input id="purchase" name="purchase" class="mini-combobox"  value="${prsheet.purId }" readonly width="100%" textName="" textField="text" valueField="id"
  			url=""  allowInput="true" showNullItem="true" nullItemText="请选择..."  onvaluechanged="LoadGrid()"/>
  	-->
  		<input id="sheetId" name="sheetId" class="mini-textbox"  value="${prsheet.prSheetid }" readonly width="100%" />
  	</td>
  </tr>
  
  <tr bgcolor=#EBEFF5>
  <td><label for="drawerId$text">开单人</label></td>
  <td><input id="drawerId" name="drawerId"  class="mini-textbox" readonly value="${prsheet.drawerName  }"  width="100%"  allowInput="false" ></td>
  <td><label for="connector$text">联系人</label></td>
  <td><input id="connector" name="connector" class="mini-textbox" value="${prsheet.connector  }" readonly width="100%"/></td>
  <td><label for="connectorTel$text">联系电话</label></td>
  <td><input id="connectorTel"  name="connectorTel" class="mini-textbox" value="${prsheet.connectorTel  }" readonly width="100%" /></td>
  </tr>
  
   <tr bgcolor=#EBEFF5>
  <td><label for="payTerm$text">付款期限</label></td>
  <td><input id="payTerm" name="payTerm" class="mini-combobox"  value="${prsheet.payTerm  }" readonly style="width:100%;" textField="text" valueField="id" emptyText="请选择..."
  url="data/payTerm.txt" allowInput="false" showNullItem="true" nullItemText="请选择..."/></td> 
   <td><label for="isBill$text">是否开具发票</label></td>
  <td><input id="isBill" name="isBill" class="mini-combobox" value="${prsheet.isBill  }" readonly  style="width:100%;" textField="text" valueField="id" emptyText="请选择..."
   url="data/trueOrFalse.txt" value="1" allowInput="false" showNullItem="true" nullItemText="请选择..."/></td>
  <td><label for="receipt$text">发票类型</label></td>
  <td><input id="receipt" name="receipt" class="mini-combobox" value="${prsheet.receipt  }" readonly url="ReceiptServlet" style="width:100%" valueField="id" textField="text" 
   emptyText="请选择..." allowInput="false" showNullItem="true" nullItemText="请选择..."/></td>  
  
  </tr>
  <tr bgcolor=#EBEFF5>
  <td><label for="dutyParagraph$text">税务登记号</label></td>
  <td><input id="dutyParagraph" name="dutyParagraph" value="${prsheet.dutyParagraph   }" readonly  class="mini-textbox" width="100%" /></td>
  <td><label for="bank$text">开户银行</label></td>
  <td><input id="bank" name="bank" class="mini-textbox" value="${prsheet.bank  }" readonly width="100%"/></td>
  <td><label for="account$text">账号</label></td>
  <td><input id="account" name="account" class="mini-textbox" value="${prsheet.account  }" readonly  width="100%"/></td>
  </tr>
  </table>
  <!--  &para=warehouse  -->
  <div id="tablediv">
   	 <div id="datagrid1" class="mini-datagrid" style="width:99%;height:380px;"  allowResize="false"
        url="SeePurchaseItem?key=${prsheet.prSheetid}" idField="id" allowResize="true" pageSize="20"   multiSelect="true" allowCellSelect="true" allowCellEdit="true"
    	showPager= "true" showPageInfo="true" showReloadButton = "true" showPagerButtonIcon="true" 
    	   showColumnsMenu ="true"   editNextOnEnterKey= "true" 
    	allowCellWrap="true"  onshowrowdetail="" 
    >
 		<div property="columns">
 			<!-- <div type="checkcolumn" visible="true"></div> -->
            <div field="itemId" name = "itemId" width="80" headerAlign="center" allowSort="false" showColumnsMenu="true" headerStyle="height:40px;">货品编码</div>
            <div field="itemName" width="60" headerAlign="center" allowSort="false" >货品名称</div>
           
            <div field="spec" width="80" headerAlign="center" allowSort="false">规格</div>    
            <div field="unit" width="40" headerAlign="center" allowSort="false">单位</div> 
            <div field="itemTypeName" width="40" headerAlign="center" allowSort="false" visible="false">类型
            </div>
            <div field="ussage" width="100" headerAlign="center" allowSort="false" visible="true">用途</div>
             <div field="prNum" width="60" headerAlign="center" allowSort="false" visible="false">订货数量</div>
             
            <div field="inNum" width="40" headerAlign="center" allowSort="false"  visible="true" >数量
            </div>
            
            <div field="warehousename" width="60" headerAlign="center" allowSort="false" headerStyle="" >库房
            	
            </div>
            
            <div field="itemState" width="60" headerAlign="center" allowSort="false" renderer="onStateRenderer" headerStyle="color:red;">审核结果
            </div>
            
            <div field="stockId" width="80" headerAlign="center" allowSort="false" headerStyle="color:red;" visible="false">库位
    		</div>
    		<div field="remark" width="80" headerAlign="center" allowSort="false" headerStyle="color:red;">备注
    		</div>
        </div>
     </div>
  	<!--<table>
     	<tr height= "30px">
     		<td width="80px"></td>
     		<td width="60px"> <a class="Update_Button" href="javascript:firstpage()">首页</a> </td>
     		<td width="60px"> <a class="Update_Button" href="javascript:uppage()">上一页</a> </td>
     		<td width="60px"> <a class="Update_Button" href="javascript:downpage()">下一页</a> </td>
     		<td width="60px"> <a class="Update_Button" href="javascript:endpage()">末页</a> </td>
     		
     		 <td width="60px"> <a class="Update_Button" href="javascript:saveData()">保存</a> </td>  
     		<td><label>鼠标右击表头，可选择隐藏列</label></td>
     	</tr>
     </table>
  		

  --><input id="id" name="id" class="mini-hidden" value="${pr_sheetid.id }"/>
  <input id="seq" name="seq" class="mini-hidden" value="${pr_sheetid.seq }"/>
  </form>
  </br>
  
  </fieldset>
  
  
  
  
  <script type="text/javascript">
  	mini.parse();
  	var warehouse=null;
  	LoadGrid();
  //	toPrint();
  	function toPrint(){
  		window.print();
  	}
  	var prstate=[{id:"1",text:"通过"},{id:"0" ,text:"不通过"},{id:"3" ,text:"待审核"}];
  	function onStateRenderer(e) {
            for (var i = 0, l = prstate.length; i < l; i++) {
                var g = prstate[i];
                if (g.id == e.value) return g.text;
            }
            return "";
        }
  	
  	function LoadGrid(){
  		//var purId = mini.get("purchase").getValue();
  		var grid  = mini.get("datagrid1");
  		mini.get("datagrid1").load();
  	//	grid.load({key: purId});
  	/*
  		 $.ajax({
        	type: "post",
            url: "ShowWarehouse",
            cache: false,
            success: function (text) {
                var o = mini.decode(text);
                warehouse = o;
            }
	       });
	       */
  	}
  	
  	function uppage(){
			helpSave();
			var size = grid.getPageSize();
			var npage = grid.getPageIndex();	//获取当前页码 
			var page = npage;
			if(npage ==0){
			}else{
				page = npage -1;
				grid.gotoPage ( page, size );
			}
			issave =0;
		}
		function downpage(){
			helpSave();
			var size = grid.getPageSize();
			var npage = grid.getPageIndex();	//获取当前页码 
			
			var total = grid.getTotalCount();	//数据总数 
			var tpage = Math.ceil(total/size);	//总页数 
			
			var page = npage;		//跳转页码 
			if(npage == tpage-1){
			}else{
				page = npage +1;
				grid.gotoPage ( page, size );
			}
			issave =0;
		}
		function firstpage(){
			helpSave();
			var size = grid.getPageSize();
			grid.gotoPage ( 0, size );
			issave =0;
		}
		function endpage(){
			helpSave();
			var size = grid.getPageSize();
			var npage = grid.getPageIndex();	//获取当前页码 
			
			var total = grid.getTotalCount();	//数据总数 
			var tpage = Math.ceil(total/size);	//总页数 
			
			grid.gotoPage ( tpage-1, size );
			issave =0;
		}
		function celorder(){
			helpSave();
			grid.clearSort ( );		
		}
		
		function saveData(){
			// var data = grid.getChanges();
			var grid  = mini.get("datagrid1");
			grid.selectAll();
			var data = grid.getSelecteds();
    		 var json = mini.encode(data);
    		//alert (json);
    		grid.deselectAll();
    		alert (json);
    		/*
    		$.ajax({
				type:"post",
				url: "SaveCostConfirm",
				data:{"data" : json},
				cache: false,
				success: function (text){
					var t = confirm(text +",是否刷新数据 ？");
					if(t==true){
						grid.reload();
					}
				},
				error: function (text){
					alert ("保存失败 ");
				}
			});
			*/
		}
		function helpSave(){
			var data = grid.getChanges();
			var json = mini.encode(data);
			if(json != "[]" && issave ==0){
				var r = confirm("当前页数据已发生修改，是否保存?");
				if(r == true){
					saveData();
					issave = 1;
				}
			}
		}
  	function getForm(){
	 	 
	 	var prsheet = mini.get("prSheetid").getValue();
	 	// var purId = mini.get("purchase").getValue();
	 	
	 	var grid  = mini.get("datagrid1");
		//grid.selectAll();
		var griddata = grid.getChanges();
   		var gridjson = mini.encode(griddata);
   		//grid.deselectAll();
   		//alert(gridjson);
	  	$.ajax({
	  		type:"post",
	  		url:"SaveWarePrServlet",
	 	    data:{prsheet:prsheet, gridjson:gridjson},		//,purId:purId
	 	    dataType:"json",
	 		success: function(data){
	 			//var o =mini.decode(data);
	  			alert(data.result);
	  			grid.load();
	  		}
	  	});
	  }
  
    function nextForm(){
    window.location.href=window.location.href;
    } 
  
   function onSupplierButtonEdit(e) {
            var btnEdit = this;
            mini.open({
                //url: bootPATH + "../demo/CommonLibs/SelectGridWindow.html",
                url: "Supplier/selectSupplierWindow.jsp",
                title: "选择列表",
                width: 650,
                height: 380,
                ondestroy: function (action) {
                    //if (action == "close") return false;
                    if (action == "ok") {
                        var iframe = this.getIFrameEl();
                        var data = iframe.contentWindow.GetData();
                        data = mini.clone(data);    //必须
                        if (data) {
                            btnEdit.setValue(data.companyId);
                            btnEdit.setText(data.companyName);
                            mini.get("connector").setValue(data.connector);
                            mini.get("connectorTel").setValue(data.connectorTel); 
 //                           mini.get("telephone").setValue(data.telephone);
                       		mini.get("dutyParagraph").setValue(data.dutyParagraph);
                       		mini.get("bank").setValue(data.bank);
                       		mini.get("account").setValue(data.account);
                       		
                       		//加载对应供货商下的订货单  
                       		 $.ajax({
					        	type: "post",
					            url: "FindPurchaseId?companyId=" + data.companyId,
					            cache: false,
					            success: function (text) {
					                var o = mini.decode(text);
					                mini.get("purchase").setData(o);
					            }
						       });
                        }
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
                            //mini.get("connector").setValue(data.connector);
                            //mini.get("connectorTel").setValue(data.connectorTel);
                        }
                    }
                }
            });
        }
        
   function onButtonEditWarehouse(e){
   	var btnEdit = this;
            mini.open({
                url: "warehouseDefi/selectWarehouseWindow.jsp",
                title: "选择库房",
                width: 650,
                height: 380,
                ondestroy: function (action) {
                    //if (action == "close") return false;
                    if (action == "ok") {
                        var iframe = this.getIFrameEl();
                        var data = iframe.contentWindow.GetData();
                        data = mini.clone(data);    //必须
                        if (data) {
                            btnEdit.setValue(data.warehouseid);
                            btnEdit.setText(data.warehousename);
                         
                        }
                    }
                }
            });
   
   }
   
 </script>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>客户信息</title>
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
    <div id="grid1" class="mini-datagrid" style="width:100%;height:95%;"
         borderStyle="border:0;" multiSelect="true"  idField="id" showSummaryRow="true" allowAlternating="true" showPager="true"
         url="ProductOutAssistServlet?orderId=${orderId}" allowCellSelect="true" allowCellEdit="true">
        <div property="columns">
            <div type="indexcolumn"></div>
            <div name="action" width="30" headerAlign="center" align="center" renderer="onOperatePower"
                 cellStyle="padding:0;">操作
            </div>
            <div field="productName" width="50" headerAlign="center">产品名称
            </div> 
            <div field="productId" width="50" headerAlign="center">图号
            </div>
            <div field="issueNum" width="50" headerAlign="center">版本号
            </div>
            <div field="isWaiXie" width="30" headerAlign="center" renderer="onGenderRenderer">是否外协
            </div>
            <div field="WaiXieCom" width="80"  headerAlign="center" >外协商
            	<input property="editor" class="mini-buttonedit" width="100%" onbuttonclick="onButtonEdit" textName="companyName" />
            </div>
        </div>
    </div>
    
    <script type="text/javascript">
    	mini.parse();
	    var grid = mini.get("grid1");
	    grid.load();
	    
	    function onOperatePower(e) {
	        var str = "";
	        str += "<span>";
	        str += "<a style='margin-right:2px;' title='工序外协' href=javascript:ondEdit(\'" + e.row.orderId+"\',\'"+e.row.productId+"\',\'"+e.row.issueNum+"\',\'"+e.row.WaiXieCom+ "\') ><span class='mini-button-text mini-button-icon icon-edit'>&nbsp;</span></a>";
	        str += "</span>";
	        str += "<span>";
	        str += "<a style='margin-right:2px;' title='保存' href=javascript:ondSave(\'" + e.row.orderId+"\',\'"+e.row.productId+"\',\'"+e.row.issueNum+"\',\'"+e.row.WaiXieCom+ "\') ><span class='mini-button-text mini-button-icon icon-save'>&nbsp;</span></a>";
	        str += "</span>";
	        //alert(e.row.staffCode);
	        return str;
	    }
	    
	    function ondEdit(orderId,productId,issueNum,WaiXieCom)
	    {
	    	window.location="GoProcessOutAssistServlet?orderId="+orderId+"&productId="+productId+"&issueNum="+issueNum+"&WaiXieCom="+WaiXieCom;
		}
        
        function ondSave(orderId,productId,issueNum,WaiXieCom){

            var data = "{\"orderId\":\""+orderId+"\",\"productId\":\""+productId+"\",\"issueNum\":\""+issueNum+"\",\"WaiXieCom\":\""+WaiXieCom+"\"}"; 
			var params = JSON.parse(data);
			var url = "ProductOutAssistSaveServlet";
				jQuery.post(url, params, function(data){
   	   				alert(data.result);
   	   				window.location.href=window.location.href;
   	   			},'json');
	    	grid.reload();
		}
		
        function onButtonEdit(e) {
            var btnEdit = this;
            mini.open({
                url: "outAssistManage/selectOutAssistWindow.jsp",
                title: "选择列表",
                width: 650,
                height: 380,
                ondestroy: function (action) {
                    if (action == "ok") {
                        var iframe = this.getIFrameEl();
                        var data = iframe.contentWindow.GetData();
                        data = mini.clone(data);    //必须
                        if (data) {
                            btnEdit.setValue(data.companyId);
                            btnEdit.setText(data.companyName);
                        }
                    }

                }
            });
        }  
        
	    //var Genders = [{ id: 'M', text: '男' }, { id: 'W', text: '女'}];
	    var Genders = [{id: "0", text: "否"},{id: "1", text: "是"}];
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


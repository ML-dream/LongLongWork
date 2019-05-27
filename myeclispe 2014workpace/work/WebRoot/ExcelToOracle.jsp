<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>"><script type="text/javascript" src="<%=path %>/scripts/boot.js"></script>
    <meta http-equiv="content-Type" content="text/html;charset=utf-8"/>
		<script type="text/javascript" src="<%=path %>/scripts/jquery.min.js"></script>
		<script type="text/javascript" src="<%=path %>/scripts/miniui/miniui.js"></script>
		<script type="text/javascript" src="<%=path %>/scripts/boot.js"></script>
		<link href="<%=path %>/scripts/miniui/themes/default/miniui.css" rel="stylesheet" type="txt/css"></link>
		<link href="<%=path %>/scripts/miniui/themes/icons.css" rel="stylesheet" type="txt/css"></link>
   
    <title>	EXCEL导入Oracle</title>
    <style type="text/css">
    	*{margin: 0;padding: 0;}
    </style>
  </head>
  
  <body >
  	<div class="mini-toolbar">
  		<a class="mini-button" iconCls="icon-save" plain="false"  onclick="getForm()">保存</a>
  	</div>
	<fieldset style="width: 99%;" align="center">
		<legend>
			EXCEL导入Oracle
		</legend>
   		<!--<div id= "userdiv">-->
   		<form name="userdiv" id="userdiv" action="AddOrderServlet" method="post" enctype="multipart/form-data">
   		<table style="text-align: right;border-collapse:collapse;" border="gray 1px solid;"  width="100%" >
   		<tr>
            <td><label for="orderId$text">订单号</label></td>
            <td><input id="orderId" name="orderId" class="mini-buttonedit" width="100%" onbuttonclick="onOrderButtonEdit" textName="orderId" required="true" allowInput="false"/>
            <td>上传Excel文件</td>
   			<td><input type="file" name="execlFile"/></td>
        </tr>
     
   	</table>
   	</form>
   <!--</div>-->
   </fieldset>
   
   
   <script charset="UTF-8">
   		mini.parse();
   		/*
   		function getForm(){
   			var form = new mini.Form("#userdiv");
   			form.validate();
            if (form.isValid() == false) {
            	return;
            }else{
            	var data = form.getData();
                var params = eval("("+mini.encode(data)+")");
                var url = 'AddOrderServlet';
   		        jQuery.post(url, params, function(data){
   	   		        alert(data.result);
   	   		  		window.location.href=window.location.href;
   	   		        },'json');
            }
   		}
   		*/
  		
   		function getForm(){
   			//document.forms[0].action = "AddOrderServlet";
 		  	//document.forms[0].submit();
 		  	var formData = new mini.Form("#userdiv");
 		  	var form = new mini.Form("#userdiv");
   			form.validate();
            if (form.isValid() == false) {
            	return;
            }else{
 		  		jQuery.ajax({
      				type: "POST",
      				url: "ImpExcelToOracleServlet",
      				dataType: "json", 
      				cache: false,
      				enctype: 'multipart/form-data',
      				data: new FormData($('#userdiv')[0]),
      				processData: false,
    				contentType: false,
      				success: function (data) {
        				alert(data.result);
        				window.location.href = window.location.href;
      				}
    			});
    		}
   		}
		
		
   		function onOrderButtonEdit(e) {
            var btnEdit = this;
            mini.open({
                //url: bootPATH + "../demo/CommonLibs/SelectGridWindow.html",
                url: "Checkout/selectOrderIdWindow.jsp",
                title: "订单号列表",
                width: 850,
                height: 380,
                ondestroy: function (action) {
                    //if (action == "close") return false;
                    if (action == "ok") {
                        var iframe = this.getIFrameEl();
                        var data = iframe.contentWindow.GetData();
                        data = mini.clone(data);    //必须
                        if (data) {
                            btnEdit.setValue(data.orderId);
                            btnEdit.setText(data.orderId);
                        }
                    }

                }
                
            });
      	 }


		function doShow()   
	    { 
	         document.getElementById("span1").innerHTML="<input type=file id=upload size=40  name=upload label=上传文件   class=buttonface />";   
	    }   
	    
   		function onIDCardsValidation(e) {
            if (e.isValid) {
                var pattern = /\d*/;
                if (e.value.length < 15 || e.value.length > 18 || pattern.test(e.value) == false) {
                    e.errorText = "必须输入15~18位数字";
                    e.isValid = false;
                }
            }
        }

   		//验证QQ号码5-11位
   		function isQQ(e) {
   			if (e.isValid) {
                var pattern = /^\s*[.0-9]{5,11}\s*$/;
                if (!pattern.test(e.value)) {
                    e.errorText = "必须输入正确QQ号";
                    e.isValid = false;
                }
            }
   		}

   		//校验手机号码
   		function isMobile(e) {
   		    //var patrn = /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
   		    if (e.isValid) {
   		    	var pattern = /^(13[0-9]{9})|(14[0-9])|(18[0-9])|(15[0-9][0-9]{8})$/;
                if (!pattern.exec(e.value)) {
                    e.errorText = "必须输入正确手机号码";
                    e.isValid = false;
                }
            }
   		}

   		function isTelephone(e){
   			if (e.isValid) {
   				var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
   				var isMobile = /^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/
                if (!isPhone.exec(e.value)&&!isMobile.exec(e.value)) {
                    e.errorText = "必须输入正确电话号码";
                    e.isValid = false;
                }
            }
   			
   	   	}

   		function isOnlyTelephone(e){
   			if (e.isValid) {
   				var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
   				if (!isPhone.exec(e.value)) {
                    e.errorText = "必须输入正确电话号码";
                    e.isValid = false;
                }
            }
   			
   	   	}
   </script>
  </body>
</html>


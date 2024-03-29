<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.print(basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"><script type="text/javascript" src="<%=path %>/scripts/boot.js"></script>
    <title>工序计划界面</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <link href="<%=basePath%>demo/demo.css" rel="stylesheet" type="text/css" />
    <script src="<%=basePath%>scripts/boot.js" type="text/javascript"></script> 
    <style type="text/css">
    body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }    
    .header
    {
        background:url(../header.gif) repeat-x 0 -1px;
    }
    </style>
  </head>
  
  <%String product_type = request.getParameter("product_type");
  	System.out.println("==================================================="+product_type);
  %>
  
  <body>    
    
<!--Layout-->
<div id="layout1" class="mini-layout" style="width:100%;height:100%;">
    <div title="south" region="south" showSplit="false" showHeader="false" height="30" >
        <div style="line-height:28px;text-align:center;cursor:default">Copyright © 王露 （南京航空航天大学）版权所有 </div>
    </div>
    <div title="center" region="center" bodyStyle="overflow:hidden;" style="border:0;">
        <!--Splitter-->
        <div class="mini-splitter" style="width:100%;height:100%;" borderStyle="border:0;">
            <div size="180" maxSize="250" minSize="100" showCollapseButton="true" style="border-width:1px;">
                <input type="button" value="展开所有" onclick="expandAll()" style="font-weight:bold;font-weight:bold;width: 40%;font-size: 12px;"/>
    			<input type="button" value="折叠所有" onclick="collapseAll()" style="font-weight:bold;font-weight:bold;width: 40%;font-size: 12px;"/>
                
                <!--Tree-->
                <ul id="leftTree" class="mini-tree" style="width:100%;height:100%;" 
                    showTreeIcon="true" textField="id" idField="id" resultAsTree="false"
                    allowSelect="false" enableHotTrack="false" expandOnLoad="false"
                    showCheckBox="true" checkRecursive="false" autoCheckParent="true" 
			        contextMenu="#treeMenu" allowDrag="true"  ongivefeedback="onGiveFeedback"
			        allowDrop="true" allowLeafDropIn="true" value="base"  expandOnNodeClick="true" nodesField="children"
                >        
                </ul>
                
            </div>
            <div showCollapseButton="false" style="border:0px;" >
                <!--Tabs-->
                <div id="mainTabs" class="mini-tabs bg-toolbar" activeIndex="0" style="width:100%;height:100%;"      
                    onactivechanged="onTabsActiveChanged"
                >        
                    <div title="首页" url="<%=basePath %>lingjian.jsp" >        
                    </div>
                    <div title="甘特图" url="<%=basePath %>GT/demo/LpfMyHtml.html">
                    </div>
                    <div title="设备甘特图" url="<%=basePath %>GT/demo/wlfactorygandt.html"></div>
                </div>
            </div>        
        </div>
    </div>
</div>
<!-- 这里是右击后出现的面板！！！ -->
<ul id="treeMenu" class="mini-contextmenu"  onbeforeopen="onBeforeOpen">  
    <li onclick="onClickInto">查看详情</li> 
    <li onclick="gandT">甘特图</li>
    <li onclick="makeprocessplan1">制定工位计划</li>
    <li onclick="makdeprocessplan_list">批量工位计划</li>     
    <li class="separator"></li>
	<li name="edit" iconCls="icon-edit" onclick="onEditNode">编辑节点</li>
	<li name="remove" iconCls="icon-remove" onclick="onRemoveNode">删除节点</li>        
</ul>

<ul id="contextMenu" class="mini-contextmenu" >
    <li>
        <span >操作</span>
        <ul>
            <li iconCls="icon-new" onclick="onItemClick">新建</li>
            <li class="separator"></li>
            <li iconCls="icon-add" onclick="onItemClick">增加</li>    
            <li iconCls="icon-edit" onclick="onItemClick">修改</li>
            <li iconCls="icon-remove" onclick="onItemClick">删除</li>                      
        </ul>
    </li>
    <li class="separator"></li>
    <li iconCls="icon-open" >打开</li>
    <li iconCls="icon-remove" >关闭</li>
</ul>

    <script type="text/javascript">
      //  
        mini.parse();
        var tree = mini.get("leftTree"); 
        
        $.ajax({   
		    url:"<%=basePath%>demo/data/TreeService.jsp?method=LoadTreeprocess",
		    //async: false,
			type: "post",
			//dataType: "json", //返回的数据类型  
			success:callback //请求成功处理函数  
	    }); 
				
        function onItemClick(e) {
		    var item = e.sender;
		    alert(item.getText());     
		}
		
		window.onload = function () {
		    $("#region1").bind("contextmenu", function (e) {
		        var menu = mini.get("leftTree");
		        menu.showAtPos(e.pageX, e.pageY);
		        return false;
		    });
		}
			
	
        function callback(data){
            mini.parse();
            var tree = mini.get("leftTree");            
            var dataObj=eval("("+data+")");
            //alert(typeof(dataObj)); 
            tree.loadList(dataObj,"id","pid");
        }

        function showTab(node) {
            var tabs = mini.get("mainTabs");

            var id = "tab$" + node.id;
            var tab = tabs.getTab(id);
            if (!tab) {
                tab = {};
                tab._nodeid = node.id;
                tab.name = id;
                tab.title = node.text;
                tab.showCloseButton = true;

                //这里拼接了url，实际项目，应该从后台直接获得完整的url地址
                //tab.url = mini_JSPath + "../../docs/api/" + node.id + ".html";
                ///test/GT/demo/wlJsp.jsp?id=1
                //tab.url = mini_JSPath + "../../GT/demo/wlJsp.jsp?id="+node.id;
                tab.url = "<%=basePath %>processplan.do?flag=QueryprocessplanByID&id="+node.id;

                tabs.addTab(tab);
            }
            tabs.activeTab(tab);
        }

        function onNodeSelect(e) {
        
            var node = e.node;
            var isLeaf = e.isLeaf;

            if (isLeaf) {
                showTab(node);
            }
        }

        function onClick(e) {
            var text = this.getText();
            alert(text);
        }
        function onQuickClick(e) {
            tree.expandPath("datagrid");
            tree.selectNode("datagrid");
        }

        function onTabsActiveChanged(e) {
            var tabs = e.sender;
            var tab = tabs.getActiveTab();
            if (tab && tab._nodeid) {

                var node = tree.getNode(tab._nodeid);
                if (node && !tree.isSelectedNode(node)) {
                    tree.selectNode(node);
                }
            }
        }
        
        
        
        function onAddBefore(e) {
            var tree = mini.get("leftTree");
            var node = tree.getSelectedNode();

            var newNode = {};
            tree.addNode(newNode, "before", node);
        }
        function onAddAfter(e) {
            var tree = mini.get("leftTree");
            var node = tree.getSelectedNode();

            var newNode = {};
            tree.addNode(newNode, "after", node);
        }
        function onAddNode(e) {
            var tree = mini.get("leftTree");
            var node = tree.getSelectedNode();

            var newNode = {};
            tree.addNode(newNode, "add", node);
        }
        function onEditNode(e) {
            var tree = mini.get("leftTree");
            var node = tree.getSelectedNode();
            
            tree.beginEdit(node);
        }
        function onRemoveNode(e) {

            var tree = mini.get("leftTree");
            var node = tree.getSelectedNode();

            if (node) {
                if (confirm("确定删除选中节点?")) {
                    tree.removeNode(node);
                }
            }
        }
        function onMoveNode(e) {
            var tree = mini.get("leftTree");
            var node = tree.getSelectedNode();

            alert("moveNode");
        }
        
     
     
        
        function onClickInto(e){
            var tree = mini.get("leftTree");
            var node = tree.getSelectedNode();
            var tabs = mini.get("mainTabs");
            var value = tree.getValue();
            alert(value);
            var tab = tabs.getTab(value+"详细信息");
            if (!tab) {
                tab = {};
                tab._nodeid = value+"详细信息";
                tab.name = value+"详细信息";
                tab.title = value+"详细信息";
                tab.showCloseButton = true;

                //这里拼接了url，实际项目，应该从后台直接获得完整的url地址
                //tab.url = mini_JSPath + "../../docs/api/" + node.id + ".html";
                ///test/GT/demo/wlJsp.jsp?id=1
                //tab.url = mini_JSPath + "../../GT/demo/wlJsp.jsp?id="+node.id;
                if(!tree.hasChildren(node)){
                    tab.url = "<%=basePath %>processplan.do?flag=QueryprocessplanByID&id="+value+"&part=no";
                }
                if(tree.hasChildren(node)){
                    tab.url = "<%=basePath %>processplan.do?flag=QueryprocessplanByID&id="+value+"&part=yes";
                }

                tabs.addTab(tab);
            }
            tabs.activeTab(tab);
        }
        
        
        function makeprocessplan(e){
        	var tree = mini.get("leftTree");
            var node = tree.getSelectedNode();
            var tabs = mini.get("mainTabs");

            var id = "tab$" + node.id;
            var tab = tabs.getTab(id);
            if (!tab) {
                tab = {};
                tab._nodeid = node.id;
                tab.name = id;
                tab.title = node.text;
                tab.showCloseButton = true;
                //tab.url = "/test/processplan.do?flag=QueryprocessplanByID&id="+node.id;
                tab.url = "<%=basePath %>toprocessplan.do?flag=process&id="+node.id;

                tabs.addTab(tab);
            }
            tabs.activeTab(tab);

        }
        
        
        function makeprocessplan1(e){
        	var tree = mini.get("leftTree");
            var node = tree.getSelectedNode();
            var tabs = mini.get("mainTabs");
            var value = tree.getValue();
            alert(value);

            var tab = tabs.getTab(value+"工序计划");
            if (!tab) {
                tab = {};
                tab._nodeid = value+"工序计划";
                tab.name = value+"工序计划";
                tab.title = value+"工序计划";
                tab.showCloseButton = true;
                //tab.url = "/test/processplan.do?flag=QueryprocessplanByID&id="+node.id;
                tab.url = "<%=basePath %>processplan.do?flag=newprocessplan&id="+value;
                alert("tab.url=="+tab.url);
                tabs.addTab(tab);
            }
            tabs.activeTab(tab);

        }
        
        
        function makdeprocessplan_list(e){
        	var tree = mini.get("leftTree");
            var node = tree.getSelectedNode();
            var tabs = mini.get("mainTabs");
            
            var value = tree.getValue();
            //var id = "tab$" + node.id;
            var tab = tabs.getTab("批量工序计划");
            if (!tab) {
                tab = {};
                tab._nodeid = "批量工序计划";
                tab.name = "批量工序计划";
                tab.title = "批量工序计划";
                tab.showCloseButton = true;
                //tab.url = "/test/processplan.do?flag=QueryprocessplanByID&id="+node.id;
                tab.url = "<%=basePath %>processplan.do?flag=NL&id="+value;

                tabs.addTab(tab);
            }
            tabs.activeTab(tab);

        }
        
   
   
   
        function gandT(){
            var tree = mini.get("leftTree");
            var node = tree.getSelectedNode();
            var tabs = mini.get("mainTabs");
            var value = tree.getValue();
            alert(value);
            var tab = tabs.getTab(value+"甘特图");
            if (!tab) {
                tab = {};
                tab._nodeid = value+"甘特图";
                tab.name = value+"甘特图";
                tab.title = value+"甘特图";
                tab.showCloseButton = true;
                //tab.url = "/test/processplan.do?flag=QueryprocessplanByID&id="+node.id;
                tab.url = "<%=basePath %>GT/demo/wlJsp.jsp?id="+value;

                tabs.addTab(tab);
            }
            tabs.activeTab(tab);
        
        }
   
   
        
        function saveData() {
            var tree = mini.get("leftTree");
            var data = tree.getData();
            var json = mini.encode(data);

            //var msgid = mini.loading("数据保存中，请稍后......", "保存数据");
            $.ajax({
                url: "<%=basePath%>demo/data/TreeService.jsp?method=SaveTreeTotxt",
                data: { data: json },
                type: "post",
                success: function (text) {
                    mini.hideMessageBox(msgid);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                }
            });
        }

            
        
        function upDateNode(options){
		    var tree = mini.get("leftTree");
		    var node = tree.getSelectedNode();
		    options = mini.clone(options);
		    tree.updateNode(node,options)
		    saveData();
		}
		
		function onEditNode2(e) {
		    var tree = mini.get("leftTree");
		    var node = tree.getSelectedNode();
		    
		    mini.open({
			url: bootPATH+ "<%=basePath%>demo/tree/taskPanel/taskPanel.html",
		        title: "任务面板", width: 500, height: 300,
		        onload: function () {
		            var iframe = this.getIFrameEl();
		            iframe.contentWindow.SetData(node);
		        }
		    })
		}
		
		
		function onBeforeOpen(e) {
		    var menu = e.sender;
		    var tree = mini.get("leftTree");
		
		    var node = tree.getSelectedNode();
		    if (!node) {
		        e.cancel = false;//本来是ture的
		        return;
		    }
		    if (node && node.text == "jsq1") {
		        e.cancel = true;
		        //阻止浏览器默认右键菜单
		        e.htmlEvent.preventDefault();
		        return;
		    }
		    ////////////////////////////////
		    var editItem = mini.getbyName("edit", menu);
		    var removeItem = mini.getbyName("remove", menu);
		    editItem.show();
		    removeItem.enable();
		    if (node.id == "forms") {
		        editItem.hide();
		    }
		    if (node.id == "lists") {
		        removeItem.disable();
		    }
		}
		
		
		function collapseAll() {
            var tree = mini.get("leftTree");
            tree.collapseAll();
        }
        function expandAll() {
            var tree = mini.get("leftTree");
            tree.expandAll();
        }
        
        
        function onGiveFeedback(e) {
            var tree = e.sender;
            var node = e.node;              //被拖拽的节点
            var targetNode = e.targetNode;  //目标投放节点
            var effect = e.effect;          //投放方式：add|before|after

            var p1 = tree.getParentNode(node);
            var p2 = tree.getParentNode(targetNode);

            if (p1 != p2 || effect == "add") {
                e.effect = "no";
            }            
        }
    </script>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
$(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
$(function() {
	
	 $('#admin_menu_column_datagrid').bootstrapTable({
            url:rootPath + '/${MENU.channel}/query?tid=${dto.uuid != null ? dto.uuid : "false"}',
            height: '100%',
            sortName: 'createDate',
            sortOrder: 'desc',
            striped: true,
            pagination: true,
            pageSize: 10,
            pageList: [10, 25, 50, 100, 200],
            search: true,
            sidePagination:'client',
            idField: 'uuid',
            uniqueId: 'uuid',
            //responseHandler: responseHandler,
            //queryParams: queryParams,
            minimumCountColumns: 2,
            clickToSelect: true,
            columns: [{
                field: 'attributeName',
                title: '属性名',
                align: 'center',
                valign: 'middle'
            }, {
                field: 'attributeType',
                title: '属性类型',
                align: 'center',
                valign: 'middle'
            },{
                field: 'remake',
                title: '备注',
                align: 'center',
                valign: 'middle'
            },{
                field: 'defaultVal',
                title: '默认值',
                align: 'center',
                valign: 'middle'
            },{
                field: 'modifyDate',
                title: '修改时间',
                align: 'center',
                valign: 'middle',
                formatter:function(value,row,index){return new Date(value).pattern("yyyy-MM-dd HH:mm:ss")}
            }, {
                field: 'operate',
                title: '操作',
                width: 100,
                align: 'center',
                valign: 'middle',
                formatter: function(value, row, index)
                {
                	return [
                     	 	'<a class="edit" href="javascript:edit(\''+ row.uuid + '\')" title="edit">',
                     	 	'<i class="glyphicon glyphicon-edit"></i>',
                     	 	'</a> &nbsp;' ,
                     	 	'<a class="remove" href="javascript:remove(\''+ row.uuid + '\')" title="remove">',
                     	 	'<i class="glyphicon glyphicon-remove"></i>',
                     	 	'</a>'
                     	 	].join('');
                }
            }]
    	});
		
	   edit = function(cid)
	   {
		   console.info(uuid);
		   battcn.showWindow({
     			title:'编辑',
     			href:rootPath + "/${MENU.channel}/column?tid=${dto.uuid}&cid="+cid,
     			width:'50%',
     			height:'45%',
     			okhandler:function(){
     				battcn.ajaxJson({url:rootPath + "/${MENU.channel}/csave?tid=${dto.uuid}",data:$('#menuCodeColumnForm').serializeArray()},function(){
     					var str=$(".layui-layer").attr("times");
						var index=parseInt(str)+1;
						battcn.closeNestWindow(index);
						$('#admin_menu_column_datagrid').bootstrapTable('refresh');
     	   			});
     			},
     			cancelhandler:function(){
     				battcn.closeWindow();
     			}
     		}); 
	   }
	   
	   remove = function(uuid)
	   {
		   	battcn.ajaxJson({url:rootPath + '/op_remove_${OP.menu}',data:{"tid":"${dto.uuid}","cid":uuid}},function(){
		   		$('#admin_menu_column_datagrid').bootstrapTable('refresh');
   			});
	   }
   	 
   	 battcn.admin.menu${OP.menu}.save = function(obj) {
	  	if($("#menu${OP.menu}Form").valid()){
  			if(!CommnUtil.notNull($("#uuid").val()))
  			{
  				$("#uuid").val(battcn.uuid());
  			}
  			battcn.ajaxJson({url:rootPath + '/op_save_${OP.menu}',data: $('#menu${OP.menu}Form').serializeArray()},function(){
  				battcn.closeWindow();
		   		$('#admin_menu_column_datagrid').bootstrapTable('refresh');
   			});
		}
   	 };
});
	
	function addAttribute(uuid)
	{
		   battcn.showWindow({
  			title:'编辑',
  			href:rootPath + "/${MENU.channel}/column?tid=${dto.uuid}",
  			width:'50%',
  			height:'45%',
  			okhandler:function(){
  				if(!CommnUtil.notNull(uuid))
	  			{
	  				$("#cid").val(battcn.uuid());
	  			}
  				battcn.ajaxJson({url:rootPath + "/${MENU.channel}/csave?tid=${dto.uuid}",data: $('#menuCodeColumnForm').serializeArray()},function(){
  					$('#admin_menu_column_datagrid').bootstrapTable('refresh'); 
					var str=$(".layui-layer").attr("times");
					var index=parseInt(str)+1;
					battcn.closeNestWindow(index);
  	   			});
  			},
  			cancelhandler:function(){ 
  				battcn.closeWindow();
  			}
  		}); 
	}
</script>
<div class="ibox float-e-margins animated fadeInRight">
	<div class="ibox-content">
		<form class="form-horizontal m-t required-validate"
			id="menu${OP.menu}Form" method="post">
			<input type="hidden" name="uuid" id="uuid" value="${dto.uuid}">
			<div class="form-group">
				<label class="col-sm-2 control-label">上级包名：</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" name="upPackage"
						id="upPackage" value="${dto.upPackage}"
						placeholder="这里输入包名  (请不要输入特殊字符,请用纯字母)" title="包名称"
						validate="{required:true,messages:{required:'请填写名称'}}" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">处理类名：</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="processorClass"
						id="processorClass" value="${dto.processorClass}"
						placeholder="这里输入处理类名称" title="类名称" />
				</div>
				<div class="col-sm-6">
					<label class="col-sm-2 control-label">表前缀：</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="tablePrefix"
							id="tablePrefix" value="${dto.tablePrefix}" placeholder="这里输入表前缀"
							title="表前缀T_" />
					</div>
				</div>
			</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">功能简介：</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="content"
							   id="content" value="${dto.content}"
							   placeholder="这里输入功能简介" title="这里输入功能简介"
							   validate="{required:true,messages:{required:'请输入功能简介'}}" />
					</div>
					<div class="col-sm-6">
						<label class="col-sm-2 control-label">生成人：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="byUser"
								   id="byUser" value="${dto.byUser}" placeholder="这里输入生成人"
								   title="生成人" />
						</div>
					</div>
				</div>

		</form>
	</div>

	<div class="ibox float-e-margins">
		<div class="ibox-content">
			<div class="btn-group hidden-xs" id="exampleTableEventsToolbar"
				role="group">
				<button type="button" class="btn btn-outline btn-info" onclick="javascript:addAttribute()">
					<i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
				</button>
			</div>
			<div class="table-responsive" style="margin-top: 20px;">
				<div class="table-responsive">
					<table id="admin_menu_column_datagrid" data-toolbar="#toolbar"
						data-show-refresh="true" data-show-toggle="true"
						data-show-columns="true" data-show-footer="false"
						data-mobile-responsive="true">
					</table>
				</div>
			</div>
		</div>
	</div>
</div>

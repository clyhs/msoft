Ext.ns("MS.demo");

Ext.define('MS.demo.toolbar.demotoolbar', {
	extend:'Ext.toolbar.Toolbar',
	alias:'widget.demotoolbar',
	
	border:false,
	/*
	items:[{
		text:'edit',
		handler:function(grid, rowIndex, colIndex){
			//var grid = Ext.getCmp("demogrid");
			//var record = grid.getSelectionModel().getSelection()[0];
			alert(record.get('type'));
			var win = new MS.demo.window.Edit({
				hidden : true
			});
			
			var form = win.down('form').getForm();
			form.loadRecord(record);
			
			//form.findField('typeName').setValue(record.data.typeName);
			//form.findField('type').setValue(record.data.type);
			win.show();
		},
		scope:this
	},{
		text:'add'
	}],
	*/
	items:[{
		text:'add'
	},{
		text:'edit',
		handler:function(){
			//var grid = Ext.getCmp("demogrid");
			
			//alert(grid.getSelectionModel().getSelection().length);
			var len = grid.getSelectionModel().getSelection().length;
			if(len == 1){
				var record = grid.getSelectionModel().getSelection()[0];
				//alert(record.get('type'));
				var win = new MS.demo.window.Edit({
					hidden : true
				});
				
				var form = win.down('form').getForm();
				form.loadRecord(record);
				
				//form.findField('typeName').setValue(record.data.typeName);
				//form.findField('type').setValue(record.data.type);
				
				form.findField('typeName').setValue(record.get('typeName'));
				form.findField('type').setValue(record.get('type'));
				win.show();
			}else{
				Ext.Msg.alert("提示", "请选择一行");
			}
			
			
		},
		scope:this
	},{
		text:'多选',
		handler:function(){
			new MS.demo.window.MultiSelect();
		},
		scope:this
	},'->',{
		text:'刷新',
		iconCls:'refresh',
		handler:function(){
			grid.getStore().reload();
		},
		scope:this
	}],
	constructor: function (config) {
        this.initConfig(config); //将配置项初始化 //这里需要调用initConfig，否则不会自动生成getter 和 setter  
        this.callParent([config]); // 参数为数组
        grid = config.grid;
        
        
    },
	initComponent:function(config){
		var me = this;
		/*
		this.items = [{
			text:'edit',
			handler:function(){
				var record = grid.getSelectionModel().getSelection()[0];
				alert(record.get('type'));
			}
			
		}];*/
		Ext.apply(this,{});
		this.callParent(arguments); //调用父类方法
	}
});

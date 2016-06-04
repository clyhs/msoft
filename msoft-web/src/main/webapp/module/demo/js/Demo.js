Ext.ns("MS.demo");

Ext.define('MS.demo.grid.demogrid', {
	extend : 'Ext.grid.Panel',
	alias:'widget.demogrid',
	region : 'center',
	initComponent : function() {
		var me = this;
		/*define model*/
		Ext.define('MS.demo.model.Demo', {
		    extend: 'Ext.data.Model',
		    fields: [
		        {name: 'id',  type: 'int'},
		        {name: 'name', type: 'string'},
		        {name: 'typeName', type: 'string'},
		        {name: 'phone', type: 'string'},
		        {name: 'address', type: 'string'},
		        {name: 'type',type:'int'}
		    ]
		});
		
		/*define store*/
		var store = Ext.create('Ext.data.JsonStore',{
			model: 'MS.demo.model.Demo',
			pageSize : 30,
			proxy:{
				type:'ajax',
				url:'/module/demo/getPageData.json',
				reader: {
		            root: 'data',
		            totalProperty: 'totals'
		        }
					
			}
			
		});
		
		/*define columns*/
		var columns = [{
			header : 'id',
			dataIndex : 'id',
			flex : 1
		}, {
			header : 'name',
			dataIndex : 'name',
			flex : 1
		}, {
			header : 'typeName',
			dataIndex : 'typeName',
			flex : 1
		}, {
			header : 'phone',
			dataIndex : 'phone',
			flex : 1
		}, {
			header : 'address',
			dataIndex : 'address',
			flex : 1
		},{
			text : "type",
			dataIndex : 'type',
			hidden : true,
			sortable : false
		}];
		
		function showAlert(){
			//var selectedData=this.getSelectionModel().getSelection()[0].data;
			//Ext.MessageBox.alert("标题",selectedData.name);
			alert('1')
		};
		
		Ext.apply(this, {
			id:'demogrid',
			store : store,
			columns : columns,
			stripeRows : true,
		    loadMask: true,
		    border:false,
		    multiSelect: true, 
		    selModel: { selType: 'checkboxmodel' },
		    /*
		    tbar:[{
		    	text:'add',
		    	iconCls : 'icon-add',
		    	handler:function(){
		    		alert('add');
		    	}
		    },{
		    	text:'edit',
		    	iconCls : 'icon-edit',
		    	handler:showAlert,
		    	scope:this
		    },{
		    	text:'test',
		    	iconCls : 'icon-test',
		    	handler:function(){
		    		var selectedData=this.getSelectionModel().getSelection()[0].data;
					Ext.MessageBox.alert("标题",selectedData.name);
		    	},
		    	scope:this
		    }],
		    tbar: [{
	            xtype: 'demotoolbar' //这种方式toolbar只能 用var grid = Ext.getCmp("demogrid");
	        }],*/
		    tbar:new MS.demo.toolbar.demotoolbar({grid:this}),
			bbar: Ext.create('Ext.PagingToolbar', {
		    	store: store,
		        displayInfo: true,
		        displayMsg: 'Displaying data {0} - {1} of {2}',
		        emptyMsg: "No data to display"
		        
		    })
		});
		store.loadPage(1);
		this.callParent(arguments);
	}
})
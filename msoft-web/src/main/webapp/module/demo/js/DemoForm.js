Ext.ns("MS.demo");

var comboboxStore = Ext.create('Ext.data.JsonStore', {
	proxy : {
		type : 'ajax',
		url : '/module/demo/getCombobox.json',
		reader : {
			type : 'json',
			idProperty : 'id'
		}
	},
	fields : [ 'id', 'value' ]
});

Ext.define('MS.demo.window.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.demoedit',

    requires: ['Ext.form.Panel'],

    title : 'Edit demo',
    layout: 'fit',
    autoShow: true,
    height: 240,
    width: 400,
    modal:true,
    constructor: function (config) {
        this.initConfig(config); //将配置项初始化 //这里需要调用initConfig，否则不会自动生成getter 和 setter  
        this.callParent([config]); // 参数为数组
        //this.title = config.title;
    },
    
    initComponent: function() {
    	this.items =[{ xtype: 'form',
            padding: '5 5 0 5',
            border: false,
            items:[{
        		xtype: 'hidden',
        		name : 'id',
        		fieldLabel: 'id'
    		}, {
    			xtype: 'textfield',
    			name : 'name',
    			fieldLabel: 'name'
    		},{
    			xtype : 'combobox',
				fieldLabel : '角色',
				name : 'typeName',
				store : comboboxStore,
				valueField : 'id',
				displayField : 'value',
				typeAhead : true,
				queryMode : 'remote',
				emptyText : '请选择...',
				allowBlank : false,
				editable : false,
				listeners : {
					select : function(combo, record, index) {
						//alert(combo.getValue());
						Ext.getCmp("type").setValue(combo.getValue());
					}
				}
    		},{
    			xtype: 'hiddenfield',
    			id:'type',
    			name : 'type',
    			fieldLabel: 'type'
    		}, {
    			xtype: 'textfield',
    			name : 'phone',
    			fieldLabel: 'phone'
    		}, {
    			xtype: 'textfield',
    			name : 'address',
    			fieldLabel: 'address'
    		}]
    	}];
    	this.buttons = [{
            text: 'Save',
            scope:this,
            handler:function(btn,e){
            	var window = btn.up('window');
				var form = window.down('form').getForm();
				if(form.isValid()){
					var vals = form.getValues();
					//alert(vals['id']);
					//alert(vals['typeName']);
					form.submit({
						method:'post',
						url : 'editDemo.html',
						waitTitle: '温馨提示',
						waitMsg: '数据正在提交中，请稍候...',
						success : function(form,action) 
						{
							//Ext.MessageBox.alert('success', action.result.msg);
							g_oViewPort.items.get(0).getStore().reload();
							window.close();
						},
						failure : function(form,action) 
						{
							Ext.MessageBox.alert('出错提示', 'eee');
						}
							
					});
				}
            }
        },
        {
            text: 'Cancel',
            scope: this,
            handler: this.close
        }];
    	this.callParent();
    	
    }
});
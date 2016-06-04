Ext.ns("MS.security.tree");

/*
 * 
 * 
 * initComponent 和 constructor 就是Extjs 提供用来实现继承和扩展的方式。
 * initComponent这个方法是在Ext.Component的构造函数(constructor)中调用的，
 * 只有直接或间接继承自 Ext.Component的类才会在constructor里调用initComponent方法
 * 自定义类中的 initComponent　函数中必须调用 callParent();否则 调用者无法初始化这个对象
 * 
 * 
 * */

Ext.define('MS.security.tree.AddTreePanel', {
    extend: 'Ext.window.Window',
    alias : 'widget.addtreepanel',

    requires: ['Ext.form.Panel'],
    id:'security_tree_AddTreePanel_id',
    layout: 'fit',
    autoShow: true,
    height: 240,
    width: 400,
    modal: true,
    constructor: function (config) {
        this.initConfig(config); //将配置项初始化 //这里需要调用initConfig，否则不会自动生成getter 和 setter  
        this.callParent([config]); // 参数为数组
        //this.title = config.title;
    },
    initComponent: function() {
    	var me = this;
    	this.items =[{ xtype: 'form',
            padding: '5 5 0 5',
            border: false,
            items:[{
        		xtype: 'hidden',
        		name : 'id',
        		fieldLabel: 'id'
    		}, {
    			xtype: 'textfield',
    			name : 'text',
    			fieldLabel: 'name'
    		}, {
    			xtype: 'textfield',
    			name : 'icons',
    			fieldLabel: 'icons'
    		}, {
    			xtype: 'textfield',
    			name : 'url',
    			fieldLabel: 'url'
    		}]
    	}];
    	this.buttons = [{
            text: '保存',
            scope:this,
            handler:function(btn,e){
            	var window = btn.up('window');
				var form = window.down('form').getForm();
				if(form.isValid()){
					var vals = form.getValues();
					
				}
            }
        },
        {
            text: 'Cancel',
            scope: this,
            handler: this.close
        }];
    	
    	
    	
    	Ext.apply(this,{
    	});
    	//需要调用callParent( arguments);否则 调用者无法初始化这个对象
    	//this.callParent(arguments);
    	this.callParent();
    	
    }
});
Ext.ns("MS.security.role");

Ext.define('MS.security.role.RoleTreeMenu', {
	extend: 'Ext.menu.Menu',
	xtype: 'listsContextMenu',
	id:'security_role_RoleTreeMenu_id',
    items: [{
    	text: '添加',
        iconCls: 'a_add',
        id: 'new-list-item',
        handler: function(){
        	//mainWin.win = new MS.security.role.Edit();
        	var roleNode = mainWin.getSelectionModel().getSelection()[0];
        	roleRightPanel.expand();
        	
        	var beforePanel = roleRightPanel.layout.activeItem;
        	//alert(beforePanel);
        	if(beforePanel!=null){
        		//Ext.Msg.alert('提示','请先关闭');
        		Ext.MessageBox.confirm('温馨提示', '您正处于新增界面，确定离开吗？', function(buttonId, text, opt){
    				if(buttonId == 'yes'){
    					beforePanel.hide();
    					roleRightPanel.remove(roleRightPanel.items.get(0));
    	            	mainWin.rightWin =new MS.security.role.AddRolePanel({
    	            		hidden : true
    	            	});
    	        		var form = mainWin.rightWin.down('form').getForm();
    	        		form.findField('name').setValue(roleNode.data.id+'name');
    	        		roleRightPanel.add(mainWin.rightWin);
    	        		mainWin.rightWin.show();
    	        		roleRightPanel.doLayout();
    	        		roleRightPanel.getLayout().setActiveItem('security_role_addRolePanel_id');
    				}
    			});
        		
            	
        	}else{
        		mainWin.rightWin =new MS.security.role.AddRolePanel({
            		hidden : true
            	});
        		var form = mainWin.rightWin.down('form').getForm();
        		form.findField('name').setValue(roleNode.data.id+'name');
        		roleRightPanel.add(mainWin.rightWin);
        		mainWin.rightWin.show();
        		roleRightPanel.doLayout();
        		roleRightPanel.getLayout().setActiveItem('security_role_addRolePanel_id');
        	}
        	
        },
        scope: this
    },{
    	text: '修改',
        iconCls: 'a_edit',
        id: 'edit-list-item',
        handler: function(){
        	
        },
        scope: this
    },{
    	text: '删除',
        iconCls: 'a_delete',
        id: 'delete-list-item',
        handler: function(){
        	
        	
        },
        scope: this
    }],
    constructor: function (config) {
        this.initConfig(config); 
        this.callParent([config]); 
        mainWin = config.mainWin;
    },
    initComponent: function() {
    	var me = this;
    	this.callParent();
    }
});
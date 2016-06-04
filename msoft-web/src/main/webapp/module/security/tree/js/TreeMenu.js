Ext.ns("MS.security.tree");

Ext.define('MS.security.tree.TreeMenu', {
	extend: 'Ext.menu.Menu',
	xtype: 'listsContextMenu',
	id:'security_tree_TreeMenu_id',
    items: [{
    	text: '添加',
        iconCls: 'a_add',
        id: 'new-list-item',
        handler: function(){
        	var tree = Ext.getCmp("security_tree_TreePanel_id");
        	var record = tree.getSelectionModel().getSelection()[0];
        	alert(record.data.id);
        	alert(record.data.text);
        	alert(record.raw.url);
        },
        scope: this
    },{
    	text: '修改',
        iconCls: 'a_edit',
        id: 'edit-list-item',
        handler: function(){
        	var tree = Ext.getCmp("security_tree_TreePanel_id");
        	
        	var record = tree.getSelectionModel().getSelection()[0];
        	//alert(record.data.id);
        	//alert(record.raw.icons);
        	//alert(record.raw.url);
        	var win = new MS.security.tree.AddTreePanel({
				hidden : true,
				title:'修改'
			});
        	var form = win.down('form').getForm();
			form.loadRecord(record);
			form.findField('icons').setValue(record.raw.icons);
			form.findField('url').setValue(record.raw.url);
        	win.show();
        	
        },
        scope: this
    },{
    	text: '删除',
        iconCls: 'a_delete',
        id: 'delete-list-item',
        handler: function(){
        	var tree = Ext.getCmp("security_tree_TreePanel_id");
        	var record = tree.getSelectionModel().getSelection()[0];
        	alert(record.data.id);
        	alert(record.data.text);
        	alert(record.raw.url);
        	
        },
        scope: this
    }]
});
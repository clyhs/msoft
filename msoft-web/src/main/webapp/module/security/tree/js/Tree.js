Ext.ns("MS.security.tree");

var treeStore = Ext.create('Ext.data.TreeStore', {
    proxy: {
        type: 'ajax',
        url: '/module/security/getAllTree.json'
    },
    sorters: [{
        property: 'leaf',
        direction: 'ASC'
    }, {
        property: 'text',
        direction: 'ASC'
    }]
});

Ext.define('MS.security.tree.TreePanel', {
	extend: 'Ext.tree.Panel',
	region:'center',
	id:'security_tree_TreePanel_id',
    store: treeStore,
    rootVisible: false,
    useArrows: true,
    frame: false,
    title: '导航菜单',
    split : true,
    collapsible: false,
	animCollapse : true,
    listeners : {
		'itemclick' : function(e, record) {
			alert(record.data.id);
		}
	},
	initComponent: function () {
		var me = this;
		
		me.contextMenu = Ext.create("MS.security.tree.TreeMenu");
        me.callParent(); 
        me.on("itemcontextmenu", me.showContextMenu, me);
	},
	showContextMenu: function (view, list, node, rowIndex, e) {
        this.contextMenu.showAt(e.getX(), e.getY());
        e.preventDefault();
    }
});















/*
var treePanel = Ext.create('Ext.tree.Panel', {
	region:'center',
	id:'security_tree_id',
    store: treeStore,
    rootVisible: false,
    useArrows: true,
    frame: false,
    title: '导航菜单',
    split : true,
    collapsible: false,
	animCollapse : true,
    listeners : {
		'itemclick' : function(e, record) {
			alert(record.data.id);
		}
	}
});*/
//treePanel.expandAll();
//treePanel.collapseAll();

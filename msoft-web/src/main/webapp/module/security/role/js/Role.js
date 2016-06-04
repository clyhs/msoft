Ext.ns("MS.security.role");

var roleStore = Ext.create('Ext.data.TreeStore', {
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

Ext.define('MS.security.role.RoleTreePanel', {
	extend: 'Ext.tree.Panel',
	region:'center',
	id:'security_role_RoleTreePanel_id',
    store: roleStore,
    rootVisible: false,
    useArrows: true,
    frame: false,
    title: '角色',
    
    split : true,
    collapsible: false,
	animCollapse : true,
    listeners : {
		'itemclick' : function(e, record) {
			//alert(record.data.id);
		}
	},
	initComponent: function () {
		var me = this;
		var menu = new MS.security.role.RoleTreeMenu({mainWin:this});
		me.contextMenu = menu;
        me.callParent(); 
        me.on("itemcontextmenu", me.showContextMenu, me);
	},
	showContextMenu: function (view, list, node, rowIndex, e) {
        this.contextMenu.showAt(e.getX(), e.getY());
        e.preventDefault();
    }
});



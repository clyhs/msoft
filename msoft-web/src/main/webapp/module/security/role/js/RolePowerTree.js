Ext.ns("MS.security.role");

var powerStore = Ext.create('Ext.data.TreeStore', {
    proxy: {
        type: 'ajax',
        url: '/module/ttree/test.json'
    },
    sorters: [{
        property: 'leaf',
        direction: 'ASC'
    }, {
        property: 'text',
        direction: 'ASC'
    }]
});

Ext.define('MS.security.role.RolePowerTree', {
	extend: 'Ext.tree.Panel',
	alias : 'widget.powertree',
	id:'security_role_RolePowerTree_id',
    store: powerStore,
    rootVisible: true,
    useArrows: true,
    frame: false,
    title: '导航权限树',
    split : true,
    collapsible : true,
	animCollapse : true,
	root:{id:'0',text:'rootest',checked:false},
    height:'70%',
    border:false,
    constructor: function (config) {
        this.initConfig(config); 
        this.callParent([config]); 
    },
    listeners : {
		'itemclick' : function(e, record) {
		},
		'checkchange':function(node, checked){
			//alert('check');
    		if(node == this.getRootNode()){
    			//alert('root');
    			this.allSelect(node,checked);
    		}else{
    			if(checked){
    				this.allChildSelect(node,checked);
    				this.upSelect(node,checked);
    			}else{
    				this.downUnSelect(node,checked);
    			}
    		}
		}
	},
	initComponent: function () {
		var me = this;
		this.callParent(); 
	},
	setChecked:function(node,checked){
		//alert(checked);
		node.checked = checked;
		node.set('checked',checked);
	},
	allSelect:function(node,checked){
		this.setChecked(node,checked);
		var childrens = node.childNodes;
		for(var i=0;i<childrens.length;i++){
			this.allSelect(childrens[i],checked);
		}
	},
	allChildSelect:function(node,checked){
		var childrens = node.childNodes;
		for(var i=0;i<childrens.length;i++){
			var nd = childrens[i];
			if(!nd.checked){
				this.setChecked(nd,checked);
			}
			if(nd.hasChildNodes()){
				this.allChildSelect(nd,checked);
			}
		}
	},
	upSelect:function(node,checked){
		var parentNode = node.parentNode;
		if(parentNode)
		{
			if(!parentNode.checked)
			{
				this.setChecked(parentNode, checked);
			}
			this.upSelect(parentNode,checked);
		}
	},
	downUnSelect : function(node,checked)
	{
		
		
		
			this.setChecked(node, checked);
		
		
		var childNodes = node.childNodes;
		for(var i = 0; i< childNodes.length;  i++)
		{
			this.downUnSelect(childNodes[i],checked);
		}
	}
});

Ext.ns("MS.security.role");

Ext.define('MS.security.role.RoleRightPanel', {
	extend: 'Ext.Panel',
	layout:'card',
	id:'security_role_RoleRightPanel_id',
	region: 'east',
	title: '角色权限',
	width: 700,
	margins: '0 0 5 0',
	cmargins: '0 5 5 5',
	split: true,  
	header:false,  
	useSplitTips:true,
	collapsible : true,
	collapsed: true,
	border: false,
	collapsibleSplitTip:'可拖动，双击收起',   
	activeItem : 0,
	items:[],
	initComponent: function () {
		var me = this;
		me.callParent();
	}
});
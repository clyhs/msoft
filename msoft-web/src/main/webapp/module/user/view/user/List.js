Ext.define('MS.view.user.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.userlist',

    title : '用户管理',
    store: 'Users',

    columns: [
        {header: 'id',  dataIndex: 'id',  flex: 1},
        {header: 'username', dataIndex: 'username', flex: 1},
        {header: 'sex',  dataIndex: 'sex',  flex: 1},
        {header: 'phone', dataIndex: 'phone', flex: 1},
        {header: 'address',  dataIndex: 'address',  flex: 1}
    ],
    tbar:[{
    	text:'add',
    	
    },'-',{
    	text:'modify',
    	handler: function(b) {
            Ext.Msg.alert('Click', 'You clicked ' + b.text);
        }
    }]
});

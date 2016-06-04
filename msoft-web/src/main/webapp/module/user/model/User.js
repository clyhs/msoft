Ext.define('MS.model.User', {
    extend: 'Ext.data.Model',
    
    proxy: {
        type: 'memory'
    },
    
    fields: [
        {name: 'id',  type: 'int'},
        {name: 'username', type: 'string'},
        {name: 'sex', type: 'int'},
        {name: 'phone', type: 'string'},
        {name: 'address', type: 'string'}
    ]
});
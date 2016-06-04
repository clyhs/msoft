Ext.define('MS.view.user.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.useredit',

    requires: ['Ext.form.Panel'],

    title : 'Edit User',
    layout: 'fit',
    autoShow: true,
    height: 200,
    width: 280,

    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                padding: '5 5 0 5',
                border: false,
                style: 'background-color: #fff;',

                items: [
                    {
                        xtype: 'textfield',
                        name : 'id',
                        fieldLabel: 'id'
                    },
                    {
                        xtype: 'textfield',
                        name : 'username',
                        fieldLabel: 'username'
                    },
                    {
                        xtype: 'textfield',
                        name : 'sex',
                        fieldLabel: 'sex'
                    },
                    {
                        xtype: 'textfield',
                        name : 'phone',
                        fieldLabel: 'phone'
                    },
                    {
                        xtype: 'textfield',
                        name : 'address',
                        fieldLabel: 'address'
                    }
                ]
            }
        ];

        this.buttons = [
            {
                text: 'Save',
                action: 'save'
            },
            {
                text: 'Cancel',
                scope: this,
                handler: this.close
            }
        ];

        this.callParent(arguments);
    }
});

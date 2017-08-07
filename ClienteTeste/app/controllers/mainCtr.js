(function () {
    "use strict";

    angular.module('AppGMA').controller('MainCtr', MainCtr);

    MainCtr.$inject = ['$window', '$rootScope', '$location'];

    function MainCtr($window, $rootScope, $location)
    {
        var _this = this;
         
        _this.listaMsg = [];
        _this.isShowMsg = false;

        _this.active = 0;
        

        _this.showView=function(url,val)
        {
            _this.active = val;
            $location.url('/' + url);
        }
        

        _this.fechar=function()
        {
            _this.listaMsg = [];
            _this.isShowMsg = false;
        }
        
        var eventoShow = $rootScope.$on('show.msg', function (event, listaMsg)
        {
            _this.listaMsg = listaMsg; 
            _this.isShowMsg = true;

        });

        var eventoShow = $rootScope.$on('show.fechar', function (event) {
            _this.fechar();

        });

    };


}());
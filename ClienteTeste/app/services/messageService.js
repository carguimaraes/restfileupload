(function () {
    "use strict";


    angular.module('AppGMA').service('MessageService', MessageService);

    MessageService.$inject =['$rootScope'];
    
    function MessageService($rootScope) {
        var _this = this;
              

        _this.showMessage = function (lstMsg)
        {
           
           $rootScope.$broadcast('show.msg', lstMsg);

        };
        
      
    }





}());
(function () {
    "use strict";
    
    angular.module('AppGMA').service('ObraWebApiService', ObraWebApiService);

    ObraWebApiService.$inject = ['$http', '$q','GMAGlobal'];

    function ObraWebApiService($http, $q,GMAGlobal) {
        var _this = this;
             

        _this.obterLista = function ()
        {
            var config = {  headers:  {  "X-CustomToken" : GMAGlobal.token  } };
          
            var myDefer = $q.defer();
            $http.get('http://localhost:8081/api/v1/obras',config)
                .then(function successCallback(response)
                {
                   
                    myDefer.resolve(response.data);

                }, function errorCallback(response)
                {
                  
                    myDefer.reject(response.data);
                });


            return myDefer.promise;
        };

     

    }



}());
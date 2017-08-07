(function () {
    "use strict";
    
    angular.module('AppGMA').service('LoginWebApiService', LoginWebApiService);

    LoginWebApiService.$inject = ['$http', '$q','GMAGlobal'];

    function LoginWebApiService($http, $q,GMAGlobal) {
        var _this = this;
             

        _this.executar = function (userName,psw)
        {
            var strLogin=userName+";"+psw;
            var config = {  headers:  {  "X-LOGIN" : strLogin  } };
           
            var myDefer = $q.defer();
            $http.get('http://localhost:8081/api/v1/login',config)
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
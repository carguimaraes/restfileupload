(function () {
    "use strict";

    var app = angular.module('AppGMA', ["ngRoute"]);

    app.value('GMAGlobal', {token:""});


    app.config(ConfigRota);
    app.config(ConfigIntercepto);

  //  ConfigRota.$inject = ['$routeProvider', '$locationProvider'];
 //   ConfigIntercepto.$inject = ['$httpProvider'];  


    function ConfigRota ($routeProvider, $locationProvider)
    {
       
        $routeProvider
        .when('/Login', {
            templateUrl: 'app/vw/Login.html?v=b1233a11223',
            controller: 'LoginCtr',
           controllerAs: 'loginCtr'
         })
       .when('/Obra', {
            templateUrl: 'app/vw/Obra.html?v=b1223345',
             controller: 'ObraCtr',
             controllerAs: 'obraCtr'
          })

       .otherwise({ redirectTo: '/' });
            
        $locationProvider.html5Mode(false); //.hashPrefix("");
    } 

    function ConfigIntercepto($httpProvider)
    {
        
        $httpProvider.interceptors.push(function ($q, $rootScope) {
            return                 {
                'request': function (config) {
                    $rootScope.$broadcast('show.fechar');
                    $rootScope.$broadcast('carregando-inicio');
                    return config || $q.when(config);
                }, 
                'response': function (response) {
                    $rootScope.$broadcast('carregando-fim');

                   return response || $q.when(response);
                },
                'responseError': function (response) {
                    $rootScope.$broadcast('carregando-fim');
                
                    var listaMsg = response.data;
                                                          
                    if (listaMsg == undefined)
                    {
                        listaMsg = [response.statusText];
                    }

                    response.data = { statusCode: response.status, listaMensagem: listaMsg }

                
                    $rootScope.$broadcast('show.msg', listaMsg);
                    
                    return $q.reject(response);
                   
                },
                'requestError': function (response) {
                    $rootScope.$broadcast('carregando-fim');
                    return response || $q.when(response);
                },
                'request': function (config) {
                   //TODO retirar nao sera mais necessario 
                 //   config.headers['Token'] = "GMA-TOKEN";
                    return config;
                },
            };
        });

    }


}());





 
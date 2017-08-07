(function () {
    "use strict";

    angular.module('AppGMA').controller('LoginCtr', LoginCtr);


    LoginCtr.$inject = ['GMAGlobal','LoginWebApiService'];


    function LoginCtr(GMAGlobal,loginWebApiService)
    {
        var _this = this;
      
        _this.titulo = "GMA App-Login";
      
       

       loginWebApiService.executar("carguimaraesgma@gmail.com","gma123" )
        .then(function (dadosRet)
         {
         
               GMAGlobal.token=dadosRet.Token;
              _this.titulo =GMAGlobal.token;
          });

    }

}());
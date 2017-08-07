(function () {
    "use strict";

    angular.module('AppGMA').controller('ObraCtr', ObraCtr);
  
  
   ObraCtr.$inject = ['ObraWebApiService','GMAGlobal'];


    function ObraCtr(obraWebApiService,GMAGlobal)
    {
         var _this = this;
       
          _this.titulo = "Obra Token==>"+GMAGlobal.token;


       obraWebApiService
         .obterLista( )
         .then(function (dadosRet)
         {
             
             _this.listaObra =dadosRet;        
        });


    }
          
         
    
 

}());

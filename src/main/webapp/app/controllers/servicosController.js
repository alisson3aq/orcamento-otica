mainApp
.controller('servicosController', function($scope,$http) {

        $http.get("api/v1/servicos")
            .then(function (response) {
/*            [
               {
                  "codigo":"0521",
                  "descricao":"Limpeza de lentes",
                  "unidade":"par",
                  "valorUnitario":113.900000000000005684341886080801486968994140625,
                  "fornecedor":"In House"
               },
               {
                  "codigo":"0522",
                  "descricao":"Conserto de armação",
                  "unidade":"un",
                  "valorUnitario":123.5,
                  "fornecedor":"In house"
               }
            ]*/
                $scope.servicos = response.data;
        });

})
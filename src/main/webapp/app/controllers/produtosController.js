mainApp
.controller('produtosController', function($scope,$http) {
        $http.get("api/v1/produtos")
            .then(function (response) {
/*            [
               {
                  "codigo":"0466",
                  "descricao":"Oculos de sol",
                  "fabricante":"Mormai",
                  "unidade":"un",
                  "valorUnitario":199.99
               },
               {
                  "codigo":"0465",
                  "descricao":"Lente de contatos",
                  "fabricante":"Mormai",
                  "unidade":"un",
                  "valorUnitario":19.99
               }
            ]*/
                $scope.produtos = response.data;
        });
})
mainApp
.controller('produtosController', function($scope,$http) {
               $scope.produto = {};
               $scope.showSuccessAlert = false;
               $scope.showErrorAlert = false;

               $scope.listarProdutos = function(){
                   $http.get("api/v1/produtos")
                       .then(function (response) {
                           $scope.produtos = response.data;
                   });
               }

                $scope.listarProdutos();

                $scope.excluir = function(codigo){
                    $http.delete('api/v1/produtos/' + codigo)
                        .then(function (response) {
                            $scope.produtos = response.data;
                    });
                }

                $scope.create = function(){
                    var data = {
                        codigo : $scope.produto.codigo,
                        descricao : $scope.produto.descricao,
                        unidade : $scope.produto.unidade,
                        valorUnitario : $scope.produto.valorUnitario,
                        fabricante : $scope.produto.fabricante
                    };
                    $http.post('api/v1/produtos/', data)
                    .success(function(data, status) {
                        $scope.produtos = data;
                        $scope.produto = {};
                        $scope.showSuccessAlert = true;
                        $scope.showErrorAlert = false;
                    })
                    .error(function(data, status) {
                       $scope.showErrorAlert = true;
                       $scope.showSuccessAlert = false;
                    });
                }
})
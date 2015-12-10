mainApp
.controller('servicosController', function($scope,$http) {

        $scope.servico = {};
        $scope.showSuccessAlert = false;
        $scope.showErrorAlert = false;

        $scope.listarServicos = function(){
            $http.get("api/v1/servicos")
                .then(function (response) {
                    $scope.servicos = response.data;
            });
        }

         $scope.listarServicos();

         $scope.excluir = function(codigo){
             $http.delete('api/v1/servicos/' + codigo)
                 .then(function (response) {
                     $scope.servicos = response.data;
             });
         }

         $scope.create = function(){
             var data = {
                 codigo : $scope.servico.codigo,
                 descricao : $scope.servico.descricao,
                 unidade : $scope.servico.unidade,
                 valorUnitario : $scope.servico.valorUnitario,
                 fornecedor : $scope.servico.fornecedor
             };
             $http.post('api/v1/servicos/', data)
             .success(function(data, status) {
                 $scope.servicos = data;
                 $scope.servico = {};
                 $scope.showSuccessAlert = true;
                 $scope.showErrorAlert = false;
             })
             .error(function(data, status) {
                $scope.showErrorAlert = true;
                $scope.showSuccessAlert = false;
                $scope.servico = {};
             });
         }

})
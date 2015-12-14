mainApp
.controller('clientesController', function($scope,$http) {
        $scope.cliente = {};
        $scope.showSuccessAlert = false;
        $scope.showErrorAlert = false;

        $scope.listarClientes = function(){
            $http.get("api/v1/clientes")
                .then(function (response) {
                    $scope.clientes = response.data;
            });
        }

         $scope.listarClientes();

         $scope.excluir = function(cpf){
             $http.delete('api/v1/clientes/' + cpf)
                 .then(function (response) {
                     $scope.clientes = response.data;
             });
         }

         $scope.create = function(){
             var data = {
                 nome : $scope.cliente.nome,
                 cpf : $scope.cliente.cpf,
                 endereco : $scope.cliente.endereco,
                 bairro : $scope.cliente.bairro,
                 cidade : $scope.cliente.cidade,
                 estado : $scope.cliente.estado,
                 cep : $scope.cliente.cep,
                 telefone : $scope.cliente.telefone,
                 email : $scope.cliente.email
             };
             $http.post('api/v1/clientes/', data)
             .success(function(data, status) {
                 $scope.clientes = data;
                 $scope.cliente = {};
                 $scope.showSuccessAlert = true;
                 $scope.showErrorAlert = false;
             })
             .error(function(data, status) {
                $scope.showErrorAlert = true;
                $scope.showSuccessAlert = false;
             });
         }
})
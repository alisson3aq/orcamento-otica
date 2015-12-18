mainApp
.controller('empresaController', function($scope,$http) {
        $scope.showSuccessAlert = false;
        $scope.showErrorAlert = false;

        $scope.getEmpresa = function(){
           $http.get("api/v1/empresas/mockId")
               .then(function (response) {
                   $scope.empresa = response.data;
           });
        }

        $scope.getEmpresa();

        $scope.excluir = function(codigo){
            $http.delete('api/v1/empresas/' + codigo)
                .then(function (response) {

            });
        }

        $scope.editar = function(){
            var data = {
                nome : $scope.empresa.nome,
                cnpj : $scope.empresa.cnpj,
                endereco : $scope.empresa.endereco,
                bairro : $scope.empresa.bairro,
                cidade : $scope.empresa.cidade,
                estado : $scope.empresa.estado,
                cep : $scope.empresa.cep,
                telefone : $scope.empresa.telefone,
                email : $scope.empresa.email
            };
            $http.put('api/v1/empresas/', data)
            .success(function(data, status) {
                $scope.showSuccessAlert = true;
                $scope.showErrorAlert = false;
            })
            .error(function(data, status) {
               $scope.showErrorAlert = true;
               $scope.showSuccessAlert = false;
            });
        }


        $scope.create = function(){
            var data = {
                nome : $scope.empresa.nome,
                cnpj : $scope.empresa.cnpj,
                endereco : $scope.empresa.endereco,
                bairro : $scope.empresa.bairro,
                cidade : $scope.empresa.cidade,
                estado : $scope.empresa.estado,
                cep : $scope.empresa.cep,
                telefone : $scope.empresa.telefone,
                email : $scope.empresa.email
            };
            $http.post('api/v1/empresas/', data)
            .success(function(data, status) {
                $scope.showSuccessAlert = true;
                $scope.showErrorAlert = false;
            })
            .error(function(data, status) {
               $scope.showErrorAlert = true;
               $scope.showSuccessAlert = false;
            });
        }
})
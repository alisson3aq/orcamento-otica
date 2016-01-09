mainApp
.controller('medicosController', function($scope,$http) {
        $scope.medico = {};
        $scope.showSuccessAlert = false;
        $scope.showErrorAlert = false;

        $scope.medico.nome;
        $scope.medico.crm;
        $scope.medico.clinica;
        $scope.medico.telefone;
        $scope.medico.email;

        $scope.listarMedicos = function(){
            $http.get("api/v1/medicos")
                .then(function (response) {
                    $scope.medicos = response.data;
            });
        }

         $scope.listarMedicos();

         $scope.excluir = function(codigo){
             $http.delete('api/v1/medicos/' + codigo)
                 .then(function (response) {
                     $scope.medicos = response.data;
             });
         }

         $scope.create = function(){
             var data = {
                 nome : $scope.medico.nome,
                 crm : $scope.medico.crm,
                 clinica : $scope.medico.clinica,
                 telefone : $scope.medico.telefone,
                 email : $scope.medico.email
             };
             $http.post('api/v1/medicos/', data)
             .success(function(data, status) {
                 $scope.medicos = data;
                 $scope.medico = {};
                 $scope.showSuccessAlert = true;
                 $scope.showErrorAlert = false;
             })
             .error(function(data, status) {
                $scope.showErrorAlert = true;
                $scope.showSuccessAlert = false;
             });
         }
})
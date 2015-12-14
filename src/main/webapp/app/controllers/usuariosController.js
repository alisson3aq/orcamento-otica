mainApp
    .controller('usuariosController', function ($scope,$http) {

        $scope.usuario = {};
        $scope.showSuccessAlert = false;
        $scope.showErrorAlert = false;

        $scope.listarUsuarios = function(){
            $http.get("api/v1/usuarios")
                .then(function (response) {
                    $scope.usuarios = response.data;
            });
        }

        $scope.listarUsuarios();

        $scope.excluir = function(login){
            $http.delete('api/v1/usuarios/' + login)
                .then(function (response) {
                    $scope.usuarios = response.data;
            });
        }

        $scope.create = function(){
            var data = {
                nome : $scope.usuario.nome,
                login : $scope.usuario.login,
                senha : $scope.usuario.senha
            };
            $http.post('api/v1/usuarios/', data)
            .success(function(data, status) {
                $scope.usuarios = data;
                $scope.usuario = {};
                $scope.showSuccessAlert = true;
                $scope.showErrorAlert = false;
            })
            .error(function(data, status) {
               $scope.showErrorAlert = true;
               $scope.showSuccessAlert = false;
            });
        }

        $scope.update = function(usuario){
        }

    })
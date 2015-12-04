mainApp
    .controller('usuariosController', function ($scope,$http) {

        $http.get("api/v1/usuarios")
            .then(function (response) {
                $scope.usuarios = response.data;
        });

    })
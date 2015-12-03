mainApp
    .controller('usuariosCrtl', function ($scope,$http) {

        $http.get("http://www.w3schools.com/angular/customers.php")
            .then(function (response) {
                $scope.usuarios = response.data;
            });

    })
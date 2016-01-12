(function() {
    mainApp.controller('loginController', loginController);

    loginController.$inject = ['$scope', 'securityService', '$http', '$location'];

    function loginController($scope, securityService, $http, $location) {
        $scope.user = {};
        securityService.logout();
        $scope.entrar = function() {
            if ($scope.user) {
                if (($scope.user.login === undefined || $scope.user.login === '') || ($scope.user.password === undefined || $scope.user.password === '')) {
                    alert("Os campos usuário e senha devem ser preenchidos!")
                    return;
                }

                var usuario = { nome : "", login : $scope.user.login, senha : $scope.user.password };
                usuario.at = "xyz";

                securityService.authenticate(JSON.stringify(usuario));
                $location.path('/orcamentos');
//                $http.post("api/v1/", usuario).success(function(data) {
//                    if (data) {
//                        usuario.at = "xyz";
//                        securityService.authenticate(usuario);
//                    } else {
//                        alert("erro else");
//                    }
//                }).error(function() {
//                    alert("erro callback");
//                });
            }
        }
    }
})();
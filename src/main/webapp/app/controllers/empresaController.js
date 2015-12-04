mainApp
.controller('empresaController', function($scope,$http) {
        $http.get("api/v1/empresas")
            .then(function (response) {
                /*{
                   "empresa":"Ótica ver bem - ltda",
                   "cnpj":"145826-856",
                   "endereco":"Rua dos alecrins 258",
                   "bairro":"Nova Veneza",
                   "cidade":"São Paulo",
                   "estado":"Paraná",
                   "cep":"130452-854",
                   "telefone":"(21) 32568-9856",
                   "email":"contato@empresa.com.br"
                }*/
                $scope.empresas = response.data;
        });
})
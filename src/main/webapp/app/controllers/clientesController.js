mainApp
.controller('clientesController', function($scope,$http) {
         $http.get("api/v1/clientes")
                    .then(function (response) {
/*                    [
                       {
                          "nome":"Reginaldo Gomes",
                          "cpf":"785002238-96",
                          "endereco":"Rua Gomes da Costa 885",
                          "bairro":"Parque Imperador",
                          "cidade":"Campinas",
                          "estado":"Washington",
                          "cep":"13529-965",
                          "telefone":"(19)32856521",
                          "email":"reginaldo@gmail.com"
                       },
                       {
                          "nome":"Mano Menezes",
                          "cpf":"7434343-963",
                          "endereco":"Rua Carlos Gomes 1885",
                          "bairro":"Jardim Meneghel",
                          "cidade":"São Sebastião",
                          "estado":"New York",
                          "cep":"43567-965",
                          "telefone":"(19)4534344",
                          "email":"mano@gmail.com"
                       }
                    ]*/
                        $scope.clientes = response.data;
         });
})
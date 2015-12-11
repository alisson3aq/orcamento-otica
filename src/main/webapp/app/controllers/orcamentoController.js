mainApp
.controller('orcamentoController', function($scope,$http) {

    $http.get("api/v1/orcamentos")
        .then(function (response) {
            $scope.orcamentos = response.data;
    });

    $scope.exportToPDF = function(){
        window.open("reportServlet", "_blank");
    }

    $scope.items = [];
    $scope.item = {};
    $scope.item.codigo = "093841";
    $scope.item.descricao = "Lente de contatos";
    $scope.item.quantidade = 2;
    $scope.item.unidade = "un";
    $scope.item.valorUnitario = 19.90;
    $scope.items.push($scope.item);

    $scope.plus = function(){
        $scope.items[0].quantidade = $scope.items[0].quantidade + 1;
    }

    $scope.minus = function(){
        $scope.items[0].quantidade = $scope.items[0].quantidade - 1;
    }

//referente ao modal de produtos
    $scope.produtos = [];
    $scope.listarProdutos = function(){
       $http.get("api/v1/produtos")
           .then(function (response) {
               $scope.produtos = response.data;
       });
    }
    $scope.listarProdutos();

    $scope.addProduto = function(){

    }

//referente ao modal
    $scope.listarServicos = function(){
        $http.get("api/v1/servicos")
            .then(function (response) {
                $scope.servicos = response.data;
        });
    }
    $scope.listarServicos();

})
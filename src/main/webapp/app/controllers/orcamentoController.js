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

    $scope.plus = function(index){
        $scope.items[index].quantidade = $scope.items[index].quantidade + 1;
    }

    $scope.minus = function(index){
        $scope.items[index].quantidade = $scope.items[index].quantidade - 1;
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
       $scope.item1 = {};
       $scope.item1.codigo = "093841";
       $scope.item1.descricao = "Lente de contatos";
       $scope.item1.quantidade = 2;
       $scope.item1.unidade = "un";
       $scope.item1.valorUnitario = 19.90;
       $scope.items.push($scope.item1);
       $('#produtoCadastroModal').modal('hide');
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
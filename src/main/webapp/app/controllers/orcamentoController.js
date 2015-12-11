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
    $scope.select = {};
/*    $scope.item = {};
    $scope.item.codigo = "093841";
    $scope.item.descricao = "Lente de contatos";
    $scope.item.quantidade = 2;
    $scope.item.unidade = "un";
    $scope.item.valorUnitario = 19.90;
    $scope.items.push($scope.item);*/

    $scope.plus = function(index){
        $scope.items[index].quantidade = $scope.items[index].quantidade + 1;
    }

    $scope.minus = function(index){
        $scope.items[index].quantidade = $scope.items[index].quantidade - 1;
    }


    $scope.produtos = [];
    $scope.listarProdutos = function(){
       $http.get("api/v1/produtos")
           .then(function (response) {
               $scope.produtos = response.data;
       });
    }
    $scope.listarProdutos();

    $scope.addProduto = function(){
        if(angular.isUndefined($scope.select.produto) || $scope.select.produto == ""){
            return;
        }
        var produto = JSON.parse($scope.select.produto);
        //Se o item já está no orçamento, então incrementa a quantidade.
        for(var i in $scope.items){
            if($scope.items[i].codigo === produto.codigo){
                $scope.items[i].quantidade = $scope.items[i].quantidade + 1;
                return;
            }
        }
        produto.quantidade = 1;
        $scope.items.push(produto);
    }

    $scope.listarServicos = function(){
        $http.get("api/v1/servicos")
            .then(function (response) {
                $scope.servicos = response.data;
        });
    }
    $scope.listarServicos();

    $scope.addServico = function(){
        $scope.select.servico.quantidade = 1;
        $scope.items.push(JSON.parse($scope.select.servico));
    }
})
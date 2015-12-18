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

    $scope.plus = function(index){
        $scope.items[index].quantidade = $scope.items[index].quantidade + 1;
    }

    $scope.minus = function(index){
        $scope.items[index].quantidade = $scope.items[index].quantidade - 1;
        if($scope.items[index].quantidade == 0){
            $scope.items.splice(index, 1);
        }
    }

    $scope.clientes = [];
    $scope.listarClientes = function(){
       $http.get("api/v1/clientes")
           .then(function (response) {
               $scope.clientes = response.data;
       });
    }
    $scope.listarClientes();


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
        if(angular.isUndefined($scope.select.servico) || $scope.select.servico == ""){
            return;
        }
        var servico = JSON.parse($scope.select.servico);
        //Se o item já está no orçamento, então incrementa a quantidade.
        for(var i in $scope.items){
            if($scope.items[i].codigo === servico.codigo){
                $scope.items[i].quantidade = $scope.items[i].quantidade + 1;
                return;
            }
        }
        servico.quantidade = 1;
        $scope.items.push(servico);
    }

    $scope.$watch('items', function() {
       $scope.totalGeral = 0.00;
       for(var i in $scope.items){
               console.log("i: " + i);
             $scope.totalGeral =  $scope.totalGeral + ($scope.items[i].valorUnitario * $scope.items[i].quantidade);
       }
        },function() {}
    );
    //Código para o Datepicker
    $scope.minDate = new Date();
    $scope.maxDate = new Date(2020, 5, 22);
    $scope.dt = new Date();
    $scope.dt_orc = new Date();

    $scope.status = {
      opened: false
    };

    $scope.status_orc = {
       opened: false
    };

    $scope.open = function($event) {
      $scope.status.opened = true;
    };

    $scope.open_orc_dt = function($event) {
      $scope.status_orc.opened = true;
    };
    //Fim código Datapicker
})
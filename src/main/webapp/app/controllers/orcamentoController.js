mainApp
.controller('orcamentoController', function($scope,$http) {

    $scope.orcamento = {};
    $scope.items = [];
    $scope.clientes = [];
    $scope.select = {};
    $scope.produtos = [];
    $scope.servicos = [];
    $scope.totalGeral = 0.00;
    $scope.empresa;

    $scope.novoOrcamento = function(){
        $scope.orcamento = {};
        $scope.items = [];
        $scope.select = {};
        $scope.totalGeral = 0.00;
        $scope.dt = new Date();
        $scope.dt_orc = new Date();
        $scope.clearAlertFlags();
        $scope.disabilitarEdicao = false;
    }

    $scope.clearAlertFlags = function(){
        $scope.showFrontErrorAlert = false;
        $scope.showSuccessAlert = false;
        $scope.showErrorAlert = false;
    }


    $scope.detalhes = function(orc){
        $scope.orcamento = orc;
        $scope.orcamento.cliente = JSON.stringify(orc.cliente);
        $scope.items = orc.items;
        $scope.disabilitarEdicao = true;
        $scope.op = 'cadastrar';
    }

    $scope.refreshOrcList = function(){
    $http.get("api/v1/orcamentos")
        .then(function (response) {
            $scope.orcamentos = response.data;
    });
    }
    $scope.refreshOrcList();

    $http.get("api/v1/empresas/mockId")
        .then(function (response) {
            $scope.empresa = response.data;
    });

     $scope.excluir = function(codigo){
         $scope.novoOrcamento();
         $http.delete('api/v1/orcamentos/' + codigo)
             .then(function (response) {
                 $scope.orcamentos = response.data;
         });
     }




    var validacaoFront = function(){
        $scope.showFrontErrorAlert = false;
         if(angular.isUndefined($scope.orcamento.vendedor)){
            $scope.showFrontErrorAlert = true;
            $scope.frontErrorMessage = "Vendedor inválido!";
        }else if(angular.isUndefined($scope.orcamento.validade)){
            $scope.showFrontErrorAlert = true;
            $scope.frontErrorMessage = "Validade inválida!";
        }else if(angular.isUndefined($scope.orcamento.dataentrega)){
            $scope.showFrontErrorAlert = true;
            $scope.frontErrorMessage = "Data da entrega inválida!";
        }else if(angular.isUndefined($scope.orcamento.dataorcamento)){
            $scope.showFrontErrorAlert = true;
            $scope.frontErrorMessage = "Data do orcamento inválida!";
        }else if(angular.isUndefined($scope.orcamento.cliente)){
            $scope.showFrontErrorAlert = true;
            $scope.frontErrorMessage = "Cliente inváildo!";
        }else if(angular.isUndefined($scope.items)){
            $scope.showFrontErrorAlert = true;
            $scope.frontErrorMessage = "Items inválidos!";
        }else if(angular.isUndefined($scope.empresa)){
            $scope.showFrontErrorAlert = true;
            $scope.frontErrorMessage = "Os dados da empresa devem ser definidos antes de gerar um relatório. Acesse o menu empresa e preencha os dados.";
        }
        return !$scope.showFrontErrorAlert;
    }

    var getOrcamento = function(){
        return {
                codigo : $scope.orcamento.codigo,
                vendedor : $scope.orcamento.vendedor,
                validade : $scope.orcamento.validade,
                dataentrega : $scope.orcamento.dataentrega,
                dataorcamento : $scope.orcamento.dataorcamento,
                empresa : $scope.empresa,
                cliente : JSON.parse($scope.orcamento.cliente),
                items : $scope.items
            };
    }

    $scope.create = function(){
        if(validacaoFront() == false){
            return;
        }

        var data = getOrcamento();

        $http.post('api/v1/orcamentos/', data)
        .success(function(data, status) {
                $scope.orcamento.codigo = data.codigo;
                $scope.showSuccessAlert = true;
                $scope.showErrorAlert = false;
        })
        .error(function(data, status) {
                $scope.showSuccessAlert = false;
                $scope.showErrorAlert = true;
        });
    }

    var exportPDFSubmit = function(codigo){
        var mapForm = document.createElement("form");
        mapForm.target = "Map";
        mapForm.method = "POST"; // or "post" if appropriate
        mapForm.action = "reportServlet";
        var mapInput = document.createElement("input");
        mapInput.type = "hidden";
        mapInput.name = "codigo";
        mapInput.value = codigo;
        mapForm.appendChild(mapInput);
        document.body.appendChild(mapForm);
        mapForm.submit();
    }


    $scope.exportToPDF = function(){
        if(validacaoFront() == false){
            return;
        }

        var data = getOrcamento();

        if(angular.isUndefined(data.codigo)){
            $http.post('api/v1/orcamentos', data)
            .success(function(response) {
                    exportPDFSubmit(response.codigo);
                    $scope.orcamento.codigo = response.codigo;
                    $scope.showSuccessAlert = true;
                    $scope.showErrorAlert = false;
            })
            .error(function(data, status) {
                    $scope.showSuccessAlert = false;
                    $scope.showErrorAlert = true;
            });
        }else{
            exportPDFSubmit(data.codigo);
        }
    }



    $scope.plus = function(index){
        $scope.items[index].quantidade = $scope.items[index].quantidade + 1;
    }

    $scope.minus = function(index){
        $scope.items[index].quantidade = $scope.items[index].quantidade - 1;
        if($scope.items[index].quantidade == 0){
            $scope.items.splice(index, 1);
        }
    }

    $scope.listarClientes = function(){
       $http.get("api/v1/clientes")
           .then(function (response) {
               $scope.clientes = response.data;
       });
    }
    $scope.listarClientes();


    $scope.listarProdutos = function(){
       $http.get("api/v1/produtos")
           .then(function (response) {
               $scope.produtos = response.data;
       });
    }
    $scope.listarProdutos();

    $scope.addProduto = function(){
        if(angular.isUndefined($scope.orcamento.produto) || $scope.orcamento.produto == ""){
            return;
        }
        var produto = JSON.parse($scope.orcamento.produto);
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
        if(angular.isUndefined($scope.orcamento.servico) || $scope.orcamento.servico == ""){
            return;
        }
        var servico = JSON.parse($scope.orcamento.servico);
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
             $scope.totalGeral =  $scope.totalGeral + ($scope.items[i].valorUnitario * $scope.items[i].quantidade);
       }
        },function() {}
    );

    $scope.formatNumberSize = function(a){
        return(1e5+a+"").slice(-5);
    }

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
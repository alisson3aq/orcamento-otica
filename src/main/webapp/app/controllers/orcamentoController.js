mainApp
.controller('orcamentoController', function($scope,$http) {

    $http.get("api/v1/orcamentos")
        .then(function (response) {
            $scope.orcamentos = response.data;
    });

    $scope.exportToPDF = function(){
        window.open("reportServlet", "_blank");
    }
})
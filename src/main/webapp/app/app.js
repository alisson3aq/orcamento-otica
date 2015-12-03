var mainApp = angular.module("mainApp", [ 'ngRoute' ]);

mainApp
.controller('orcamentoCrtl', function($scope) {
    $scope.printDiv = function(divName) {
          var printContents = document.getElementById(divName).innerHTML;
          var popupWin = window.open('', '_blank');
          popupWin.document.open()
          popupWin.document.write('<html><head><link rel="stylesheet" type="text/css" href="style.css" /></head><body onload="window.print()">' + printContents + '</html>');
          popupWin.document.close();
        }

    $scope.exportToPDF = function(){
        window.open("/reportServlet", "_blank");
    }
})
.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/clientes', {
		templateUrl : 'views/clientes.html',
		controller : 'orcamentoCrtl'
	}).when('/medicos', {
		templateUrl : 'views/medicos.html',
		controller : 'orcamentoCrtl'
	}).when('/orcamentos', {
		templateUrl : 'views/orcamentos.html',
		controller : 'orcamentoCrtl'
	}).when('/produtos', {
		templateUrl : 'views/produtos.html',
		controller : 'orcamentoCrtl'
	}).when('/servicos', {
		templateUrl : 'views/servicos.html',
		controller : 'orcamentoCrtl'
	}).when('/servicos', {
		templateUrl : 'views/servicos.html',
		controller : 'orcamentoCrtl'
	}).when('/usuarios', {
		templateUrl : 'views/usuarios.html',
		controller : 'orcamentoCrtl'
	}).when('/empresa', {
		templateUrl : 'views/empresa.html',
		controller : 'orcamentoCrtl'
	}).otherwise({
		redirectTo : '/orcamentos'
	});
} ]);

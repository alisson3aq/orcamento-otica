var mainApp = angular.module("mainApp", [ 'ngRoute' ]);

mainApp
.controller('studentController', function($scope) {
	$scope.printDiv = function(divName) {
		  var printContents = document.getElementById(divName).innerHTML;
		  var popupWin = window.open('', '_blank');
		  popupWin.document.open()
		  popupWin.document.write('<html><head><link rel="stylesheet" type="text/css" href="style.css" /></head><body onload="window.print()">' + printContents + '</html>');
		  popupWin.document.close();
		}

	$scope.exportToPDF = function(){
		window.open("http://orcamento-mgustavocoder.rhcloud.com/reportServlet", "_blank");
	}	
 
})
.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/clientes', {
		templateUrl : 'views/clientes.html',
		controller : 'studentController'
	}).when('/medicos', {
		templateUrl : 'views/medicos.html',
		controller : 'studentController'
	}).when('/orcamentos', {
		templateUrl : 'views/orcamentos.html',
		controller : 'studentController'
	}).when('/produtos', {
		templateUrl : 'views/produtos.html',
		controller : 'studentController'
	}).when('/servicos', {
		templateUrl : 'views/servicos.html',
		controller : 'studentController'
	}).when('/servicos', {
		templateUrl : 'views/servicos.html',
		controller : 'studentController'
	}).when('/usuarios', {
		templateUrl : 'views/usuarios.html',
		controller : 'studentController'
	}).when('/empresa', {
		templateUrl : 'views/empresa.html',
		controller : 'studentController'
	}).otherwise({
		redirectTo : '/orcamentos'
	});
} ]);

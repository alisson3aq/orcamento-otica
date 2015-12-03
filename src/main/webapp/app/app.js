var mainApp = angular.module("mainApp", [ 'ngRoute' ]);

mainApp
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

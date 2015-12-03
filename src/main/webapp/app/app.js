var mainApp = angular.module("mainApp", [ 'ngRoute' ]);

mainApp
.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/clientes', {
		templateUrl : 'views/clientes.html',
		controller : 'navController'
	}).when('/medicos', {
		templateUrl : 'views/medicos.html',
		controller : 'navController'
	}).when('/orcamentos', {
		templateUrl : 'views/orcamentos.html',
		controller : 'navController'
	}).when('/produtos', {
		templateUrl : 'views/produtos.html',
		controller : 'navController'
	}).when('/servicos', {
		templateUrl : 'views/servicos.html',
		controller : 'navController'
	}).when('/servicos', {
		templateUrl : 'views/servicos.html',
		controller : 'navController'
	}).when('/usuarios', {
		templateUrl : 'views/usuarios.html',
		controller : 'navController'
	}).when('/empresa', {
		templateUrl : 'views/empresa.html',
		controller : 'navController'
	}).otherwise({
		redirectTo : '/orcamentos'
	});
} ]);

var mainApp = angular.module("mainApp", [ 'ngRoute' ]);

mainApp
.config([ '$routeProvider', function($routeProvider) {
	$routeProvider
    .when('/clientes', {
		templateUrl : 'views/clientes.html',
		controller : 'clientesCrtl'
	}).when('/medicos', {
		templateUrl : 'views/medicos.html',
		controller : 'medicosCrtl'
	}).when('/orcamentos', {
		templateUrl : 'views/orcamentos.html',
		controller : 'orcamentoCrtl'
	}).when('/produtos', {
		templateUrl : 'views/produtos.html',
		controller : 'produtosCrtl'
	}).when('/servicos', {
		templateUrl : 'views/servicos.html',
		controller : 'servicosCrtl'
	}).when('/usuarios', {
		templateUrl : 'views/usuarios.html',
		controller : 'usuariosCrtl'
	}).when('/empresa', {
		templateUrl : 'views/empresa.html',
		controller : 'empresaCrtl'
	}).otherwise({
		redirectTo : '/orcamentos'
	});
} ]);

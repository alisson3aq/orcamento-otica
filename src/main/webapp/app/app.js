var mainApp = angular.module("mainApp", [ 'ngRoute','ui.bootstrap' ]);

mainApp
.config([ '$routeProvider', function($routeProvider) {
	$routeProvider
    .when('/clientes', {
		templateUrl : 'views/clientes.html',
		controller : 'clientesController'
	}).when('/medicos', {
		templateUrl : 'views/medicos.html',
		controller : 'medicosController'
	}).when('/orcamentos', {
		templateUrl : 'views/orcamentos.html',
		controller : 'orcamentoController'
	}).when('/produtos', {
		templateUrl : 'views/produtos.html',
		controller : 'produtosController'
	}).when('/servicos', {
		templateUrl : 'views/servicos.html',
		controller : 'servicosController'
	}).when('/usuarios', {
		templateUrl : 'views/usuarios.html',
		controller : 'usuariosController'
	}).when('/empresa', {
		templateUrl : 'views/empresa.html',
		controller : 'empresaController'
	}).when('/login', {
	    templateUrl : 'views/login.html',
	    controller : 'loginController'
	}).otherwise({
		redirectTo : '/orcamentos'
	});
} ]).run(['$rootScope', '$location', 'securityService', function($rootScope, $location, securityService) {
    $rootScope.location = $location;
    $rootScope.$on('$locationChangeStart', function (event, next, current) {
        var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
        var loggedIn = securityService.isAuthenticated();
        if (restrictedPage && !loggedIn) {
            $location.path('/login');
        }
    });
}]);

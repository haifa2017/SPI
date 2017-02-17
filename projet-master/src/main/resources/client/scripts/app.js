 (function() {
	'use strict';
	var app = angular.module(
			'app',
			[ 'ngRoute', 'ngAnimate', 'ui.bootstrap', 'easypiechart',
					'mgo-angular-wizard', 'textAngular', 'ui.tree',
					'ngTagsInput']).config(
			[ '$routeProvider', function($routeProvider, $urlRouterProvider) {
    $routeProvider
    
    
    .when('/', {
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl',
        controllerAs: 'LoginController'		 
      })
      .when('/formation', {
        templateUrl: 'views/formationIndex.html',
        controller: 'FormationCtrl',
        controllerAs: 'FormationController'
      })
    
     .when('/ajouterformation', {
        templateUrl: 'views/ajouterFormation.html',
        controller: 'FormationAjouterCtrl',
        controllerAs: 'FormationController'
      })
      .otherwise
      ({
    	  redirectTo: '/login'
      });
  } ]);
	
}).call(this);
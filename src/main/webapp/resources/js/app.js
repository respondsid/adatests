'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['ui.router','AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives']);

// Declare app level module which depends on filters, and services
App.config([ '$stateProvider', '$urlRouterProvider',
            function($stateProvider, $urlRouterProvider)  {
	
	$stateProvider.state('cars', {
		url:"/cars",
        templateUrl: 'cars/layout',
        controller: CarController
    });

    $stateProvider.state('trains', {
    	url:"/trains",
        templateUrl: 'trains/layout',
        controller: TrainController
    });
    
    $stateProvider.state('railwaystations', {
    	url:"/railwaystations",
        templateUrl: 'railwaystations/layout',
        controller: RailwayStationController
    });

    $stateProvider.state('url', {
    	url:"/url",
        templateUrl: 'url/layout',
        controller: UrlController
    });
    
  $stateProvider.state('addUrl', {
    	url:"/urls",
        templateUrl: 'urls/layout',
        controller: AddUrlController
    });
    $stateProvider.state('editUrl', {
    	url:"/urls/:urlCode",
        templateUrl: 'urls/layout',
        controller: EditUrlController
    });
    
    //$urlRouterProvider.otherwise({redirectTo: '/cars'});
}]);

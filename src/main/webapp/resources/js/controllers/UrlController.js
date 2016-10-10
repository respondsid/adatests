'use strict';

/**
 * UrlController
 * 
 * @constructor
 */
var UrlController = function($scope, $http,$state) {
 
    $scope.editMode = false;
    
/*
 * $scope.url.initializeParams=function(){ url.baseUrl=parseBaseUrl(this.url);
 * url.params= parseParams(this.url); };
 * 
 * function parseBaseUrl(urlParams){ if(urlParams.length!=0){ var
 * baseUrlEndIdx=urlParams.indexOf("?") if(baseUrlEndIdx > -1) return
 * urlParams.substring(0,baseUrlEndIdx) } return urlParams; }
 * 
 * function parseUrlParams(urlParams){ var params=null; if(urlParams.length!=0){
 * var baseUrlEndIdx=urlParams.indexOf("?") if(baseUrlEndIdx > -1)
 * params=parseParams(urlParams.substring(baseUrlEndIdx)); } return params; }
 * 
 * function parseParams(paramsString){ var params=null;
 * if(paramsString.length!=0){ parameters=paramsString.split('&');
 * if(parameters!=null && parameters.length>0){ params= new
 * Object[parameters.length]; for (var int = 0; int < parameters.length; int++) {
 * params[int]= new Object(); urlParam=parameters[i].split('=');
 * params[int].name=urlParam[0]; params[int].value=urlParam[1]; } } } return
 * params; }
 */
    

    $scope.fetchUrlsList = function() {
        $http.get('urls/urlslist.json').success(function(urlList){
            $scope.urls = urlList;
        });
    };

    
    $scope.addUrl = function() {
        $scope.resetError();
        $state.go('addUrl');
    };

 

    $scope.editUrl = function(url) {
        $scope.resetError();
        $state.transitionTo('editUrl',{urlCode:url.urlCode});
    };

    /*$scope.removeurl = function(id) {
        $scope.resetError();

        $http.delete('urls/removeurl/' + id).success(function() {
            $scope.fetchUrlsList();
        }).error(function() {
            $scope.setError('Could not remove url');
        });
        $scope.url.name = '';
        $scope.url.speed = '';
    };

    $scope.removeAllUrls = function() {
        $scope.resetError();

        $http.delete('urls/removeAllUrls').success(function() {
            $scope.fetchUrlsList();
        }).error(function() {
            $scope.setError('Could not remove all Urls');
        });

    };*/

   

    
    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchUrlsList();

    $scope.predicate = 'urlCode';
};
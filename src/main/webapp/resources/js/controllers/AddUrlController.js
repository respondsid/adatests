'use strict';

/**
 * UrlController
 * 
 * @constructor
 */
var AddUrlController = function($scope, $http,$state) {
    $scope.url = {};
    $scope.url.parameters =[];
    $scope.editMode = false;
    $scope.applications=['ssod','nb'];
    
    $scope.refreshParams=function(application){
        $http.get('urls/'+application+'/appCodeParameters.json').success(function(parameters) {
            $scope.url.parameters=parameters;
        }).error(function() {
            $scope.setError('Could not retrieve parameters for app code'+application);
        });
        };
    

    $scope.addNewUrl = function(url) {
        $scope.resetError();
        $http.post('urls', url).success(function() {
            $scope.url.urlCode = '';
            $scope.url.url = '';
            $scope.url.application = '';
            $scope.url.parameters = [];
            $state.go('url');
        }).error(function() {
            $scope.setError('Could not add a new url');
        });
    };


    $scope.addNewParameter = function() {
    		if(!$scope.url.parameters){
    			$scope.url.parameters='{}'
    		}
    	    $scope.url.parameters.push({
    	      paramName: '',
    	      paramValue: '',
    	      dynamic:'false'
    	    })
    	  
    };
    
    $scope.deleteParameter = function(param) {
    		  var index = $scope.url.parameters.indexOf(param);
    		  $scope.url.parameters.splice(index, 1);     
    };
    	

    
    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

};
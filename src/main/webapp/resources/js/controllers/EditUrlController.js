'use strict';

/**
 * UrlController
 * 
 * @constructor
 */
var EditUrlController = function($scope, $http,$state,$stateParams) {
	
	$scope.urlCode =$stateParams.urlCode;
    
    $scope.editMode = true;
    $scope.applications=['ssod','nb']
    

    $scope.getUrl=function(){
    $http.get('urls/'+$scope.urlCode).success(function(tempUrl) {
        $scope.url=tempUrl;
    }).error(function() {
        $scope.setError('Could not retrieve url fromserbver');
    });
    };
    
    $scope.refreshParams=function(application){
        $http.get('urls/'+application+'/appCodeParameters.json').success(function(parameters) {
            $scope.url.parameters=parameters;
        }).error(function() {
            $scope.setError('Could not retrieve parameters for app code'+application);
        });
        };
        
        
 $scope.updateUrl = function(url) {
        $scope.resetError();

        $http.put('urls', url).success(function() {
            
            $scope.url.urlCode = '';
            $scope.url.url = '';
            $scope.url.application = '';
            $scope.url.parameters = [];
            $scope.editMode = false;
            $state.go('urls');
        }).error(function() {
            $scope.setError('Could not update the url');
        });
    };


    $scope.addNewParameter = function() {
    		if(!$scope.url.parameters){
    			$scope.url.parameters=[];
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

    $scope.getUrl();
};
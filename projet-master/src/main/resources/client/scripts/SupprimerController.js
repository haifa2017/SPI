 'use strict';


angular.module('app')
	  	.controller('SupprimerCtrl', ['$scope','$http','$location','formationSvc',
	  	             function ($scope,$http,$location,formationSvc) {
	    
	  	  		$scope.supprimerFormation = function(codeFormation){
	  	  			console.log("kkkkkkkk");
	  			var clientUrl = '/formation/'+codeFormation;
	  			var request = $http({
	  				method: "DELETE",
	  				url: clientUrl,
	  				//data: $scope.formation
	  			});
	  			request.success(
	  				function(response) {
	  					//$location.path('/formation');
	  					console.log(response);
	  				}
	  			);
	  		}
  }])
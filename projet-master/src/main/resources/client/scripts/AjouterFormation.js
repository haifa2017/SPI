'use strict';


angular.module('app')
	  	.controller('FormationAjouterCtrl', ['$scope','$http','$location','formationSvc',function ($scope,$http,$location,formationSvc) {
	    
	  		$scope.formation = {
	  				codeFormation : "",
	  				nomFormation : "",
	  				diplome : "",
	  				doubleDiplome : "",
	  				nombreDAnnee : "",
	  				debutAccreditation : "",
	  				finAccreditation : ""
	  		}

	  		$scope.ajouterFormation = function(){
	  			$scope.formation["Content-Type"] = "application/json";
	  			var clientUrl = '/formation/ajouter';
	  			var request = $http({
	  				method: "POST",
	  				url: clientUrl,
	  				data: $scope.formation
	  			});
	  			request.success(
	  				function(response) {
	  					$location.path('/formation');
	  				}
	  			);
	  		}
  }])
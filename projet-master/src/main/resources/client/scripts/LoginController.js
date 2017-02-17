angular.module('app')
	  	.controller('LoginCtrl', ['$scope','$http','$location','formationSvc',function ($scope,$http,$location,formationSvc) {
	    
	  		$scope.user = {
	  				username : "",
	  				pwd : ""
	  		}

	  		$scope.authentifier = function(){
	  			$scope.user["Content-Type"] = "application/json";
	  			var clientUrl = '/login/auth';
	  			alert("in authentifierController")
	  			var request = $http({
	  				method: "POST",
	  				url: clientUrl,
	  				data: $scope.user
	  			});
	  			request.success(
	  				function(response) {
 	  					$location.path('/index.html');
	  					//console.log(response);
	  				}
	  			);
	  		}

	  	 }]);
 
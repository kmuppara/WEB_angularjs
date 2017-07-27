/**
 * 
 */


         var myApp = angular
         				.module("myApp", [])
         				.controller("HelloController", function($scope, $http, $log) {
				            $scope.helloTo = {};
				            $scope.helloTo.title = "AngularJS"; 
				            $scope.onSubmit = function(name) {
				            	console.log(name);
				                $scope.yourName="sucess";
				                $http.get("http://localhost:8086/getRobot")
					            	.then(function(response){
					            		console.log(response.data);
					            	$log.info(response.data);
				            		$scope.helloTo.name = response.data.name;
				           	 });
				            };
				            
				            
				            });

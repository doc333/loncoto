/**
 * 
 */
var model = {
		items: []
};
var cmsApp = angular.module("cmsApp", []);

cmsApp.run(function($http) {
	$http.get("rest/contents").success(function (data) {
		model.items = data;
	});
});

cmsApp.controller("cmsCtrl", function ($scope) {
	$scope.contents = model;
});


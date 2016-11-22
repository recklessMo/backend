(function () {
    'use strict';

    angular
        .module('custom')
        .service('CoverService', CoverService);

    CoverService.$inject = ['$http'];
    function CoverService($http) {

        this.publish = function(obj) {
            return $http({
                method: "POST",
                url : "/v1/cover/publish",
                data:obj,
                timeout: 5000
            });
        }

    }
})
();

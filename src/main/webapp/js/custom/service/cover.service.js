(function () {
    'use strict';

    angular
        .module('custom')
        .service('CoverService', CoverService);

    CoverService.$inject = ['$http'];
    function CoverService($http) {

        this.publishCover = function (obj) {
            return $http({
                method: "POST",
                url: "/v1/cover/publish/index",
                data: obj,
                timeout: 5000
            });
        }

        this.publishAbout = function (obj) {
            return $http({
                method: "POST",
                url: "/v1/cover/publish/about",
                data: obj,
                timeout: 5000
            });
        }

        this.publishMovieList = function(obj){
            return $http({
                method: "POST",
                url: "/v1/cover/publish/movieList",
                data: obj,
                timeout: 5000
            });
        }

    }
})
();

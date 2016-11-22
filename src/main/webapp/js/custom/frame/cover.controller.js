(function () {
    'use strict';
    angular
        .module('custom')
        .controller('CoverController', CoverController);
    CoverController.$inject = ['$scope', 'CoverService', 'SweetAlert', 'NgTableParams', 'ngDialog', 'blockUI', 'Notify'];

    function CoverController($scope, CoverService, SweetAlert, NgTableParams, ngDialog, blockUI, Notify) {

        $scope.obj = {};

        //发布
        $scope.publish = function(data){
            CoverService.publish(data).success(function(data){
                if(data.status == 200){
                    SweetAlert.success("发布成功!");
                }
            }).error(function(){
                SweetAlert.error("网络异常, 请稍后重试!");
            });
        }

    }
})();
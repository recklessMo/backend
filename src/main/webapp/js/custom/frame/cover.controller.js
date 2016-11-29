(function () {
    'use strict';
    angular
        .module('custom')
        .controller('CoverController', CoverController);
    CoverController.$inject = ['$scope', 'CoverService', 'SweetAlert', 'NgTableParams', 'ngDialog', 'blockUI', 'Notify'];

    function CoverController($scope, CoverService, SweetAlert, NgTableParams, ngDialog, blockUI, Notify) {

        //当前使用的数据
        $scope.obj = JSON.parse($scope.ngDialogData.item.content);
        $scope.obj.id = $scope.ngDialogData.item.id;

        //发布
        $scope.publish = function () {
            //判断是否都填写完整了
            if(angular.isUndefined($scope.obj.firstHeadImg)
                || angular.isUndefined($scope.obj.firstHeadHref)
                || angular.isUndefined($scope.obj.secondHeadImg)
                || angular.isUndefined($scope.obj.secondHeadHref)
                || angular.isUndefined($scope.obj.thirdHeadImg)
                || angular.isUndefined($scope.obj.thirdHeadHref)
                || angular.isUndefined($scope.obj.leftImg)
                || angular.isUndefined($scope.obj.leftHref)
                || angular.isUndefined($scope.obj.leftText)
                || angular.isUndefined($scope.obj.rightMiddleImg)
                || angular.isUndefined($scope.obj.rightMiddleHref)
                || angular.isUndefined($scope.obj.rightMiddleText)
                || angular.isUndefined($scope.obj.rightBottomImg)
                || angular.isUndefined($scope.obj.rightBottomHref)
                || angular.isUndefined($scope.obj.rightBottomText)
            ){
                SweetAlert.error("请填写完毕所有字段!");
                return ;
            }

            var data = $scope.obj;
            CoverService.publishCover(data).success(function (data) {
                if (data.status == 200) {
                    SweetAlert.success("发布成功!");
                    $scope.closeThisDialog();
                }
            }).error(function () {
                SweetAlert.error("网络异常, 请稍后重试!");
            });
        }


        //打开搜索图片的窗口
        $scope.searchImg = function (type) {
            var dialog= ngDialog.open({
                template: 'app/views/custom/admin/img/img-list.html',
                className: 'ngdialog-theme-default max-dialog',
                controller: 'ImageListController',
                data: {inDialog: true}
            });
            dialog.closePromise.then(function(data){
                if(!data.value.status){
                    return;
                }
                //不同的type对应不同位置的img
                var url = data.value.url;
                if(type === 1){
                    $scope.obj.firstHeadImg = url;
                }else if(type === 2){
                    $scope.obj.secondHeadImg = url;
                }else if(type === 3){
                    $scope.obj.thirdHeadImg = url;
                }else if(type == 4){
                    $scope.obj.leftImg = url;
                }else if(type == 5){
                    $scope.obj.rightMiddleImg = url;
                }else if(type == 6){
                    $scope.obj.rightBottomImg = url;
                }
            });
        }


        //打开搜索跳转页面的窗口
        $scope.searchPage = function (type) {
            var dialog= ngDialog.open({
                template: 'app/views/custom/frame/frame-list.html',
                className: 'ngdialog-theme-default max-dialog',
                controller: 'FrameListController',
                data: {inDialog: true}
            });
            dialog.closePromise.then(function(data){
                if(!data.value.status){
                    return;
                }
                //不同的type对应不同位置的img
                var url = data.value.url;
                if(type === 1){
                    $scope.obj.firstHeadHref = url;
                }else if(type === 2){
                    $scope.obj.secondHeadHref = url;
                }else if(type === 3){
                    $scope.obj.thirdHeadHref = url;
                }else if(type == 4){
                    $scope.obj.leftHref = url;
                }else if(type == 5){
                    $scope.obj.rightMiddleHref = url;
                }else if(type == 6){
                    $scope.obj.rightBottomHref = url;
                }
            });
        }

    }
})();
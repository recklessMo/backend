(function () {
    'use strict';
    angular
        .module('custom')
        .controller('EditYearController', EditYearController);
    EditYearController.$inject = ['$scope', 'SettingService', 'SweetAlert', 'blockUI'];

    function EditYearController($scope, SettingService, SweetAlert, blockUI) {

        var block = blockUI.instances.get("edit-year");

        $scope.year = _.clone($scope.ngDialogData.year);
        $scope.type = $scope.ngDialogData.type;

        activate();


        function activate(){
        }

        $scope.loading = false;

        $scope.save = function(year){

            if(!validate(year)){
                return;
            }

            $scope.loading = true;
            block.start();
            if($scope.type == 'add') {
                SettingService.addYear(year).success(function (data) {
                    $scope.loading = false;
                    block.stop();
                    if (data.status == 200) {
                        SweetAlert.success("添加成功!");
                        $scope.closeThisDialog('reload');
                    } else {
                        //更新失败的情况
                        SweetAlert.error("服务器异常,请稍后重试");
                    }
                }).error(function () {
                    SweetAlert.error("网络问题,稍后重试!");
                    $scope.loading = false;
                    $scope.closeThisDialog('reload');
                    block.stop();
                });
            }else if($scope.type == 'edit'){
                SettingService.updateYear(year).success(function (data) {
                    $scope.loading = false;
                    block.stop();
                    if (data.status == 200) {
                        SweetAlert.success("修改成功!");
                        $scope.closeThisDialog('reload');
                    } else {
                        //更新失败的情况
                        SweetAlert.error("服务器异常,请稍后重试");
                    }
                }).error(function () {
                    SweetAlert.error("网络问题,稍后重试!");
                    $scope.loading = false;
                    block.stop();
                });
            }
        }

        function validate(year){
            return true;
        }

    }
})();
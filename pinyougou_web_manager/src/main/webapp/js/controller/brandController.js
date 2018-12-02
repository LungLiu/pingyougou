//创建控制器
app.controller("brandController", function ($scope,$controller,brandService) {

    $controller("baseController",{$scope:$scope});

    //查询品牌列表
    $scope.findAll = function () {
        brandService.findAll().success(function (data) {
            $scope.list = data;
        });
    }

    //获取当前页所有品牌列表
    $scope.findPage = function (page, size) {
        brandService.findPage(page,size).success(
            function (data) {
                $scope.list = data.rows; //显示当前页数值
                $scope.paginationConf.totalItems = data.total; //更新总记录数
            }
        );
    }

    //保存品牌（添加保存、修改保存）
    $scope.save = function () {
        var object = null;
        //当保存方法含有id说明是修改方法，没有id是添加方法
        if ($scope.brand.id != null) {
            object = brandService.update($scope.brand);//修改
        }else{
            object = brandService.add($scope.brand);//添加
        }
        object.success(function (data) {
            if (data.success) {
                $scope.reloadList();//刷新
            } else {
                alert(data.message);
            }
        });
    }

    //查询实体
    $scope.findOne = function (id) {
        brandService.findOne(id).success(function (data) {
            $scope.brand = data;
        });
    }

    //删除
    $scope.del = function () {
        brandService.del($scope.selectIds).success(function (data) {
            if (data.success) {
                $scope.reloadList();//刷新
            } else {
                alert(data.message);
            }
        });
    }

    //条件查询
    $scope.searchBrand = {};//定义一个空值
    $scope.search = function (page,size) {
        brandService.search(page,size,$scope.searchBrand).success(function (data) {
            $scope.list = data.rows; //显示当前页数值
            $scope.paginationConf.totalItems = data.total; //更新总记录数
        });
    }
});
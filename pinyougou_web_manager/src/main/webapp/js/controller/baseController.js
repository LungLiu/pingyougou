app.controller("baseController", function ($scope) {

    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,      //currentPage：当前页
        totalItems: 10,      //totalItems：总记录数
        itemsPerPage: 5,    //itemsPerPage：每页记录数
        perPageOptions: [5, 10, 20, 30, 40, 50],    //perPageOptions：分页选项
        // onChange：分页码变更后自动触发的方法
        onChange: function () {
            $scope.reloadList();
        }
    };

    //刷新列表
    $scope.reloadList = function () {
        $scope.selectIds = [];//列表改变，清空复选框
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }

    //用户勾选复选框
    $scope.selectIds = [];//用户勾选的id集合
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {
            $scope.selectIds.push(id);//push向集合添加元素
        } else {
            var index = $scope.selectIds.indexOf(id);//查找id在集合中所在的位置
            $scope.selectIds.splice(index, 1);//参数1：移除的数据；参数2：移除的个数。
        }
    }

    $scope.jsonToString = function (jsonString, key) {
        var json = JSON.parse(jsonString);
        var value = "";
        for (var i = 0; i < json.length; i++) {
            if (i > 0) {
                value += ",";
            }
            value += json[i][key];
        }
        return value;
    }

    //在list集合中根据某key的值查询对象
    $scope.searchObjectByKey = function (list, key, keyValue) {

        for (var i = 0; i < list.length; i++) {
            if (list[i][key] == keyValue) {
                return list[i];
            }
        }
        return null;
    }
});
app.controller("searchController", function ($scope, $location, searchService) {

    //定义搜索对象的结构 category:商品分类
    $scope.searchMap = {
        "keywords": "",
        "category": "",
        "brand": "",
        "spec": {},
        "price": "",
        "pageNo": 1,
        "pageSize": 40,
        "sort": "",
        "sortField": ""
    }

    //搜索
    $scope.search = function () {
        $scope.searchMap.pageNo = parseInt($scope.searchMap.pageNo);//转换为数字
        searchService.search($scope.searchMap).success(function (response) {
            $scope.resultMap = response;//搜索返回的结果
            //构建分页栏
            buildPageLable();
        });
    }

    //构建分页标签(totalPages为总页数)
    buildPageLable = function () {
        $scope.pageLable = [];//新增分页栏属性
        var firstPage = 1;//起始页
        var lastPage = $scope.resultMap.totalPages;//截至页

        //判断当前页位置
        if (lastPage > 5) {//如果总页码数大于5
            if ($scope.searchMap.pageNo <= 3) {//如果当前页码数小于等于3，显示前五页
                lastPage = 5;
            } else if ($scope.searchMap.pageNo >= lastPage - 2) {//如果当前页大于等于总页数-2，显示最后五页
                firstPage = lastPage - 4;//首页=总页数-4
            } else {//如果当前页不是前后三页，则正常显示
                firstPage = $scope.searchMap.pageNo - 2;
                lastPage = $scope.searchMap.pageNo + 2;
            }
        }

        //显示信息
        for (var i = firstPage; i <= lastPage; i++) {
            $scope.pageLable.push(i);
        }
    }

    //添加搜索项  改变searchMap的值
    $scope.addSearchItem = function (key, value) {
        if (key == "category" || key == "brand" || key == "price") { //如果用户点击的是分类或品牌、价格
            $scope.searchMap[key] = value;
        } else { //否则点击的是品规格
            $scope.searchMap.spec[key] = value;
        }
        $scope.search();//查询
    }

    //撤销搜索项
    $scope.removeSearchItem = function (key) {
        if (key == "category" || key == "brand" || key == "price") { //如果用户点击的是分类或品牌、价格
            $scope.searchMap[key] = "";
        } else { //否则点击的是规格
            delete $scope.searchMap.spec[key];//移除此属性
        }
        $scope.search();//查询
    }

    //分页查询
    $scope.queryByPage = function (pageNo) {
        if (pageNo < 1 || pageNo > $scope.resultMap.totalPages) {
            return;
        }
        $scope.searchMap.pageNo = pageNo;
        $scope.search();//查询
    }

    //排序查询
    $scope.sortSearch = function (sortField, sort) {
        $scope.searchMap.sortField = sortField;
        $scope.searchMap.sort = sort;

        $scope.search();//查询
    }

    //判断关键字是否是品牌
    $scope.keywordsIsBrand = function () {
        for (var i = 0; i < $scope.resultMap.brandList.length; i++) {
            if ($scope.searchMap.keywords.indexOf($scope.resultMap.brandList[i].text) >= 0) { //如果包含
                return true;
            }
        }
        return false;
    }

    //获取搜索参数，加载关键字
    $scope.loadKeywords = function () {
        $scope.searchMap.keywords = $location.search()['keywords'];
        $scope.search();//查询
    }
});
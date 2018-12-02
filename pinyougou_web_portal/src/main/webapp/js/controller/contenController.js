app.controller("contenCroller",function ($scope, contentService) {

    $scope.contentList = [];//定义广告列表

    $scope.findByCategoryId = function (categoryId) {
        contentService.findByCategoryId(categoryId).success(function (data) {
            $scope.contentList[categoryId] = data;
        });
    }

    //搜索（传递参数）
    $scope.search = function () {
        location.href = "http://localhost:9104/search.html#?keywords=" + $scope.keywords;
    }
});
//控制层
app.controller('goodsController', function ($scope, $controller, goodsService, itemCatService, typeTemplateService) {

    $controller('baseController', {$scope: $scope});//继承

    //读取列表数据绑定到表单中
    $scope.findAll = function () {
        goodsService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    }

    //分页
    $scope.findPage = function (page, rows) {
        goodsService.findPage(page, rows).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }

    //查询实体
    $scope.findOne = function (id) {

        if (id == null) {
            return;
        }
        goodsService.findOne(id).success(function (response) {
            $scope.entity = response;

            //向富文本编辑器添加商品介绍
            editor.html($scope.entity.goodsDesc.introduction);
            //添加商品图片
            $scope.entity.goodsDesc.itemImages = JSON.parse($scope.entity.goodsDesc.itemImages);
            //扩展属性
            $scope.entity.goodsDesc.customAttributeItems = JSON.parse($scope.entity.goodsDesc.customAttributeItems);
            //规格选项
            $scope.entity.goodsDesc.specificationItems = JSON.parse($scope.entity.goodsDesc.specificationItems);
            //转换SKU列表中的规格对象
            for (var i = 0; i < $scope.entity.itemList.length; i++) {
                $scope.entity.itemList[i].spec = JSON.parse($scope.entity.itemList[i].spec);
            }
        });
    }

    //判断规格与规格选项是否应该被勾选
    $scope.checkAttributeValue = function (specName, optionName) {
        var object = $scope.searchObjectByKey($scope.entity.goodsDesc.specificationItems, "attributeName", specName);
        if (object != null) {
            //如果能够查询到规格选项，进行勾选
            if (object.attributeValue.indexOf(optionName) >= 0) {
                // $scope.createItemList();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    //批量删除
    $scope.dele = function () {
        //获取选中的复选框
        goodsService.dele($scope.selectIds).success(function (response) {
                if (response.success) {
                    alert(response.message);
                    $scope.reloadList();//刷新列表
                } else {
                    alert(response.message);
                }
            }
        );
    }

    $scope.searchEntity = {};//定义搜索对象

    //搜索
    $scope.search = function (page, rows) {
        goodsService.search(page, rows, $scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }

    $scope.typeTemplate = {};//定义类型模板初始值
    //查询一级商品分类列表
    $scope.selectItemCat1List = function () {
        itemCatService.findByParentId(0).success(function (response) {
            $scope.itemCat1List = response;
        });
    }

    //查询二级商品分类列表
    $scope.$watch("entity.goods.category1Id", function (newValue, oldValue) {
        itemCatService.findByParentId(newValue).success(function (response) {
            $scope.itemCat2List = response;
        });
    });

    //查询三级商品分类列表
    $scope.$watch("entity.goods.category2Id", function (newValue, oldValue) {
        itemCatService.findByParentId(newValue).success(function (response) {
            $scope.itemCat3List = response;
        });
    });

    //读取模板ID
    $scope.$watch("entity.goods.category3Id", function (newValue, oldValue) {
        itemCatService.findOne(newValue).success(function (response) {
            $scope.entity.goods.typeTemplateId = response.typeId;
        });
    });

    //读取模板ID后，读取品牌列表、扩展属性、规格列表
    $scope.$watch("entity.goods.typeTemplateId", function (newValue, oldValue) {
        typeTemplateService.findOne(newValue).success(function (response) {
            $scope.typeTemplate = response;//模板对象
            $scope.typeTemplate.brandIds = JSON.parse($scope.typeTemplate.brandIds);//品牌列表类型转换
        });
        //读取规格
        /*typeTemplateService.findSpecList(newValue).success(function (response) {
            $scope.specList = response;
        })*/
    });

    $scope.status = ["未审核", "已审核", "审核未通过", ""];//定义商品状态
    $scope.itemCatList = [];//初始化商品分类列表
    //查询商品分类列表
    $scope.findItemCatList = function () {
        itemCatService.findAll().success(function (response) {
            for (var i = 0; i < response.length; i++) {
                $scope.itemCatList[response[i].id] = response[i].name;
            }
        });
    }

    //更改状态(批量)
    $scope.updateStatus = function (status) {
        goodsService.updateStatus($scope.selectIds, status).success(function (response) {
            if (response.success) {
                alert(response.message);
                $scope.reloadList();//重新加载
            } else {
                alert(response.message);
            }
        });
    }
    //更改状态(浏览商品信息更改)
    $scope.updateAuditStatus = function (ids, status) {
        goodsService.updateStatus(ids, status).success(function (response) {
            if (response.success) {
                alert(response.message);
                $scope.reloadList();//重新加载
            } else {
                alert(response.message);
            }
        });
    }
});

//品牌服务
app.service("brandService",function ($http) {

    //查询所有
    this.findAll = function () {
        return $http.get("../brand/findAll.do");
    }
    //分页查询
    this.findPage = function (page,size) {
        return $http.get("../brand/findPage.do?page=" + page + "&size=" + size);
    }
    //添加
    this.add = function (brand) {
        return $http.post("../brand/add.do", brand)
    }
    //修改
    this.update = function (brand) {
        return $http.post("../brand/update.do", brand)
    }
    //根据id查询实体
    this.findOne = function (id) {
        return $http.get("../brand/findOne.do?id=" + id);
    }
    //删除
    this.del = function (ids) {
        return $http.get("../brand/delete.do?ids="+ids);
    }
    //条件查询
    this.search = function (page,size,searchBrand) {
        return $http.post("../brand/search.do?page=" + page + "&size=" + size,searchBrand);
    }
    //下拉列表数据
    this.selectOptionList = function () {
        return $http.get("../brand/selectOptionList.do");
    }
});
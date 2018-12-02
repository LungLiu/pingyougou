package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbBrand;

import java.util.List;
import java.util.Map;

/**
 * 品牌接口
 */
public interface BrandService {
    /**
     * 查询所有品牌
     * @return
     */
    List<TbBrand> findAll();

    /**
     * 品牌分页
     * @param pageNum  当前页数
     * @param pageSize 每页的记录数
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);

    /**
     * 品牌添加操作
     * @param brand
     */
    void add(TbBrand brand);

    /**
     * 根据id查询实体
     * @param id
     * @return
     */
    TbBrand findOne(long id);

    /**
     * 修改
     * @param brand
     */
    void update(TbBrand brand);

    /**
     * 删除
     * @param ids
     */
    void delete(long[] ids);

    /**
     * 品牌条件查询
     * @param brand
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult findPage(TbBrand brand,int pageNum, int pageSize);

    /**
     * 返回下拉列表数据
     * @return
     */
    List<Map> selectOptionList();


}

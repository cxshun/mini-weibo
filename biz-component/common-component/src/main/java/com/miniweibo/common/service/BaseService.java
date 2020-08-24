package com.miniweibo.common.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.List;

/**
 * @author nicolas.chan
 * 2020/8/24
 */
public interface BaseService<T, IdType extends Serializable> {

    /**
     * insert entity
     * @param t entity
     * @return  primary ID
     */
    IdType insert(T t);

    /**
     * update entity
     * @param t entity
     * @return  true-update success，false-update fail
     */
    boolean update(T t);

    /**
     * delete specify record
     * @param id    primary ID
     * @return  true-delete success，false-delete fail
     */
    boolean delete(IdType id);

    /**
     * get entity detail
     * @param id    primary id
     * @return  entity result
     */
    T detail(IdType id);

    /**
     * find result that match the query condition
     * @param wrapper   query condition
     * @param page      page
     * @param pageSize  pageSize
     * @return  search result
     */
    Page<T> list(Wrapper<T> wrapper, Integer page, Integer pageSize);

    /**
     * find result that match the primary id list
     * @param idList    id list
     * @return  result list
     */
    List<T> listByIds(List<IdType> idList);

}

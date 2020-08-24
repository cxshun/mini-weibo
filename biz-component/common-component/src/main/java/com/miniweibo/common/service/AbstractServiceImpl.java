package com.miniweibo.common.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ReflectionUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author nicolas.chan
 * 2020/8/24
 */
@Slf4j
public abstract class AbstractServiceImpl<T, IdType extends Serializable> implements BaseService<T, IdType>{

    /**
     * get associated mapper
     * @return  associated mapper
     */
    protected abstract BaseMapper<T> getMapper();

    @SuppressWarnings({"unchecked", "ConstantConditions"})
    @Override
    public IdType insert(T t) {
        int result = getMapper().insert(t);
        if (result <= 0) {
            return (IdType)Long.valueOf(1);
        }

        Field field = ReflectionUtils.findField(t.getClass(), "getId");
        if (field == null) {
            log.warn("class {} has no getId method", t.getClass().getName());
        }
        return (IdType)ReflectionUtils.getField(field, t);
    }

    @Override
    public boolean update(T t) {
        return getMapper().updateById(t) > 0;
    }

    @Override
    public boolean delete(IdType id) {
        return getMapper().deleteById(id) > 0;
    }

    @Override
    public T detail(IdType id) {
        return getMapper().selectById(id);
    }

    @Override
    public Page<T> list(Wrapper<T> wrapper, Integer page, Integer pageSize) {
        return getMapper().selectPage(new Page<>(page, pageSize), wrapper);
    }

    @Override
    public List<T> listByIds(List<IdType> idList) {
        return getMapper().selectBatchIds(idList);
    }
}

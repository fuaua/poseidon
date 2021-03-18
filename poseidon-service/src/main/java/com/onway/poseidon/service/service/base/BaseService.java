package com.onway.poseidon.service.service.base;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.onway.poseidon.common.base.request.BasePageRequest;
import com.onway.poseidon.common.enums.YesOrNotEnum;
import com.onway.poseidon.service.utils.DbConstant;
import com.onway.poseidon.service.utils.PoPage;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author: fuheng
 * @date: 2021/1/21 16:44
 * @description:
 */
public class BaseService<T, M extends BaseMapper<T>>{


    @Autowired
    protected M baseMapper;

    public M getBaseMapper() {
        return baseMapper;
    }

    protected Class<T> entityClass = currentModelClass();

    protected Class<T> mapperClass = currentMapperClass();

    public Class<T> getEntityClass() {
        return entityClass;
    }

    protected Class<T> currentModelClass() {
        return (Class<T>) ReflectionKit.getSuperClassGenericType(getClass(), 1);
    }

    protected Class<T> currentMapperClass() {
        return (Class<T>) ReflectionKit.getSuperClassGenericType(getClass(), 0);
    }

    /**
     * 通用新增方法
     * @param entity
     */
    public Long add(T entity) {
        long id = IdWorker.getId();
        try {
            Method setIdMethod = entity.getClass().getSuperclass().getMethod(DbConstant.INVOKE_SET_ID, Long.class);
            setIdMethod.invoke(entity, id);
        }catch (Exception e) {
            e.printStackTrace();
        }
        int insertRs = baseMapper.insert(entity);
        Assert.isTrue(Objects.equals(YesOrNotEnum.YES.getValue(), insertRs), "新增失败数据{}", JSON.toJSONString(entity));
        return id;
    }

    /**
     * 根据主键删除
     * @param id 主键
     * @return 返回删除的条数
     */
    public Integer deleteById(Long id) {
        return baseMapper.deleteById(id);
    }


    /**
     * mybatisplus通用普通分页
     * @param pageRequest
     * @return
     */
    public PoPage<T> pageList(BasePageRequest pageRequest, QueryWrapper<T> wrapper) {
        Page<T> page = new Page<>(pageRequest.getPageNum(),pageRequest.getPageSize());
        Page<T> tPage = baseMapper.selectPage(page, wrapper);
        PoPage<T> poPage = new PoPage<>();
        poPage.setTotalCount(tPage.getTotal());
        poPage.setPageSize(tPage.getSize());
        poPage.setPageNum(tPage.getCurrent());
        poPage.setPageCount(tPage.getPages());
        poPage.setList(tPage.getRecords());
        return poPage;
    }

}

package com.service.impl;

import com.mapper.BudgetMapper;
import com.model.Budget;
import com.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-13 13:11
 */
@Service
public class BudgetServiceImpl implements BudgetService {
    @Autowired
    private BudgetMapper budgetMapper;

    @Override
    public List<Budget> getAllBudget() {
        return budgetMapper.selectAllModel();
    }

    @Override
    public List<Budget> getAllBudget(Integer page, Integer limit) {
        return budgetMapper.selectAllModel((page-1)*limit,limit);
    }

    @Override
    public Budget getBudgetById(Integer id) {
        return budgetMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Budget> getBudgetByCtId(Integer id) {
        return budgetMapper.selectByCtId(id);
    }

    @Override
    public List<Budget> getBudgetByGdId(Integer id) {
        return budgetMapper.selectByGdId(id);
    }

    @Override
    public List<Budget> getBudgetByClId(Integer id) {
        return budgetMapper.selectByClId(id);
    }

    @Override
    public List<Budget> queryBudgetByCtId(Integer id) {
        return budgetMapper.queryByCtId(id);
    }

    @Override
    public List<Budget> queryBudgetByGdId(Integer id) {
        return budgetMapper.queryByGdId(id);
    }

    @Override
    public List<Budget> queryBudgetByClId(Integer id) {
        return budgetMapper.queryByClId(id);
    }

    @Override
    public List<Budget> getBudgetByJoinCtId(Integer id) {
        return budgetMapper.selectByJoinCtId(id);
    }

    @Override
    public List<Budget> queryBudgetByJoinCtId(Integer id) {
        return budgetMapper.queryByJoinCtId(id);
    }

    @Override
    public Budget getBudgetByMinId() {
        return budgetMapper.selectByMinPrimaryKey();
    }

    @Override
    public Budget getBudgetByMaxId() {
        return budgetMapper.selectByMaxPrimaryKey();
    }

    @Override
    public List<Budget> getBudgetByParam(Budget record) {
        return budgetMapper.selectByParam(record);
    }

    @Override
    public List<Budget> queryBudgetByParam(Budget record) {
        return budgetMapper.queryByParam(record);
    }

    @Override
    public List<Budget> getBudgetByCondition(String field, String value) {
        return budgetMapper.selectByCondition(field,value);
    }

    @Override
    public long countBudgetBySelectCondition(String field, String value) {
        return budgetMapper.countBySelectCondition(field,value);
    }

    @Override
    public List<Budget> getBudgetByCondition(String field, String value, Integer page, Integer limit) {
        return budgetMapper.selectByCondition(field,value,(page-1)*limit,limit);
    }

    @Override
    public List<Budget> queryBudgetByCondition(String field, String value) {
        return budgetMapper.queryByCondition(field,value);
    }

    @Override
    public long countBudgetByQueryCondition(String field, String value) {
        return budgetMapper.countByQueryCondition(field,value);
    }

    @Override
    public List<Budget> queryBudgetByCondition(String field, String value, Integer page, Integer limit) {
        return budgetMapper.queryByCondition(field,value,(page-1)*limit,limit);
    }

    @Override
    public List<Budget> getBudgetFieldsByCondition(String fields, String field, String value) {
        return budgetMapper.selectFieldsByCondition(fields,field,value);
    }

    @Override
    public List<Budget> getBudgetFieldsByCondition(String fields, String field, String value, Integer page, Integer limit) {
        return budgetMapper.selectFieldsByCondition(fields,field,value,(page-1)*limit,limit);
    }

    @Override
    public List<Budget> queryBudgetFieldsByCondition(String fields, String field, String value) {
        return budgetMapper.queryFieldsByCondition(fields,field,value);
    }

    @Override
    public List<Budget> queryBudgetFieldsByCondition(String fields, String field, String value, Integer page, Integer limit) {
        return budgetMapper.queryFieldsByCondition(fields,field,value,(page-1)*limit,limit);
    }

    @Override
    public List<Budget> getBudgetBySql(String sql) {
        return budgetMapper.selectBySql(sql);
    }

    @Override
    public List<Budget> getBudgetFieldsBySql(String field, String sql) {
        return budgetMapper.selectFieldsBySql(field,sql);
    }

    @Override
    public int insertBudget(Budget record) {
        return budgetMapper.insert(record);
    }

    @Override
    public int setBudgetById(Budget record) {
        return budgetMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delBudgetById(Integer id) {
        return budgetMapper.deleteByPrimaryKey(id);
    }
}
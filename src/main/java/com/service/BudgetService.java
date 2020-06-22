package com.service;

import com.model.Budget;

import java.util.List;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-13 13:09
 */
public interface BudgetService {
    List<Budget> getAllBudget();

    List<Budget> getAllBudget(Integer page, Integer limit);

    Budget getBudgetById(Integer id);

    List<Budget> getBudgetByCtId(Integer id);

    List<Budget> getBudgetByGdId(Integer id);

    List<Budget> getBudgetByClId(Integer id);

    List<Budget> queryBudgetByCtId(Integer id);

    List<Budget> queryBudgetByGdId(Integer id);

    List<Budget> queryBudgetByClId(Integer id);

    List<Budget> getBudgetByJoinCtId(Integer id);

    List<Budget> queryBudgetByJoinCtId(Integer id);

    Budget getBudgetByMinId();

    Budget getBudgetByMaxId();

    List<Budget> getBudgetByParam(Budget record);

    List<Budget> queryBudgetByParam(Budget record);

    List<Budget> getBudgetByCondition(String field, String value);

    long countBudgetBySelectCondition(String field, String value);

    List<Budget> getBudgetByCondition(String field, String value, Integer page, Integer limit);

    List<Budget> queryBudgetByCondition(String field, String value);

    long countBudgetByQueryCondition(String field, String value);

    List<Budget> queryBudgetByCondition(String field, String value, Integer page, Integer limit);

    List<Budget> getBudgetFieldsByCondition(String fields, String field, String value);

    List<Budget> getBudgetFieldsByCondition(String fields, String field, String value, Integer page, Integer limit);

    List<Budget> queryBudgetFieldsByCondition(String fields, String field, String value);

    List<Budget> queryBudgetFieldsByCondition(String fields, String field, String value, Integer page, Integer limit);

    List<Budget> getBudgetBySql(String sql);

    List<Budget> getBudgetFieldsBySql(String fields, String sql);

    int insertBudget(Budget record);

    int setBudgetById(Budget record);

    int delBudgetById(Integer id);
}
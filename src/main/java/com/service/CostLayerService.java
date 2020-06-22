package com.service;

import com.model.CostLayer;
import com.model.Guidance;
import com.model.Quantity;

import java.util.List;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-02-13 13:09
 */
public interface CostLayerService {
    List<CostLayer> getAllCostLayer();

    List<CostLayer> getAllCostLayer(Integer page, Integer limit);

    CostLayer getCostLayerById(Integer id);

    List<Quantity> getQuantityByCtId(Integer id, Integer page, Integer limit);

    long countQuantityBySelectCtId(Integer id);

    List<Quantity> queryQuantityByCtId(Integer id, Integer page, Integer limit);

    long countQuantityByQueryCtId(Integer id);

    CostLayer getCostLayerByMinId();

    CostLayer getCostLayerByMaxId();

    List<CostLayer> getCostLayerByParam(CostLayer record);

    List<CostLayer> queryCostLayerByParam(CostLayer record);

    List<CostLayer> getCostLayerByCondition(String field, String value);

    long countCostLayerBySelectCondition(String field, String value);

    List<CostLayer> getCostLayerByCondition(String field, String value, Integer page, Integer limit);

    List<CostLayer> queryCostLayerByCondition(String field, String value);

    long countCostLayerByQueryCondition(String field, String value);

    List<CostLayer> queryCostLayerByCondition(String field, String value, Integer page, Integer limit);

    List<CostLayer> getCostLayerFieldsByCondition(String fields, String field, String value);

    List<CostLayer> getCostLayerFieldsByCondition(String fields, String field, String value, Integer page, Integer limit);

    List<CostLayer> queryCostLayerFieldsByCondition(String fields, String field, String value);

    List<CostLayer> queryCostLayerFieldsByCondition(String fields, String field, String value, Integer page, Integer limit);

    List<CostLayer> getCostLayerBySql(String sql);

    List<CostLayer> getCostLayerFieldsBySql(String fields, String sql);

    int insertCostLayer(CostLayer record);

    int setCostLayerById(CostLayer record);

    int delCostLayerById(Integer id);
}
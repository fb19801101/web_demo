package com.mapper;

import com.model.*;
import com.model.Budget;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * BudgetMapper继承基类
 */
@Repository
public interface BudgetMapper extends MyBatisBaseMapper<Budget, Integer, BudgetExample> {
    @ResultMap("BaseResultMapExtends")
    @Select("<script>\n"+
            "select * from tb_budget\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    ct_id = #{ctId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    List<Budget> selectByCtId(@Param("ctId") Integer ctId);

    @ResultMap("BaseResultMapExtends")
    @Select("<script>\n"+
            "select * from tb_budget\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('gdId') and gdId != null\">\n" +
            "    gd_id = #{gdId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    List<Budget> selectByGdId(@Param("gdId") Integer gdId);

    @ResultMap("BaseResultMapExtends")
    @Select("<script>\n"+
            "select * from tb_budget\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('clId') and clId != null\">\n" +
            "    cl_id = #{cyId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    List<Budget> selectByClId(@Param("clId") Integer clId);

    @ResultMap("BaseResultMapExtends")
    @Select("<script>\n"+
            "select bg.bg_id, ct.ct_id, bg.gd_id, bg.cl_id, ct.ct_code, bg.bg_code, bg.gd_code, bg.cl_code,\n" +
            "  bg.bg_name, bg.bg_unit, bg.bg_rate, bg.bg_qty, bg.bg_price, bg.bg_money, bg.bg_info\n" +
            "from tb_budget bg right join tb_contract ct on ct.ct_id = bg.ct_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    ct.ct_id = #{ctId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    List<Budget> selectByJoinCtId(@Param("ctId") Integer ctId);

    @ResultMap("BaseResultMapExtends")
    @Select("<script>\n"+
            "select * from tb_budget\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('clId') and clId != null\">\n" +
            "    cl_id like concat('%', #{clId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    List<Budget> queryByClId(@Param("clId") Integer clId);

    @ResultMap("BaseResultMapExtends")
    @Select("<script>\n"+
            "select * from tb_budget\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('gdId') and gdId != null\">\n" +
            "    gd_id like concat('%', #{gdId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    List<Budget> queryByGdId(@Param("gdId") Integer gdId);

    @ResultMap("BaseResultMapExtends")
    @Select("<script>\n"+
            "select * from tb_budget\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    ct_id like concat('%', #{ctId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    List<Budget> queryByCtId(@Param("ctId") Integer ctId);

    @ResultMap("BaseResultMapExtends")
    @Select("<script>\n"+
            "select bg.bg_id, ct.ct_id, bg.gd_id, bg.cl_id, ct.ct_code, bg.bg_code, bg.gd_code, bg.cl_code,\n" +
            "  bg.bg_name, bg.bg_unit, bg.bg_rate, bg.bg_qty, bg.bg_price, bg.bg_money, bg.bg_info\n" +
            "from tb_budget bg right join tb_contract ct on ct.ct_id = bg.ct_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    ct.ct_id like concat('%', #{ctId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    List<Budget> queryByJoinCtId(@Param("ctId") Integer ctId);
}
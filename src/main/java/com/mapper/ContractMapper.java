package com.mapper;

import com.model.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ContractMapper继承基类
 */
@Repository
public interface ContractMapper extends MyBatisBaseMapper<Contract, Integer, ContractExample> {
    @Results({
        @Result(column="gd_id",property="gdId", id = true),
        @Result(column="gd_code",property="gdCode"),
        @Result(column="gd_label",property="gdLabel"),
        @Result(column="gd_name",property="gdName"),
        @Result(column="gd_unit",property="gdUnit"),
        @Result(column="gd_rate",property="gdRate"),
        @Result(column="gd_price",property="gdPrice"),
        @Result(column="gd_item",property="gdItem"),
        @Result(column="gd_work",property="gdWork"),
        @Result(column="gd_cost",property="gdCost"),
        @Result(column="gd_role",property="gdRole"),
        @Result(column="gd_info",property="gdInfo"),
    })
    @Select("<script>\n"+
            "select gd.* from tb_contract ct\n" +
            "inner join tb_budget bg on bg.ct_id = ct.ct_id\n" +
            "inner join tb_guidance gd on gd.gd_id = bg.gd_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    ct.ct_id = #{ctId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by ct.ct_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by ct.ct_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<Guidance> selectGuidanceByCtId(@Param("ctId") Integer ctId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_contract ct\n" +
            "inner join tb_budget bg on bg.ct_id = ct.ct_id\n" +
            "inner join tb_guidance gd on gd.gd_id = bg.gd_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    ct.ct_id = #{ctId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countGuidanceBySelectCtId(@Param("ctId") Integer ctId);

    @Results({
        @Result(column="bg_id",property="bgId",id=true),
        @Result(column="ct_id",property="ctId"),
        @Result(column="gd_id",property="gdId"),
        @Result(column="cl_id",property="clId"),
        @Result(column="ct_code",property="ctCode"),
        @Result(column="gd_code",property="gdCode"),
        @Result(column="cl_code",property="clCode"),
        @Result(column="bg_code",property="bgCode"),
        @Result(column="bg_name",property="bgName"),
        @Result(column="bg_unit",property="bgUnit"),
        @Result(column="bg_rate",property="bgRate"),
        @Result(column="bg_qty",property="bgQty"),
        @Result(column="bg_price",property="bgPrice"),
        @Result(column="bg_money",property="bgMoney"),
        @Result(column="bg_info",property="bgInfo")
    })
    @Select("<script>\n"+
            "select bg.* from tb_contract ct\n" +
            "inner join tb_budget bg on bg.ct_id = ct.ct_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    ct.ct_id = #{ctId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by ct.ct_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by ct.ct_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<Budget> selectBudgetByCtId(@Param("ctId") Integer ctId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_contract ct\n" +
            "inner join tb_budget bg on bg.ct_id = ct.ct_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    ct.ct_id = #{ctId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countBudgetBySelectCtId(@Param("ctId") Integer ctId);

    @Results({
            @Result(column="cl_id",property="clId", id = true),
            @Result(column="cl_code",property="clCode"),
            @Result(column="cl_type",property="clType"),
            @Result(column="cl_name",property="clName"),
            @Result(column="cl_unit",property="clUnit"),
            @Result(column="cl_budget",property="clBudget"),
            @Result(column="cl_dwg_design",property="clDwgDesign"),
            @Result(column="cl_dwg_change",property="clDwgChange"),
            @Result(column="cl_chk_design",property="clChkDesign"),
            @Result(column="cl_chk_change",property="clChkChange"),
            @Result(column="cl_act_design",property="clActDesign"),
            @Result(column="cl_act_change",property="clActChange"),
            @Result(column="cl_do_design",property="clDoDesign"),
            @Result(column="cl_do_change",property="clDoChange"),
            @Result(column="cl_up_design",property="clUpDesign"),
            @Result(column="cl_up_change",property="clUpChange"),
            @Result(column="cl_down_design",property="clDownDesign"),
            @Result(column="cl_down_change",property="clDownChange"),
            @Result(column="cl_info",property="clInfo")
    })
    @Select("<script>\n"+
            "select cl.* from tb_contract ct\n" +
            "inner join tb_budget bg on bg.ct_id = ct.ct_id\n" +
            "inner join tb_costlayer cl on cl.cl_id = bg.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    ct.ct_id = #{ctId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by ct.ct_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by ct.ct_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<CostLayer> selectCostLayerByCtId(@Param("ctId") Integer ctId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_contract ct\n" +
            "inner join tb_budget bg on bg.ct_id = ct.ct_id\n" +
            "inner join tb_costlayer cl on cl.cl_id = bg.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    ct.ct_id = #{ctId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countCostLayerBySelectCtId(@Param("ctId") Integer ctId);

    @Results({
            @Result(column="gd_id",property="gdId", id = true),
            @Result(column="gd_code",property="gdCode"),
            @Result(column="gd_label",property="gdLabel"),
            @Result(column="gd_name",property="gdName"),
            @Result(column="gd_unit",property="gdUnit"),
            @Result(column="gd_rate",property="gdRate"),
            @Result(column="gd_price",property="gdPrice"),
            @Result(column="gd_item",property="gdItem"),
            @Result(column="gd_work",property="gdWork"),
            @Result(column="gd_cost",property="gdCost"),
            @Result(column="gd_role",property="gdRole"),
            @Result(column="gd_info",property="gdInfo"),
    })
    @Select("<script>\n"+
            "select gd.* from tb_contract ct\n" +
            "inner join tb_budget bg on bg.ct_id = ct.ct_id\n" +
            "inner join tb_guidance gd on gd.gd_id = bg.gd_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    ct.ct_id like concat('%', #{ctId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by ct.ct_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by ct.ct_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<Guidance> queryGuidanceByCtId(@Param("ctId") Integer ctId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_contract ct\n" +
            "inner join tb_budget bg on bg.ct_id = ct.ct_id\n" +
            "inner join tb_guidance gd on gd.gd_id = bg.gd_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    ct.ct_id like concat('%', #{ctId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countGuidanceByQueryCtId(@Param("ctId") Integer ctId);

    @Results({
            @Result(column="bg_id",property="bgId",id=true),
            @Result(column="ct_id",property="ctId"),
            @Result(column="gd_id",property="gdId"),
            @Result(column="cl_id",property="clId"),
            @Result(column="ct_code",property="ctCode"),
            @Result(column="gd_code",property="gdCode"),
            @Result(column="cl_code",property="clCode"),
            @Result(column="bg_code",property="bgCode"),
            @Result(column="bg_name",property="bgName"),
            @Result(column="bg_unit",property="bgUnit"),
            @Result(column="bg_rate",property="bgRate"),
            @Result(column="bg_qty",property="bgQty"),
            @Result(column="bg_price",property="bgPrice"),
            @Result(column="bg_money",property="bgMoney"),
            @Result(column="bg_info",property="bgInfo")
    })
    @Select("<script>\n"+
            "select bg.* from tb_contract ct\n" +
            "inner join tb_budget bg on bg.ct_id = ct.ct_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    ct.ct_id like concat('%', #{ctId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by ct.ct_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by ct.ct_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<Budget> queryBudgetByCtId(@Param("ctId") Integer ctId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_contract ct\n" +
            "inner join tb_budget bg on bg.ct_id = ct.ct_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    ct.ct_id like concat('%', #{ctId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countBudgetByQueryCtId(@Param("ctId") Integer ctId);

    @Results({
            @Result(column="cl_id",property="clId", id = true),
            @Result(column="cl_code",property="clCode"),
            @Result(column="cl_type",property="clType"),
            @Result(column="cl_name",property="clName"),
            @Result(column="cl_unit",property="clUnit"),
            @Result(column="cl_budget",property="clBudget"),
            @Result(column="cl_dwg_design",property="clDwgDesign"),
            @Result(column="cl_dwg_change",property="clDwgChange"),
            @Result(column="cl_chk_design",property="clChkDesign"),
            @Result(column="cl_chk_change",property="clChkChange"),
            @Result(column="cl_act_design",property="clActDesign"),
            @Result(column="cl_act_change",property="clActChange"),
            @Result(column="cl_do_design",property="clDoDesign"),
            @Result(column="cl_do_change",property="clDoChange"),
            @Result(column="cl_up_design",property="clUpDesign"),
            @Result(column="cl_up_change",property="clUpChange"),
            @Result(column="cl_down_design",property="clDownDesign"),
            @Result(column="cl_down_change",property="clDownChange"),
            @Result(column="cl_info",property="clInfo")
    })
    @Select("<script>\n"+
            "select cl.* from tb_contract ct\n" +
            "inner join tb_budget bg on bg.ct_id = ct.ct_id\n" +
            "inner join tb_costlayer cl on cl.cl_id = bg.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    ct.ct_id like concat('%', #{ctId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by ct.ct_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by ct.ct_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<CostLayer> queryCostLayerByCtId(@Param("ctId") Integer ctId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_contract ct\n" +
            "inner join tb_budget bg on bg.ct_id = ct.ct_id\n" +
            "inner join tb_costlayer cl on cl.cl_id = bg.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    ct.ct_id like concat('%', #{ctId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countCostLayerByQueryCtId(@Param("ctId") Integer ctId);

}
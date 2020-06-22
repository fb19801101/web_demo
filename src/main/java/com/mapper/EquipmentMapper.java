package com.mapper;

import com.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * EquipmentMapper继承基类
 */
@Repository
public interface EquipmentMapper extends MyBatisBaseMapper<Equipment, Integer, EquipmentExample> {
    @ResultMap("BaseResultMapExtends")
    @Select("<script>\n"+
            "select * from tb_equipment\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    pi_id = #{piId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    List<Equipment> selectByPiId(@Param("piId") Integer piId);

    @ResultMap("BaseResultMapExtends")
    @Select("<script>\n"+
            "select * from tb_equipment\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('clId') and clId != null\">\n" +
            "    cl_id = #{clId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    List<Equipment> selectByClId(@Param("clId") Integer clId);

    @ResultMap("BaseResultMapExtends")
    @Select("<script>\n"+
            "select et.et_id, et.et_code, pi.pi_id, et.cl_id, pi.pi_name, et.cl_code, et.et_date, et.et_name, et.et_unit, et.et_do_design,\n" +
            "  et.et_do_change, et.et_up_design, et.et_up_change, et.et_down_design, et.et_down_change, et.et_info\n" +
            "from tb_equipment et right join tb_partitem pi on pi.pi_id = et.pi_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    pi.pi_id = #{piId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    List<Equipment> selectByJoinPiId(@Param("piId") Integer piId);

    @Select("<script>\n"+
            "select count(*) from\n" +
            "(select cl_id, min(cl_code) cl_code, sum(et_do_design) et_do_design, sum(et_do_change) et_do_change, sum(et_up_design) et_up_design, sum(et_up_change) et_up_change,\n" +
            "  sum(et_down_design) et_down_design, sum(et_down_change) et_down_change from tb_equipment group by cl_id having cl_id is not null) et\n" +
            "  inner join tb_costlayer cl on cl.cl_id=et.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('clId') and clId != null\">\n" +
            "    cl.cl_id = #{clId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countCostLayerBySelectClId(@Param("ctId") Integer ctId);

    @ResultMap("BaseResultMapExtends")
    @Select("<script>\n"+
            "select * from tb_equipment\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    pi_id like concat('%', #{piId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    List<Equipment> queryByPiId(@Param("piId") Integer piId);

    @ResultMap("BaseResultMapExtends")
    @Select("<script>\n"+
            "select * from tb_equipment\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('clId') and clId != null\">\n" +
            "    cl_id like concat('%', #{clId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    List<Equipment> queryByClId(@Param("clId") Integer clId);

    @ResultMap("BaseResultMapExtends")
    @Select("<script>\n"+
            "select et.et_id, et.et_code, pi.pi_id, et.cl_id, pi.pi_name, et.cl_code, et.et_date, et.et_name, et.et_unit, et.et_do_design,\n" +
            "  et.et_do_change, et.et_up_design, et.et_up_change, et.et_down_design, et.et_down_change, et.et_info\n" +
            "from tb_equipment et right join tb_partitem pi on pi.pi_id = et.pi_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    pi.pi_id like concat('%', #{piId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    List<Equipment> queryByJoinPiId(@Param("piId") Integer piId);

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
            "select gd.* from tb_equipment et\n" +
            "inner join tb_budget bg on bg.cl_id = et.cl_id\n" +
            "inner join tb_guidance gd on gd.gd_id = bg.gd_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    et.pi_id = #{piId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by et.pi_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by et.pi_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<Guidance> selectGuidanceByPiId(@Param("piId") Integer piId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_equipment et\n" +
            "inner join tb_budget bg on bg.cl_id = et.cl_id\n" +
            "inner join tb_guidance gd on gd.gd_id = bg.gd_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    et.pi_id = #{piId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countGuidanceBySelectPiId(@Param("piId") Integer piId);

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
            "select bg.* from tb_equipment et\n" +
            "inner join tb_budget bg on bg.cl_id = et.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    et.pi_id = #{piId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by et.pi_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by et.pi_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<Budget> selectBudgetByPiId(@Param("piId") Integer piId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_equipment et\n" +
            "inner join tb_budget bg on bg.cl_id = et.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    et.pi_id = #{piId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countBudgetBySelectPiId(@Param("piId") Integer piId);

    @Results({
            @Result(column="ct_id",property="ctId", id = true),
            @Result(column="ct_pid",property="ctPid"),
            @Result(column="ct_level",property="ctLevel"),
            @Result(column="ct_code",property="ctCode"),
            @Result(column="ct_name",property="ctName"),
            @Result(column="ct_unit",property="ctUnit"),
            @Result(column="ct_qty",property="ctQty"),
            @Result(column="ct_price",property="ctPrice"),
            @Result(column="ct_money",property="ctMoney"),
            @Result(column="ct_info",property="ctInfo")
    })
    @Select("<script>\n"+
            "select ct.* from tb_equipment et\n" +
            "inner join tb_budget bg on bg.cl_id = et.cl_id\n" +
            "inner join tb_contract ct on ct.ct_id = bg.ct_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    et.pi_id = #{piId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by et.pi_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by et.pi_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<Contract> selectContractByPiId(@Param("piId") Integer piId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_equipment et\n" +
            "inner join tb_budget bg on bg.cl_id = et.cl_id\n" +
            "inner join tb_contract ct on ct.ct_id = bg.ct_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    et.pi_id = #{piId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countContractBySelectPiId(@Param("piId") Integer piId);

    @Results({
            @Result(column="cl_id",property="clId",id=true),
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
            "select et.cl_id, et.cl_code, cl.cl_type, cl.cl_name, cl.cl_unit, cl.cl_budget, cl.cl_dwg_design, cl.cl_dwg_change,\n" +
            "  cl.cl_chk_design, cl.cl_chk_change, cl.cl_act_design, cl.cl_act_change, et.et_do_design cl_do_design, et.et_do_change cl_do_change,\n" +
            "  et.et_up_design cl_up_design, et.et_up_change cl_up_change, et.et_down_design cl_down_design, et.et_down_change cl_down_change, cl.cl_info from\n" +
            "(select cl_id, min(cl_code) cl_code, sum(et_do_design) et_do_design, sum(et_do_change) et_do_change, sum(et_up_design) et_up_design, sum(et_up_change) et_up_change,\n" +
            "  sum(et_down_design) et_down_design, sum(et_down_change) et_down_change from tb_equipment group by cl_id having cl_id is not null) et\n" +
            "  inner join tb_costlayer cl on cl.cl_id=et.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('clId') and clId != null\">\n" +
            "    cl.cl_id = #{clId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by cl.cl_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by cl.cl_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<CostLayer> selectCostLayerByClId(@Param("clId") Integer clId, @Param("offset") Integer offset, @Param("limit") Integer limit);

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
            "select gd.* from tb_equipment et\n" +
            "inner join tb_budget bg on bg.cl_id = et.cl_id\n" +
            "inner join tb_guidance gd on gd.gd_id = bg.gd_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    et.pi_id like concat('%', #{piId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by et.pi_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by et.pi_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<Guidance> queryGuidanceByPiId(@Param("piId") Integer piId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_equipment et\n" +
            "inner join tb_budget bg on bg.cl_id = et.cl_id\n" +
            "inner join tb_guidance gd on gd.gd_id = bg.gd_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    et.pi_id like concat('%', #{piId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countGuidanceByQueryPiId(@Param("piId") Integer piId);

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
            "select bg.* from tb_equipment et\n" +
            "inner join tb_budget bg on bg.cl_id = et.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    et.pi_id like concat('%', #{piId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by et.pi_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by et.pi_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<Budget> queryBudgetByPiId(@Param("piId") Integer piId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_equipment et\n" +
            "inner join tb_budget bg on bg.cl_id = et.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    et.pi_id like concat('%', #{piId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countBudgetByQueryPiId(@Param("piId") Integer piId);

    @Results({
            @Result(column="ct_id",property="ctId", id = true),
            @Result(column="ct_pid",property="ctPid"),
            @Result(column="ct_level",property="ctLevel"),
            @Result(column="ct_code",property="ctCode"),
            @Result(column="ct_name",property="ctName"),
            @Result(column="ct_unit",property="ctUnit"),
            @Result(column="ct_qty",property="ctQty"),
            @Result(column="ct_price",property="ctPrice"),
            @Result(column="ct_money",property="ctMoney"),
            @Result(column="ct_info",property="ctInfo")
    })
    @Select("<script>\n"+
            "select ct.* from tb_equipment et\n" +
            "inner join tb_budget bg on bg.cl_id = et.cl_id\n" +
            "inner join tb_contract ct on ct.ct_id = bg.ct_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    et.pi_id like concat('%', #{piId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by et.pi_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by et.pi_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<Contract> queryContractByPiId(@Param("piId") Integer piId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_equipment et\n" +
            "inner join tb_budget bg on bg.cl_id = et.cl_id\n" +
            "inner join tb_contract ct on ct.ct_id = bg.ct_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    et.pi_id like concat('%', #{piId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countContractByQueryPiId(@Param("piId") Integer piId);

    @Results({
            @Result(column="cl_id",property="clId",id=true),
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
            "select et.cl_id, et.cl_code, cl.cl_type, cl.cl_name, cl.cl_unit, cl.cl_budget, cl.cl_dwg_design, cl.cl_dwg_change,\n" +
            "  cl.cl_chk_design, cl.cl_chk_change, cl.cl_act_design, cl.cl_act_change, et.et_do_design cl_do_design, et.et_do_change cl_do_change,\n" +
            "  et.et_up_design cl_up_design, et.et_up_change cl_up_change, et.et_down_design cl_down_design, et.et_down_change cl_down_change, cl.cl_info from\n" +
            "(select cl_id, min(cl_code) cl_code, sum(et_do_design) et_do_design, sum(et_do_change) et_do_change, sum(et_up_design) et_up_design, sum(et_up_change) et_up_change,\n" +
            "  sum(et_down_design) et_down_design, sum(et_down_change) et_down_change from tb_equipment group by cl_id having cl_id is not null) et\n" +
            "  inner join tb_costlayer cl on cl.cl_id=et.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('clId') and clId != null\">\n" +
            "    cl.cl_id like concat('%', #{clId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by cl.cl_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by cl.cl_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<CostLayer> queryCostLayerByClId(@Param("clId") Integer clId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from\n" +
            "(select cl_id, min(cl_code) cl_code, sum(et_do_design) et_do_design, sum(et_do_change) et_do_change, sum(et_up_design) et_up_design, sum(et_up_change) et_up_change,\n" +
            "  sum(et_down_design) et_down_design, sum(et_down_change) et_down_change from tb_equipment group by cl_id having cl_id is not null) et\n" +
            "  inner join tb_costlayer cl on cl.cl_id=et.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('clId') and clId != null\">\n" +
            "    cl.cl_id like concat('%', #{clId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countCostLayerByQueryClId(@Param("ctId") Integer ctId);
}
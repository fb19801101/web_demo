package com.mapper;

import com.daoutil.DataSource;
import com.model.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PartitemMapper继承基类
 */
@Repository
public interface PartItemMapper extends MyBatisBaseMapper<PartItem, Integer, PartItemExample> {
    @Results({
        @Result(column="qy_id",property="qyId",id=true),
        @Result(column="pi_id",property="piId"),
        @Result(column="pi_name",property="piName"),
        @Result(column="cl_id",property="clId"),
        @Result(column="cl_code",property="clCode"),
        @Result(column="qy_date",property="qyDate"),
        @Result(column="qy_name",property="qyName"),
        @Result(column="qy_unit",property="qyUnit"),
        @Result(column="qy_do_design",property="qyDoDesign"),
        @Result(column="qy_do_change",property="qyDoChange"),
        @Result(column="qy_up_design",property="qyUpDesign"),
        @Result(column="qy_up_change",property="qyUpChange"),
        @Result(column="qy_down_design",property="qyDownDesign"),
        @Result(column="qy_down_change",property="qyDownChange"),
        @Result(column="qy_info",property="qyInfo")
    })
    @Select("<script>\n"+
            "select qy.* from tb_partitem pi\n" +
            "inner join tb_quantity qy on qy.pi_id = pi.pi_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    pi.pi_id = #{piId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by pi.pi_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by pi.pi_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<Quantity> selectQuantityByPiId(@Param("piId") Integer piId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_partitem pi\n" +
            "inner join tb_quantity qy on qy.pi_id = pi.pi_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    pi.pi_id = #{piId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countQuantityBySelectPiId(@Param("piId") Integer piId);

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
            "select cl.* from tb_partitem pi\n" +
            "inner join tb_quantity qy on pi.pi_id = qy.pi_id\n" +
            "inner join tb_costlayer cl on cl.cl_id = qy.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    pi.pi_id = #{piId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by pi.pi_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by pi.pi_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<CostLayer> selectCostLayerByPiId(@Param("piId") Integer piId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_partitem pi\n" +
            "inner join tb_quantity qy on pi.pi_id = qy.pi_id\n" +
            "inner join tb_costlayer cl on cl.cl_id = qy.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    pi.pi_id = #{piId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countCostLayerBySelectPiId(@Param("piId") Integer piId);

    @Results({
        @Result(column="np_id",property="npId",id=true),
        @Result(column="pi_id",property="piId"),
        @Result(column="pi_name",property="piName"),
        @Result(column="lb_id",property="lbId"),
        @Result(column="lb_name",property="lbName"),
        @Result(column="np_work",property="npWork"),
        @Result(column="np_es",property="npEs"),
        @Result(column="np_ef",property="npEf"),
        @Result(column="np_ls",property="npLs"),
        @Result(column="np_lf",property="npLf"),
        @Result(column="np_rs",property="npRs"),
        @Result(column="np_rf",property="npRf"),
        @Result(column="np_info",property="npInfo")
    })
    @Select("<script>\n"+
            "select np.* from tb_partitem pi\n" +
            "inner join tb_netplan np on np.pi_id = pi.pi_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    pi.pi_id = #{piId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by pi.pi_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by pi.pi_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<NetPlan> selectNetPlanByPiId(@Param("piId") Integer piId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_partitem pi\n" +
            "inner join tb_netplan np on np.pi_id = pi.pi_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    pi.pi_id = #{piId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countNetPlanBySelectPiId(@Param("piId") Integer piId);

    @Results({
            @Result(column="qy_id",property="qyId",id=true),
            @Result(column="pi_id",property="piId"),
            @Result(column="pi_name",property="piName"),
            @Result(column="cl_id",property="clId"),
            @Result(column="cl_code",property="clCode"),
            @Result(column="qy_date",property="qyDate"),
            @Result(column="qy_name",property="qyName"),
            @Result(column="qy_unit",property="qyUnit"),
            @Result(column="qy_do_design",property="qyDoDesign"),
            @Result(column="qy_do_change",property="qyDoChange"),
            @Result(column="qy_up_design",property="qyUpDesign"),
            @Result(column="qy_up_change",property="qyUpChange"),
            @Result(column="qy_down_design",property="qyDownDesign"),
            @Result(column="qy_down_change",property="qyDownChange"),
            @Result(column="qy_info",property="qyInfo")
    })
    @Select("<script>\n"+
            "select qy.* from tb_partitem pi\n" +
            "inner join tb_quantity qy on qy.pi_id = pi.pi_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    pi.pi_id like concat('%', #{piId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by pi.pi_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by pi.pi_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<Quantity> queryQuantityByPiId(@Param("piId") Integer piId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_partitem pi\n" +
            "inner join tb_quantity qy on qy.pi_id = pi.pi_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    pi.pi_id like concat('%', #{piId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countQuantityByQueryPiId(@Param("piId") Integer piId);

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
            "select cl.* from tb_partitem pi\n" +
            "inner join tb_quantity qy on pi.pi_id = qy.pi_id\n" +
            "inner join tb_costlayer cl on cl.cl_id = qy.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    pi.pi_id like concat('%', #{piId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by pi.pi_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by pi.pi_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<CostLayer> queryCostLayerByPiId(@Param("piId") Integer piId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_partitem pi\n" +
            "inner join tb_quantity qy on pi.pi_id = qy.pi_id\n" +
            "inner join tb_costlayer cl on cl.cl_id = qy.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    pi.pi_id like concat('%', #{piId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countCostLayerByQueryPiId(@Param("piId") Integer piId);

    @Results({
            @Result(column="np_id",property="npId",id=true),
            @Result(column="pi_id",property="piId"),
            @Result(column="pi_name",property="piName"),
            @Result(column="lb_id",property="lbId"),
            @Result(column="lb_name",property="lbName"),
            @Result(column="np_work",property="npWork"),
            @Result(column="np_es",property="npEs"),
            @Result(column="np_ef",property="npEf"),
            @Result(column="np_ls",property="npLs"),
            @Result(column="np_lf",property="npLf"),
            @Result(column="np_rs",property="npRs"),
            @Result(column="np_rf",property="npRf"),
            @Result(column="np_info",property="npInfo")
    })
    @Select("<script>\n"+
            "select np.* from tb_partitem pi\n" +
            "inner join tb_netplan np on np.pi_id = pi.pi_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    pi.pi_id like concat('%', #{piId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "<if test=\"_parameter != null and _parameter.containsKey('limit') and limit != null\">\n" +
            "  <choose>\n" +
            "    <when test=\"_parameter.containsKey('offset') and offset != null\">\n" +
            "      order by pi.pi_id asc limit #{offset}, #{limit};\n" +
            "    </when>\n" +
            "    <otherwise>\n" +
            "      order by pi.pi_id asc limit  #{limit};\n" +
            "    </otherwise>\n" +
            "  </choose>\n" +
            "</if>" +
            "</script>")
    List<NetPlan> queryNetPlanByPiId(@Param("piId") Integer piId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_partitem pi\n" +
            "inner join tb_netplan np on np.pi_id = pi.pi_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('piId') and piId != null\">\n" +
            "    pi.pi_id like concat('%', #{piId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countNetPlanByQueryPiId(@Param("piId") Integer piId);
}
package com.mapper;

import com.model.CostLayer;
import com.model.CostLayerExample;
import com.model.Quantity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CostLayerMapper继承基类
 */
@Repository
public interface CostLayerMapper extends MyBatisBaseMapper<CostLayer, Integer, CostLayerExample> {
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
            "select qy.* from tb_costlayer cl inner join tb_budget bg on bg.cl_id = cl.cl_id\n" +
            "inner join tb_quantity qy on qy.cl_id = cl.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    bg.ct_id = #{ctId}\n" +
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
    List<Quantity> selectQuantityByCtId(@Param("ctId") Integer ctId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_costlayer cl inner join tb_budget bg on bg.cl_id = cl.cl_id\n" +
            "inner join tb_quantity qy on qy.cl_id = cl.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    bg.ct_id = #{ctId}\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countQuantityBySelectCtId(@Param("ctId") Integer ctId);

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
            "select qy.* from tb_costlayer cl inner join tb_budget bg on bg.cl_id = cl.cl_id\n" +
            "inner join tb_quantity qy on qy.cl_id = cl.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    bg.ct_id like concat('%', #{ctId}, '%')\n" +
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
    List<Quantity> queryQuantityByCtId(@Param("ctId") Integer ctId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("<script>\n"+
            "select count(*) from tb_costlayer cl inner join tb_budget bg on bg.cl_id = cl.cl_id\n" +
            "inner join tb_quantity qy on qy.cl_id = cl.cl_id\n" +
            "<where>\n" +
            "  <if test=\"_parameter != null and _parameter.containsKey('ctId') and ctId != null\">\n" +
            "    bg.ct_id like concat('%', #{ctId}, '%')\n" +
            "  </if>\n" +
            "</where>\n" +
            "</script>")
    long countQuantityByQueryCtId(@Param("ctId") Integer ctId);
}
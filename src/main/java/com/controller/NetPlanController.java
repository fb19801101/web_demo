package com.controller;

import com.dateutil.EncodeUtil;
import com.dateutil.JsonUtil;
import com.model.LayuiData;
import com.model.NetPlan;
import com.model.PartItem;
import com.service.CompanyService;
import com.service.NetPlanService;
import com.service.PartItemService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-04-01 15:50
 */
@Controller
@RequestMapping("netplan")
public class NetPlanController {
    @Autowired
    private NetPlanService netPlanService;

    @Autowired
    private PartItemService partItemService;

    @Autowired
    private CompanyService companyService;

    @RequestMapping("toNetPlan")
    public ModelAndView toNetPlan(HttpServletRequest request, HttpServletResponse response) {
        List list = netPlanService.getAllNetPlan();
        JSONObject json = new JSONObject();
        JSONObject _json = new JSONObject();
        _json.put("code", "200");
        _json.put("message", "操作成功");
        json.put("status", _json);
        JSONArray jsons = new JSONArray();
        for(int i=0; i<list.size(); i++) {
            NetPlan np = (NetPlan)list.get(i);
            JSONObject json1 = np.toJson();
            jsons.add(json1);
        }
        json.put("data", jsons);

//        BufferedWriter write = null;
//        try {
//            String path = request.getServletContext().getRealPath("/demo.json");
//            write = new BufferedWriter(new OutputStreamWriter(
//                    new FileOutputStream(path), "UTF-8"));
//
//            write.append(json.toString());
//            write.append("/n/n/n");
//            write.append(jsons.toString());
//            write.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                write.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        HashMap mapMsg = new HashMap();
        mapMsg.put("list", list);
        mapMsg.put("data", jsons.toString());
        mapMsg.put("json", json.toString());
        return new ModelAndView("netplan/netplan", "message", mapMsg);
    }

    @RequestMapping("toNetPlanBody")
    public @ResponseBody LayuiData toNetPlanBody(Integer id, Integer level) {
//        JOptionPane.showMessageDialog(null, field+"\n"+value, "标题", JOptionPane.PLAIN_MESSAGE);

        List<NetPlan> listNetPlan = netPlanService.queryNetPlanByPiId(id);
        long count = listNetPlan.size();

        List<Map> list = new ArrayList<>();
        for(NetPlan x:listNetPlan) {
            PartItem pi = x.getPartItem();
            if(pi != null && pi.getPiLevel() > level) {
                pi.setPiFold(false);
            }

            list.add(x.toMap());
        }
        return new LayuiData(0, list, count);
    }

    @RequestMapping("netPlanIframe")
    public ModelAndView netPlanIframe(HttpServletRequest request, HttpServletResponse response) {
        List<NetPlan> list = netPlanService.getAllNetPlan();
        HashMap mapMsg = new HashMap();
        mapMsg.put("lstNetPlan", list);
        return new ModelAndView("netplan/netplan_iframe", "message", mapMsg);
    }

    @RequestMapping("insertNetPlan")
    public ModelAndView insertNetPlan(HttpServletRequest request, HttpServletResponse response) {
        EncodeUtil.setEncoderUTF(request, response);
        String npWork = request.getParameter("npWork");
        JSONObject json = JsonUtil.readRequestParameters(request);

        HashMap mapMsg = new HashMap();
        mapMsg.put("lstPartItem", partItemService.getAllPartItem());
        mapMsg.put("lstCompany", companyService.getAllCompany());

        if(npWork != null && npWork.length() > 0) {
            List list = netPlanService.getNetPlanByCondition("np_work", npWork);

            if (list.size() == 0) {
                NetPlan netPlan = netPlanService.getNetPlanByMaxId();
                Integer npId = 0;
                if (netPlan != null) {
                    npId = netPlan.getNpId() + 1;
                } else {
                    npId = 1;
                }

                netPlan.setJson(json);
                netPlan.setNpId(npId);
                netPlanService.insertNetPlan(netPlan);

                mapMsg.put("netplan", netPlan);
                mapMsg.put("msg", "分部分项 "+npWork+" 基本信息数据录入成功!");
                return new ModelAndView("netplan/netplan_insert", "message", mapMsg);
            } else {
                mapMsg.put("netplan", list.get(0));
                mapMsg.put("msg", "分项名称 "+npWork+" 基本信息数据已经录入，请重新输入!");
                return new ModelAndView("netplan/netplan_insert", "message", mapMsg);
            }
        }

        mapMsg.put("msg", "分项名称不能为空，请重新输入!");
        return new ModelAndView("netplan/netplan_insert", "message", mapMsg);
    }

    @RequestMapping("insertNetPlanBody")
    public @ResponseBody LayuiData insertNetPlanBody(NetPlan netPlan) {
//        JOptionPane.showMessageDialog(null, field+"\n"+value, "标题", JOptionPane.PLAIN_MESSAGE);

        int code = 0;
        String npWork = netPlan.getNpWork();
        if(npWork != null && npWork.length() > 0) {
            List list = netPlanService.getNetPlanByCondition("np_work", npWork);

            if (list.size() == 0) {
                NetPlan _netPlan = netPlanService.getNetPlanByMaxId();
                Integer npId = 0;
                if (_netPlan != null) {
                    npId = _netPlan.getNpId() + 1;
                } else {
                    npId = 1;
                }

                netPlan.setNpId(npId);
                code = netPlanService.insertNetPlan(netPlan);
            }
        }
        return new LayuiData(code, netPlan, 1);
    }

    @RequestMapping("modifyNetPlanBody")
    public @ResponseBody LayuiData modifyNetPlanBody(NetPlan netPlan) {
//        JOptionPane.showMessageDialog(null, field+"\n"+value, "标题", JOptionPane.PLAIN_MESSAGE);

        NetPlan _netPlan = netPlanService.getNetPlanById(netPlan.getNpId());
        return new LayuiData(netPlanService.setNetPlanById(netPlan), _netPlan, 1);
    }

    @RequestMapping("deleteNetPlanBody")
    public @ResponseBody LayuiData deleteNetPlanBody(Integer id) {
//        JOptionPane.showMessageDialog(null, field+"\n"+value, "标题", JOptionPane.PLAIN_MESSAGE);

        return new LayuiData(netPlanService.delNetPlanById(id),null,0);
    }

    @RequestMapping("searchNetPlan")
    public ModelAndView searchNetPlan(HttpServletRequest request, HttpServletResponse response) {
        EncodeUtil.setEncoderUTF(request, response);
        String field = request.getParameter("conditionField");
        String value = request.getParameter("conditionValue");

        Map map = new HashMap();
        map.put("lstPartItem", partItemService.getAllPartItem());
        map.put("lstCompany", companyService.getAllCompany());

        if(field != null) {
            List listNetPlan = netPlanService.getNetPlanByCondition(field, value);
            if(value.equals("*")) {
                listNetPlan = netPlanService.getAllNetPlan();
            }

            if (listNetPlan.size() == 0) {
                map.put("NetPlanList", listNetPlan);
                map.put("msg", "系统提示：没有找到满足条件的数据! Field= " + field + ", Value= " + value);
            } else {
                map.put("NetPlanList", listNetPlan);
                map.put("msg", "系统提示：已经找到满足条件的 "+listNetPlan.size()+" 数据! Field= " + field + ", Value= " + value);
            }
        }

        return new ModelAndView("netplan/netplan_search", "message", map);
    }

    @RequestMapping("searchNetPlanBody")
    public @ResponseBody LayuiData searchNetPlanBody(String field, String value, @RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
//        JOptionPane.showMessageDialog(null, field+"\n"+value, "标题", JOptionPane.PLAIN_MESSAGE);

        List list = netPlanService.queryNetPlanByCondition(field, value, page, limit);
        long count = netPlanService.countNetPlanByQueryCondition(field, value);
        return new LayuiData(0, list, count);
    }

    @RequestMapping("mountNetPlan")
    public ModelAndView mountNetPlan(HttpServletRequest request, HttpServletResponse response) {

        return new ModelAndView("netplan/netplan_mount", "message",null);
    }

    @RequestMapping("mountNetPlanBody")
    public @ResponseBody LayuiData mountNetPlanBody(String field, String value, @RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
//        JOptionPane.showMessageDialog(null, field+"\n"+value, "标题", JOptionPane.PLAIN_MESSAGE);

        List list = netPlanService.getNetPlanByCondition(field.isEmpty()?"pi_id":field, value.isEmpty()?"-1":value, page, limit);
        long count = netPlanService.countNetPlanBySelectCondition(field.isEmpty()?"pi_id":field, value.isEmpty()?"-1":value);
        return new LayuiData(0, list, count);
    }

    @RequestMapping("mountCompanyBody")
    public @ResponseBody LayuiData mountCompanyBody(String field, String value, @RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
//        JOptionPane.showMessageDialog(null, field+"\n"+value, "标题", JOptionPane.PLAIN_MESSAGE);

        List<NetPlan> listNetPlan = netPlanService.getNetPlanByCondition(field.isEmpty()?"pi_id":field, value.isEmpty()?"-1":value, page, limit);
        long count = netPlanService.countNetPlanBySelectCondition(field.isEmpty()?"pi_id":field, value.isEmpty()?"-1":value);

        List list = new ArrayList();
        for(NetPlan x: listNetPlan) {
            if(x.getCompany() != null) {
                list.add(x.getCompany());
            }
        }
        return new LayuiData(0, list, count);
    }

    @RequestMapping("warnNetPlan")
    public ModelAndView warnNetPlan(HttpServletRequest request, HttpServletResponse response) {

        return new ModelAndView("netplan/netplan_warn", "message",null);
    }

    @RequestMapping("warnNetPlanBody")
    public @ResponseBody LayuiData warnNetPlanBody(Integer id, Integer level) {
//        JOptionPane.showMessageDialog(null, field+"\n"+value, "标题", JOptionPane.PLAIN_MESSAGE);

        List<NetPlan> listNetPlan = netPlanService.queryNetPlanByPiId(id);
        long count = listNetPlan.size();

        List<Map> list = new ArrayList<>();
        for(NetPlan x:listNetPlan) {
            PartItem pi = x.getPartItem();
            if(pi != null && pi.getPiLevel() > level) {
                pi.setPiFold(false);
            }

            list.add(x.toMap());
        }
        return new LayuiData(0, list, count);
    }
}

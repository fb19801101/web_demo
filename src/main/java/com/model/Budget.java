package com.model;

import com.dateutil.RegexUtil;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import net.sf.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 
 * 
 */
public class Budget implements Serializable {
    /**
     * 概算ID
     */
    private Integer bgId;

    /**
     * 清单ID
     */
    private Integer ctId;

    /**
     * 指导价ID
     */
    private Integer gdId;

    /**
     * 成本层ID
     */
    private Integer clId;

    /**
     * 清单编码
     */
    private String ctCode;

    /**
     * 定额编码
     */
    private String bgCode;

    /**
     * 指导价编码
     */
    private String gdCode;

    /**
     * 成本层编码
     */
    private String clCode;

    /**
     * 清单信息
     */
    private Contract contract;

    /**
     * 指导价信息
     */
    private Guidance guidance;

    /**
     * 成本呈
     */
    private CostLayer costLayer;

    /**
     * 细目名称
     */
    private String bgName;

    /**
     * 计量单位
     */
    private String bgUnit;

    /**
     * 单位比率
     */
    private Double bgRate;

    /**
     * 概算数量
     */
    private Double bgQty;

    /**
     * 概算单价
     */
    private Double bgPrice;

    /**
     * 概算合价
     */
    private Double bgMoney;

    /**
     * 概算备注
     */
    private String bgInfo;

    private static final long serialVersionUID = 1L;

    /**
     * 默认构造方法
     */
    public Budget() {
    }

    /**
     * 部分构造方法
     */
    public Budget(Integer bgId, String bgCode, Contract contract) {
        this.bgId = bgId;
        this.bgCode = bgCode;
        this.contract = contract;
        this.ctId = contract.getCtId();
        this.ctCode = contract.getCtCode();
    }

    public Budget(Integer bgId, String bgCode, Guidance guidance) {
        this.bgId = bgId;
        this.bgCode = bgCode;
        this.guidance = guidance;
        this.gdId = guidance.getGdId();
        this.bgCode = guidance.getGdCode();
    }

    public Budget(Integer bgId, String bgCode, CostLayer costLayer) {
        this.bgId = bgId;
        this.bgCode = bgCode;
        this.costLayer = costLayer;
        this.clId = costLayer.getClId();
        this.clCode = costLayer.getClCode();
    }

    public Budget(Integer bgId, String bgCode, Contract contract, Guidance guidance) {
        this.bgId = bgId;
        this.bgCode = bgCode;
        this.contract = contract;
        this.guidance = guidance;
        this.ctId = contract.getCtId();
        this.ctCode = contract.getCtCode();
        this.gdId = guidance.getGdId();
        this.bgCode = guidance.getGdCode();
    }

    public Budget(Integer bgId, String bgCode, Contract contract, CostLayer costLayer) {
        this.bgId = bgId;
        this.bgCode = bgCode;
        this.contract = contract;
        this.costLayer = costLayer;
        this.ctId = contract.getCtId();
        this.ctCode = contract.getCtCode();
        this.clId = costLayer.getClId();
        this.clCode = costLayer.getClCode();
    }

    public Budget(Integer bgId, String bgCode, Guidance guidance, CostLayer costLayer) {
        this.bgId = bgId;
        this.bgCode = bgCode;
        this.guidance = guidance;
        this.costLayer = costLayer;
        this.gdId = guidance.getGdId();
        this.bgCode = guidance.getGdCode();
        this.clId = costLayer.getClId();
        this.clCode = costLayer.getClCode();
    }

    public Budget(Integer bgId, String bgCode, Contract contract, Guidance guidance, CostLayer costLayer) {
        this.bgId = bgId;
        this.bgCode = bgCode;
        this.contract = contract;
        this.guidance = guidance;
        this.costLayer = costLayer;
        this.ctId = contract.getCtId();
        this.ctCode = contract.getCtCode();
        this.gdId = guidance.getGdId();
        this.bgCode = guidance.getGdCode();
        this.clId = costLayer.getClId();
        this.clCode = costLayer.getClCode();
    }

    /**
     * 完整构造方法
     */
    public Budget(Integer bgId, Integer ctId, Integer gdId, Integer clId, String ctCode, String bgCode, String gdCode, String clCode,
                  String bgName, String bgUnit, Double bgRate, Double bgQty, Double bgPrice, Double bgMoney, String bgInfo) {
        this.bgId = bgId;
        this.ctId = ctId;
        this.gdId = gdId;
        this.clId = clId;
        this.ctCode = ctCode;
        this.bgCode = bgCode;
        this.gdCode = gdCode;
        this.clCode = clCode;
        this.bgName = bgName;
        this.bgUnit = bgUnit;
        this.bgRate = bgRate;
        this.bgQty = bgQty;
        this.bgPrice = bgPrice;
        this.bgMoney = bgMoney;
        this.bgInfo = bgInfo;
    }
//
//    @JsonCreator
//    public Budget(@JsonProperty("bgId") Integer bgId, @JsonProperty("ctId") Integer ctId, @JsonProperty("gdId") Integer gdId, @JsonProperty("clId") Integer clId,
//                  @JsonProperty("ctCode") String ctCode, @JsonProperty("bgCode") String bgCode, @JsonProperty("gdCode") String gdCode, @JsonProperty("clCode") String clCode,
//                  @JsonProperty("bgName") String bgName, @JsonProperty("bgUnit") String bgUnit, @JsonProperty("bgRate") Double bgRate, @JsonProperty("bgQty") Double bgQty,
//                  @JsonProperty("bgPrice") Double bgPrice, @JsonProperty("bgMoney") Double bgMoney, @JsonProperty("bgInfo") String bgInfo) {
//        this.bgId = bgId;
//        this.ctId = ctId;
//        this.gdId = gdId;
//        this.clId = clId;
//        this.ctCode = ctCode;
//        this.bgCode = bgCode;
//        this.gdCode = gdCode;
//        this.clCode = clCode;
//        this.bgName = bgName;
//        this.bgUnit = bgUnit;
//        this.bgRate = bgRate;
//        this.bgQty = bgQty;
//        this.bgPrice = bgPrice;
//        this.bgMoney = bgMoney;
//        this.bgInfo = bgInfo;
//    }

    public Integer getBgId() {
        return bgId;
    }

    public void setBgId(Integer bgId) {
        this.bgId = bgId;
    }

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public Integer getGdId() {
        return gdId;
    }

    public void setGdId(Integer gdId) {
        this.gdId = gdId;
    }

    public Integer getClId() {
        return clId;
    }

    public void setClId(Integer clId) {
        this.clId = clId;
    }

    public String getCtCode() {
        return ctCode;
    }

    public void setCtCode(String ctCode) {
        this.ctCode = ctCode;
    }

    public String getBgCode() {
        return bgCode;
    }

    public void setBgCode(String bgCode) {
        this.bgCode = bgCode;
    }

    public String getGdCode() {
        return gdCode;
    }

    public void setGdCode(String gdCode) {
        this.gdCode = gdCode;
    }

    public String getClCode() {
        return clCode;
    }

    public void setClCode(String clCode) {
        this.clCode = clCode;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
        this.ctId = contract.getCtId();
        this.ctCode = contract.getCtCode();
    }

    public Guidance getGuidance() {
        return guidance;
    }

    public void setGuidance(Guidance guidance) {
        this.guidance = guidance;
        this.gdId = guidance.getGdId();
        this.gdCode = guidance.getGdCode();
    }

    public CostLayer getCostLayer() {
        return costLayer;
    }

    public void setCostLayer(CostLayer costLayer) {
        this.costLayer = costLayer;
        this.clId = costLayer.getClId();
        this.clCode = costLayer.getClCode();
    }

    public String getBgName() {
        return bgName;
    }

    public void setBgName(String bgName) {
        this.bgName = bgName;
    }

    public String getBgUnit() {
        return bgUnit;
    }

    public void setBgUnit(String bgUnit) {
        this.bgUnit = bgUnit;
    }

    public Double getBgRate() {
        return bgRate;
    }

    public void setBgRate(Double bgRate) {
        this.bgRate = bgRate;
    }

    public Double getBgQty() {
        return bgQty;
    }

    public void setBgQty(Double bgQty) {
        this.bgQty = bgQty;
    }

    public Double getBgPrice() {
        return bgPrice;
    }

    public void setBgPrice(Double bgPrice) {
        this.bgPrice = bgPrice;
    }

    public Double getBgMoney() {
        return bgMoney;
    }

    public void setBgMoney(Double bgMoney) {
        this.bgMoney = bgMoney;
    }

    public String getBgInfo() {
        return bgInfo;
    }

    public void setBgInfo(String bgInfo) {
        this.bgInfo = bgInfo;
    }

    public void setField(String field, Object value) {
        String _value = value.toString();
        if (field.equals("bgId")) {
            if(RegexUtil.isNumber(_value)) {
                bgId = Integer.parseInt(_value);
            }
        }
        if (field.equals("ctId")) {
            if(RegexUtil.isNumber(_value)) {
                ctId = Integer.parseInt(_value);
            }
        }
        if (field.equals("ctCode")) {
            ctCode = _value;
        }
        if (field.equals("contract")) {
            contract = (Contract)value;
        }
        if (field.equals("gdId")) {
            if(RegexUtil.isNumber(_value)) {
                gdId = Integer.parseInt(_value);
            }
        }
        if (field.equals("gdCode")) {
            gdCode = _value;
        }
        if (field.equals("guidance")) {
            guidance = (Guidance)value;
        }
        if (field.equals("clId")) {
            if(RegexUtil.isNumber(_value)) {
                clId = Integer.parseInt(_value);
            }
        }
        if (field.equals("clCode")) {
            clCode = _value;
        }
        if (field.equals("costLayer")) {
            costLayer = (CostLayer)value;
        }
        if (field.equals("bgCode")) {
            bgCode = _value;
        }
        if (field.equals("bgName")) {
            bgName = _value;
        }
        if (field.equals("bgUnit")) {
            bgUnit = _value;
        }
        if (field.equals("bgRate")) {
            if(RegexUtil.isNumber(_value)) {
                bgRate = Double.parseDouble(_value);
            }
        }
        if (field.equals("bgQty")) {
            if(RegexUtil.isNumber(_value)) {
                bgQty = Double.parseDouble(_value);
            }
        }
        if (field.equals("bgPrice")) {
            if(RegexUtil.isNumber(_value)) {
                bgPrice = Double.parseDouble(_value);
            }
        }
        if (field.equals("bgMoney")) {
            if(RegexUtil.isNumber(_value)) {
                bgMoney = Double.parseDouble(_value);
            }
        }
        if (field.equals("bgInfo")) {
            bgInfo = _value;
        }
    }

    public void setMap(Map map) {
        if (map.containsKey("bgId")) {
            String value = map.get("bgId").toString();
            if(RegexUtil.isNumber(value)) {
                bgId = Integer.parseInt(value);
            }
        }
        if (map.containsKey("ctId")) {
            String value = map.get("ctId").toString();
            if(RegexUtil.isNumber(value)) {
                ctId = Integer.parseInt(value);
            }
        }
        if (map.containsKey("ctCode")) {
            ctCode = map.get("ctCode").toString();
        }
        if (map.containsKey("contract")) {
            contract = (Contract) map.get("contract");
        }
        if (map.containsKey("gdId")) {
            String value = map.get("gdId").toString();
            if(RegexUtil.isNumber(value)) {
                gdId = Integer.parseInt(value);
            }
        }
        if (map.containsKey("gdCode")) {
            gdCode = map.get("gdCode").toString();
        }
        if (map.containsKey("guidance")) {
            guidance = (Guidance) map.get("guidance");
        }
        if (map.containsKey("clId")) {
            String value = map.get("clId").toString();
            if(RegexUtil.isNumber(value)) {
                clId = Integer.parseInt(value);
            }
        }
        if (map.containsKey("clCode")) {
            clCode = map.get("clCode").toString();
        }
        if (map.containsKey("costLayer")) {
            costLayer = (CostLayer) map.get("costLayer");
        }
        if (map.containsKey("bgCode")) {
            bgCode = map.get("bgCode").toString();
        }
        if (map.containsKey("bgName")) {
            bgName = map.get("bgName").toString();
        }
        if (map.containsKey("bgUnit")) {
            bgUnit = map.get("bgUnit").toString();
        }
        if (map.containsKey("bgRate")) {
            String value = map.get("bgRate").toString();
            if(RegexUtil.isNumber(value)) {
                bgRate = Double.parseDouble(value);
            }
        }
        if (map.containsKey("bgQty")) {
            String value = map.get("bgQty").toString();
            if(RegexUtil.isNumber(value)) {
                bgQty = Double.parseDouble(value);
            }
        }
        if (map.containsKey("bgPrice")) {
            String value = map.get("bgPrice").toString();
            if(RegexUtil.isNumber(value)) {
                bgPrice = Double.parseDouble(value);
            }
        }
        if (map.containsKey("bgMoney")) {
            String value = map.get("bgMoney").toString();
            if(RegexUtil.isNumber(value)) {
                bgMoney = Double.parseDouble(value);
            }
        }
        if (map.containsKey("bgInfo")) {
            bgInfo = map.get("bgInfo").toString();
        }
    }

    public void setJson(JSONObject json) {
        if (json.has("bgId")) {
            if(RegexUtil.isNumber(json.optString("bgId"))) {
                bgId = json.getInt("bgId");
            }
        }
        if (json.has("ctId")) {
            if(RegexUtil.isNumber(json.optString("ctId"))) {
                ctId = json.getInt("ctId");
            }
        }
        if (json.has("ctCode")) {
            ctCode = json.opt("ctCode").toString();
        }
        if (json.has("contract")) {
            contract = (Contract) json.opt("contract");
        }
        if (json.has("gdId")) {
            if(RegexUtil.isNumber(json.optString("gdId"))) {
                gdId = json.getInt("gdId");
            }
        }
        if (json.has("gdCode")) {
            gdCode = json.opt("gdCode").toString();
        }
        if (json.has("guidance")) {
            guidance = (Guidance) json.opt("guidance");
        }
        if (json.has("clId")) {
            if(RegexUtil.isNumber(json.optString("clId"))) {
                clId = json.getInt("clId");
            }
        }
        if (json.has("clCode")) {
            clCode = json.opt("clCode").toString();
        }
        if (json.has("costLayer")) {
            costLayer = (CostLayer) json.opt("costLayer");
        }
        if (json.has("bgCode")) {
            bgCode = json.opt("bgCode").toString();
        }
        if (json.has("bgName")) {
            bgName = json.opt("bgName").toString();
        }
        if (json.has("bgUnit")) {
            bgUnit = json.opt("bgUnit").toString();
        }
        if (json.has("bgRate")) {
            if(RegexUtil.isNumber(json.optString("bgRate"))) {
                bgRate = json.getDouble("bgRate");
            }
        }
        if (json.has("bgQty")) {
            if(RegexUtil.isNumber(json.optString("bgQty"))) {
                bgQty = json.getDouble("bgQty");
            }
        }
        if (json.has("bgPrice")) {
            if(RegexUtil.isNumber(json.optString("bgPrice"))) {
                bgPrice = json.getDouble("bgPrice");
            }
        }
        if (json.has("bgMoney")) {
            if(RegexUtil.isNumber(json.optString("bgMoney"))) {
                bgMoney = json.getDouble("bgMoney");
            }
        }
        if (json.has("bgInfo")) {
            bgInfo = json.opt("bgInfo").toString();
        }
    }

    public Map toMap() {
        Map map = new HashMap<>();
        if(bgId == null) {
            bgId = -1;
        }
        map.put("bgId", bgId);
        if(ctId == null) {
            ctId = -1;
        }
        map.put("ctId", ctId);
        map.put("ctCode", ctCode);
        map.put("contract", contract);
        if(contract != null) {
            map.put("ctId", contract.getCtId());
            map.put("ctPid", contract.getCtPid());
            map.put("ctLevel", contract.getCtLevel());
            map.put("ctCode", contract.getCtCode());
            map.put("ctName", contract.getCtName());
            map.put("ctFold", contract.getCtFold());
        } else {
            map.put("ctPid", 0);
            map.put("ctFold", true);
        }
        if(gdId == null) {
            gdId = -1;
        }
        map.put("gdId", gdId);
        map.put("gdCode", gdCode);
        map.put("guidance", guidance);
        if(clId == null) {
            clId = -1;
        }
        map.put("clId", clId);
        map.put("clCode", clCode);
        map.put("costLayer", costLayer);
        map.put("bgCode", bgCode);
        map.put("bgName", bgName);
        if(bgName != null) {
            map.put("ctCode", bgCode);
            map.put("ctName", bgName);
        }
        map.put("bgUnit", bgUnit);
        if(bgRate == null) {
            bgRate = -1.0;
        }
        map.put("bgRate", bgRate);
        if(bgQty == null) {
            bgQty = -1.0;
        }
        map.put("bgQty", bgQty);
        if(bgPrice == null) {
            bgPrice = -1.0;
        }
        map.put("bgPrice", bgPrice);
        if(bgMoney == null) {
            bgMoney = -1.0;
        }
        map.put("bgMoney", bgMoney);
        map.put("bgInfo", bgInfo);

        return map;
    }

    public Map toGuidanceMap() {
        Map map = new HashMap<>();
        if(bgId == null) {
            bgId = -1;
        }
        map.put("bgId", bgId);
        if(ctId == null) {
            ctId = -1;
        }
        map.put("ctId", ctId);
        map.put("ctCode", ctCode);
        map.put("contract", contract);
        if(contract != null) {
            map.put("ctId", contract.getCtId());
            map.put("ctPid", contract.getCtPid());
            map.put("ctLevel", contract.getCtLevel());
            map.put("ctCode", contract.getCtCode());
            map.put("ctName", contract.getCtName());
            map.put("gdCode", contract.getCtCode());
            map.put("gdName", contract.getCtName());
            map.put("ctFold", contract.getCtFold());
        } else {
            map.put("ctPid", 0);
            map.put("ctFold", true);
        }
        if(gdId == null) {
            gdId = -1;
        }
        map.put("gdId", gdId);
        map.put("gdCode", gdCode);
        map.put("guidance", guidance);
        if(guidance != null) {
            map.put("gdId", guidance.getGdId());
            map.put("gdCode", guidance.getGdCode());
            map.put("gdLabel", guidance.getGdLabel());
            map.put("gdName", guidance.getGdName());
            map.put("gdUnit", guidance.getGdUnit());
            map.put("gdRate", guidance.getGdRate());
            map.put("gdPrice", guidance.getGdPrice());
            map.put("gdItem", guidance.getGdItem());
            map.put("gdWork", guidance.getGdWork());
            map.put("gdCost", guidance.getGdCost());
            map.put("gdRole", guidance.getGdRole());
            map.put("gdInfo", guidance.getGdInfo());
        }

        return map;
    }

    public Map toCostLayerMap() {
        Map map = new HashMap<>();
        if(bgId == null) {
            bgId = -1;
        }
        map.put("bgId", bgId);
        if(ctId == null) {
            ctId = -1;
        }
        map.put("ctId", ctId);
        map.put("ctCode", ctCode);
        map.put("contract", contract);
        if(contract != null) {
            map.put("ctId", contract.getCtId());
            map.put("ctPid", contract.getCtPid());
            map.put("ctLevel", contract.getCtLevel());
            map.put("ctCode", contract.getCtCode());
            map.put("ctName", contract.getCtName());
            map.put("clCode", contract.getCtCode());
            map.put("clName", contract.getCtName());
            map.put("ctFold", contract.getCtFold());
        } else {
            map.put("ctPid", 0);
            map.put("ctFold", true);
        }
        if(clId == null) {
            clId = -1;
        }
        map.put("clId", clId);
        map.put("clCode", clCode);
        map.put("costLayer", costLayer);
        if(costLayer != null) {
            map.put("clId", costLayer.getClId());
            map.put("clCode", costLayer.getClCode());
            map.put("clType", costLayer.getClType());
            map.put("clName", costLayer.getClName());
            map.put("clUnit", costLayer.getClUnit());
            map.put("clBudget", costLayer.getClBudget());
            map.put("clDwgDesign", costLayer.getClDwgDesign());
            map.put("clDwgChange", costLayer.getClDwgChange());
            map.put("clChkDesign", costLayer.getClChkDesign());
            map.put("clChkChange", costLayer.getClChkChange());
            map.put("clActDesign", costLayer.getClActDesign());
            map.put("clActChange", costLayer.getClActChange());
            map.put("clDoDesign", costLayer.getClDoDesign());
            map.put("clDoChange", costLayer.getClDoChange());
            map.put("clUpDesign", costLayer.getClUpDesign());
            map.put("clUpChange", costLayer.getClUpChange());
            map.put("clDownDesign", costLayer.getClDwgDesign());
            map.put("clDownChange", costLayer.getClDownChange());
            map.put("clInfo", costLayer.getClInfo());
        }

        return map;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        if(bgId == null) {
            bgId = -1;
        }
        json.put("bgId", bgId);
        if(ctId == null) {
            ctId = -1;
        }
        json.put("ctId", ctId);
        json.put("ctCode", ctCode);
        json.put("contract", contract);
        if(gdId == null) {
            gdId = -1;
        }
        json.put("gdId", gdId);
        json.put("gdCode", gdCode);
        json.put("guidance", guidance);
        if(clId == null) {
            clId = -1;
        }
        json.put("clId", clId);
        json.put("clCode", clCode);
        json.put("costLayer", costLayer);
        json.put("bgCode", bgCode);
        json.put("bgName", bgName);
        json.put("bgUnit", bgUnit);
        if(bgRate == null) {
            bgRate = -1.0;
        }
        json.put("bgRate", bgRate);
        if(bgQty == null) {
            bgQty = -1.0;
        }
        json.put("bgQty", bgQty);
        if(bgPrice == null) {
            bgPrice = -1.0;
        }
        json.put("bgPrice", bgPrice);
        if(bgMoney == null) {
            bgMoney = -1.0;
        }
        json.put("bgMoney", bgMoney);
        json.put("bgInfo", bgInfo);

        return json;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Budget other = (Budget) that;
        return (this.getBgId() == null ? other.getBgId() == null : this.getBgId().equals(other.getBgId()))
            && (this.getCtId() == null ? other.getCtId() == null : this.getCtId().equals(other.getCtId()))
            && (this.getGdId() == null ? other.getGdId() == null : this.getGdId().equals(other.getGdId()))
            && (this.getClId() == null ? other.getClId() == null : this.getClId().equals(other.getClId()))
            && (this.getCtCode() == null ? other.getCtCode() == null : this.getCtCode().equals(other.getCtCode()))
            && (this.getContract() == null ? other.getContract() == null : this.getContract().equals(other.getContract()))
            && (this.getBgCode() == null ? other.getBgCode() == null : this.getBgCode().equals(other.getBgCode()))
            && (this.getGdCode() == null ? other.getGdCode() == null : this.getGdCode().equals(other.getGdCode()))
            && (this.getGuidance() == null ? other.getGuidance() == null : this.getGuidance().equals(other.getGuidance()))
            && (this.getClCode() == null ? other.getClCode() == null : this.getClCode().equals(other.getClCode()))
            && (this.getCostLayer() == null ? other.getCostLayer() == null : this.getCostLayer().equals(other.getCostLayer()))
            && (this.getBgName() == null ? other.getBgName() == null : this.getBgName().equals(other.getBgName()))
            && (this.getBgUnit() == null ? other.getBgUnit() == null : this.getBgUnit().equals(other.getBgUnit()))
            && (this.getBgRate() == null ? other.getBgRate() == null : this.getBgRate().equals(other.getBgRate()))
            && (this.getBgQty() == null ? other.getBgQty() == null : this.getBgQty().equals(other.getBgQty()))
            && (this.getBgPrice() == null ? other.getBgPrice() == null : this.getBgPrice().equals(other.getBgPrice()))
            && (this.getBgMoney() == null ? other.getBgMoney() == null : this.getBgMoney().equals(other.getBgMoney()))
            && (this.getBgInfo() == null ? other.getBgInfo() == null : this.getBgInfo().equals(other.getBgInfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBgId() == null) ? 0 : getBgId().hashCode());
        result = prime * result + ((getCtId() == null) ? 0 : getCtId().hashCode());
        result = prime * result + ((getGdId() == null) ? 0 : getGdId().hashCode());
        result = prime * result + ((getClId() == null) ? 0 : getClId().hashCode());
        result = prime * result + ((getCtCode() == null) ? 0 : getCtCode().hashCode());
        result = prime * result + ((getContract() == null) ? 0 : getContract().hashCode());
        result = prime * result + ((getBgCode() == null) ? 0 : getBgCode().hashCode());
        result = prime * result + ((getGdCode() == null) ? 0 : getGdCode().hashCode());
        result = prime * result + ((getGuidance() == null) ? 0 : getGuidance().hashCode());
        result = prime * result + ((getClCode() == null) ? 0 : getClCode().hashCode());
        result = prime * result + ((getCostLayer() == null) ? 0 : getCostLayer().hashCode());
        result = prime * result + ((getBgName() == null) ? 0 : getBgName().hashCode());
        result = prime * result + ((getBgUnit() == null) ? 0 : getBgUnit().hashCode());
        result = prime * result + ((getBgRate() == null) ? 0 : getBgRate().hashCode());
        result = prime * result + ((getBgQty() == null) ? 0 : getBgQty().hashCode());
        result = prime * result + ((getBgPrice() == null) ? 0 : getBgPrice().hashCode());
        result = prime * result + ((getBgMoney() == null) ? 0 : getBgMoney().hashCode());
        result = prime * result + ((getBgInfo() == null) ? 0 : getBgInfo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bgId=").append(bgId);
        sb.append(", ctId=").append(ctId);
        sb.append(", gdId=").append(gdId);
        sb.append(", clId=").append(clId);
        sb.append(", ctCode=").append(ctCode);
        sb.append(", contract=").append(contract);
        sb.append(", bgCode=").append(bgCode);
        sb.append(", gdCode=").append(gdCode);
        sb.append(", guidance=").append(guidance);
        sb.append(", clCode=").append(clCode);
        sb.append(", costLayer=").append(costLayer);
        sb.append(", bgName=").append(bgName);
        sb.append(", bgUnit=").append(bgUnit);
        sb.append(", bgRate=").append(bgRate);
        sb.append(", bgQty=").append(bgQty);
        sb.append(", bgPrice=").append(bgPrice);
        sb.append(", bgMoney=").append(bgMoney);
        sb.append(", bgInfo=").append(bgInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
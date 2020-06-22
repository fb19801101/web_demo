package com.model;

import com.dateutil.DateConverter;
import com.dateutil.RegexUtil;
import net.sf.json.JSONObject;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 
 * 
 */
public class CostLayer implements Serializable {
    /**
     * 成本层ID
     */
    private Integer clId;

    /**
     * 成本层编码
     */
    private String clCode;

    /**
     * 成本层类别
     */
    private String clType;

    /**
     * 成本层名称
     */
    private String clName;

    /**
     * 数量计量单位
     */
    private String clUnit;

    /**
     * 分项概算数量
     */
    private Double clBudget;

    /**
     * 图纸设计数量
     */
    private Double clDwgDesign;

    /**
     * 图纸变更数量
     */
    private Double clDwgChange;

    /**
     * 复核图纸数量
     */
    private Double clChkDesign;

    /**
     * 复核变更数量
     */
    private Double clChkChange;

    /**
     * 现场设计数量
     */
    private Double clActDesign;

    /**
     * 现场变更数量
     */
    private Double clActChange;

    /**
     * 已完设计数量
     */
    private Double clDoDesign;

    /**
     * 已完变更数量
     */
    private Double clDoChange;

    /**
     * 对上计价设计数量
     */
    private Double clUpDesign;

    /**
     * 对上计价变更数量
     */
    private Double clUpChange;

    /**
     * 对下计价设计数量
     */
    private Double clDownDesign;

    /**
     * 对下计价变更数量
     */
    private Double clDownChange;

    /**
     * 成本层备注
     */
    private String clInfo;

    private static final long serialVersionUID = 1L;

    /**
     * 默认构造方法
     */
    public CostLayer() {
    }

    /**
     * 完整构造方法
     */
    public CostLayer(Integer clId, String clCode, String clType, String clName, String clUnit,
                     Double clBudget, Double clDwgDesign, Double clDwgChange, Double clChkDesign,
                     Double clChkChange, Double clActDesign, Double clActChange, Double clDoDesign,
                     Double clDoChange, Double clUpDesign, Double clUpChange, Double clDownDesign,
                     Double clDownChange, String clInfo) {
        this.clId = clId;
        this.clCode = clCode;
        this.clType = clType;
        this.clName = clName;
        this.clUnit = clUnit;
        this.clBudget = clBudget;
        this.clDwgDesign = clDwgDesign;
        this.clDwgChange = clDwgChange;
        this.clChkDesign = clChkDesign;
        this.clChkChange = clChkChange;
        this.clActDesign = clActDesign;
        this.clActChange = clActChange;
        this.clDoDesign = clDoDesign;
        this.clDoChange = clDoChange;
        this.clUpDesign = clUpDesign;
        this.clUpChange = clUpChange;
        this.clDownDesign = clDownDesign;
        this.clDownChange = clDownChange;
        this.clInfo = clInfo;
    }
//
//    @JsonCreator
//    public CostLayer(@JsonProperty("clId") Integer clId, @JsonProperty("clCode") String clCode, @JsonProperty("clType") String clType, @JsonProperty("clName") String clName, @JsonProperty("clUnit") String clUnit,
//                     @JsonProperty("clBudget") Double clBudget, @JsonProperty("clDwgDesign") Double clDwgDesign, @JsonProperty("clDwgChange") Double clDwgChange, @JsonProperty("clChkDesign") Double clChkDesign,
//                     @JsonProperty("clChkChange") Double clChkChange, @JsonProperty("clActDesign") Double clActDesign, @JsonProperty("clActChange") Double clActChange, @JsonProperty("clDoDesign") Double clDoDesign,
//                     @JsonProperty("clDoChange") Double clDoChange, @JsonProperty("clUpDesign") Double clUpDesign, @JsonProperty("clUpChange") Double clUpChange, @JsonProperty("clDownDesign") Double clDownDesign,
//                     @JsonProperty("clDownChange") Double clDownChange, @JsonProperty("clInfo") String clInfo) {
//        this.clId = clId;
//        this.clCode = clCode;
//        this.clType = clType;
//        this.clName = clName;
//        this.clUnit = clUnit;
//        this.clBudget = clBudget;
//        this.clDwgDesign = clDwgDesign;
//        this.clDwgChange = clDwgChange;
//        this.clChkDesign = clChkDesign;
//        this.clChkChange = clChkChange;
//        this.clActDesign = clActDesign;
//        this.clActChange = clActChange;
//        this.clDoDesign = clDoDesign;
//        this.clDoChange = clDoChange;
//        this.clUpDesign = clUpDesign;
//        this.clUpChange = clUpChange;
//        this.clDownDesign = clDownDesign;
//        this.clDownChange = clDownChange;
//        this.clInfo = clInfo;
//    }

    public Integer getClId() {
        return clId;
    }

    public void setClId(Integer clId) {
        this.clId = clId;
    }

    public String getClCode() {
        return clCode;
    }

    public void setClCode(String clCode) {
        this.clCode = clCode;
    }

    public String getClType() {
        return clType;
    }

    public void setClType(String clType) {
        this.clType = clType;
    }

    public String getClName() {
        return clName;
    }

    public void setClName(String clName) {
        this.clName = clName;
    }

    public String getClUnit() {
        return clUnit;
    }

    public void setClUnit(String clUnit) {
        this.clUnit = clUnit;
    }

    public Double getClBudget() {
        return clBudget;
    }

    public void setClBudget(Double clBudget) {
        this.clBudget = clBudget;
    }

    public Double getClDwgDesign() {
        return clDwgDesign;
    }

    public void setClDwgDesign(Double clDwgDesign) {
        this.clDwgDesign = clDwgDesign;
    }

    public Double getClDwgChange() {
        return clDwgChange;
    }

    public void setClDwgChange(Double clDwgChange) {
        this.clDwgChange = clDwgChange;
    }

    public Double getClChkDesign() {
        return clChkDesign;
    }

    public void setClChkDesign(Double clChkDesign) {
        this.clChkDesign = clChkDesign;
    }

    public Double getClChkChange() {
        return clChkChange;
    }

    public void setClChkChange(Double clChkChange) {
        this.clChkChange = clChkChange;
    }

    public Double getClActDesign() {
        return clActDesign;
    }

    public void setClActDesign(Double clActDesign) {
        this.clActDesign = clActDesign;
    }

    public Double getClActChange() {
        return clActChange;
    }

    public void setClActChange(Double clActChange) {
        this.clActChange = clActChange;
    }

    public Double getClDoDesign() {
        return clDoDesign;
    }

    public void setClDoDesign(Double clDoDesign) {
        this.clDoDesign = clDoDesign;
    }

    public Double getClDoChange() {
        return clDoChange;
    }

    public void setClDoChange(Double clDoChange) {
        this.clDoChange = clDoChange;
    }

    public Double getClUpDesign() {
        return clUpDesign;
    }

    public void setClUpDesign(Double clUpDesign) {
        this.clUpDesign = clUpDesign;
    }

    public Double getClUpChange() {
        return clUpChange;
    }

    public void setClUpChange(Double clUpChange) {
        this.clUpChange = clUpChange;
    }

    public Double getClDownDesign() {
        return clDownDesign;
    }

    public void setClDownDesign(Double clDownDesign) {
        this.clDownDesign = clDownDesign;
    }

    public Double getClDownChange() {
        return clDownChange;
    }

    public void setClDownChange(Double clDownChange) {
        this.clDownChange = clDownChange;
    }

    public String getClInfo() {
        return clInfo;
    }

    public void setClInfo(String clInfo) {
        this.clInfo = clInfo;
    }

    public void setField(String field, Object value) {
        String _value = value.toString();
        if (field.equals("clId")) {
            if(RegexUtil.isNumber(_value)) {
                clId = Integer.parseInt(_value);
            }
        }
        if (field.equals("clCode")) {
            clCode = _value;
        }
        if (field.equals("clType")) {
            clType = _value;
        }
        if (field.equals("clName")) {
            clName = _value;
        }
        if (field.equals("clUnit")) {
            clUnit = _value;
        }
        if (field.equals("clBudget")) {
            if(RegexUtil.isNumber(_value)) {
                clBudget = Double.parseDouble(_value);
            }
        }
        if (field.equals("clDwgDesign")) {
            if(RegexUtil.isNumber(_value)) {
                clDwgDesign = Double.parseDouble(_value);
            }
        }
        if (field.equals("clDwgChange")) {
            if(RegexUtil.isNumber(_value)) {
                clDwgChange = Double.parseDouble(_value);
            }
        }
        if (field.equals("clChkDesign")) {
            if(RegexUtil.isNumber(_value)) {
                clChkDesign = Double.parseDouble(_value);
            }
        }
        if (field.equals("clChkChange")) {
            if(RegexUtil.isNumber(_value)) {
                clChkChange = Double.parseDouble(_value);
            }
        }
        if (field.equals("clActDesign")) {
            if(RegexUtil.isNumber(_value)) {
                clActDesign = Double.parseDouble(_value);
            }
        }
        if (field.equals("clActChange")) {
            if(RegexUtil.isNumber(_value)) {
                clActChange = Double.parseDouble(_value);
            }
        }
        if (field.equals("clDoDesign")) {
            if(RegexUtil.isNumber(_value)) {
                clDoDesign = Double.parseDouble(_value);
            }
        }
        if (field.equals("clDoChange")) {
            if(RegexUtil.isNumber(_value)) {
                clDoChange = Double.parseDouble(_value);
            }
        }
        if (field.equals("clUpDesign")) {
            if(RegexUtil.isNumber(_value)) {
                clUpDesign = Double.parseDouble(_value);
            }
        }
        if (field.equals("clUpChange")) {
            if(RegexUtil.isNumber(_value)) {
                clUpChange = Double.parseDouble(_value);
            }
        }
        if (field.equals("clDownDesign")) {
            if(RegexUtil.isNumber(_value)) {
                clDownDesign = Double.parseDouble(_value);
            }
        }
        if (field.equals("clDownChange")) {
            if(RegexUtil.isNumber(_value)) {
                clDownChange = Double.parseDouble(_value);
            }
        }
        if (field.equals("clInfo")) {
            clInfo = _value;
        }
    }

    public void setMap(Map map) {
        if (map.containsKey("clId")) {
            String value = map.get("clId").toString();
            if(RegexUtil.isNumber(value)) {
                clId = Integer.parseInt(value);
            }
        }
        if (map.containsKey("clCode")) {
            clCode = map.get("clCode").toString();
        }
        if (map.containsKey("clType")) {
            clType = map.get("clType").toString();
        }
        if (map.containsKey("clName")) {
            clName = map.get("clName").toString();
        }
        if (map.containsKey("clUnit")) {
            clUnit = map.get("clUnit").toString();
        }
        if (map.containsKey("clBudget")) {
            String value = map.get("clBudget").toString();
            if(RegexUtil.isNumber(value)) {
                clBudget = Double.parseDouble(value);
            }
        }
        if (map.containsKey("clDwgDesign")) {
            String value = map.get("clDwgDesign").toString();
            if(RegexUtil.isNumber(value)) {
                clDwgDesign = Double.parseDouble(value);
            }
        }
        if (map.containsKey("clDwgChange")) {
            String value = map.get("clDwgChange").toString();
            if(RegexUtil.isNumber(value)) {
                clDwgChange = Double.parseDouble(value);
            }
        }
        if (map.containsKey("clChkDesign")) {
            String value = map.get("clChkDesign").toString();
            if(RegexUtil.isNumber(value)) {
                clChkDesign = Double.parseDouble(value);
            }
        }
        if (map.containsKey("clChkChange")) {
            String value = map.get("clChkChange").toString();
            if(RegexUtil.isNumber(value)) {
                clChkChange = Double.parseDouble(value);
            }
        }
        if (map.containsKey("clActDesign")) {
            String value = map.get("clActDesign").toString();
            if(RegexUtil.isNumber(value)) {
                clActDesign = Double.parseDouble(value);
            }
        }
        if (map.containsKey("clActChange")) {
            String value = map.get("clActChange").toString();
            if(RegexUtil.isNumber(value)) {
                clActChange = Double.parseDouble(value);
            }
        }
        if (map.containsKey("clDoDesign")) {
            String value = map.get("clDoDesign").toString();
            if(RegexUtil.isNumber(value)) {
                clDoDesign = Double.parseDouble(value);
            }
        }
        if (map.containsKey("clDoChange")) {
            String value = map.get("clDoChange").toString();
            if(RegexUtil.isNumber(value)) {
                clDoChange = Double.parseDouble(value);
            }
        }
        if (map.containsKey("clUpDesign")) {
            String value = map.get("clUpDesign").toString();
            if(RegexUtil.isNumber(value)) {
                clUpDesign = Double.parseDouble(value);
            }
        }
        if (map.containsKey("clUpChange")) {
            String value = map.get("clUpChange").toString();
            if(RegexUtil.isNumber(value)) {
                clUpChange = Double.parseDouble(value);
            }
        }
        if (map.containsKey("clDownDesign")) {
            String value = map.get("clDownDesign").toString();
            if(RegexUtil.isNumber(value)) {
                clDownDesign = Double.parseDouble(value);
            }
        }
        if (map.containsKey("clDownChange")) {
            String value = map.get("clDownChange").toString();
            if(RegexUtil.isNumber(value)) {
                clDownChange = Double.parseDouble(value);
            }
        }
        if (map.containsKey("clInfo")) {
            clInfo = map.get("clInfo").toString();
        }
    }

    public void setJson(JSONObject json) {
        if (json.has("clId")) {
            if(RegexUtil.isNumber(json.optString("clId"))) {
                clId = json.optInt("clId");
            }
        }
        if (json.has("clCode")) {
            clCode = json.optString("clCode");
        }
        if (json.has("clType")) {
            clType = json.optString("clType");
        }
        if (json.has("clName")) {
            clName = json.optString("clName");
        }
        if (json.has("clUnit")) {
            clUnit = json.optString("clUnit");
        }
        if (json.has("clBudget")) {
            if(RegexUtil.isNumber(json.optString("clBudget"))) {
                clBudget = json.optDouble("clBudget");
            }
        }
        if (json.has("clDwgDesign")) {
            if(RegexUtil.isNumber(json.optString("clDwgDesign"))) {
                clDwgDesign = json.optDouble("clDwgDesign");
            }
        }
        if (json.has("clDwgChange")) {
            if(RegexUtil.isNumber(json.optString("clDwgChange"))) {
                clDwgChange = json.optDouble("clDwgChange");
            }
        }
        if (json.has("clChkDesign")) {
            if(RegexUtil.isNumber(json.optString("clChkDesign"))) {
                clChkDesign = json.optDouble("clChkDesign");
            }
        }
        if (json.has("clChkChange")) {
            if(RegexUtil.isNumber(json.optString("clChkChange"))) {
                clChkChange = json.optDouble("clChkChange");
            }
        }
        if (json.has("clActDesign")) {
            if(RegexUtil.isNumber(json.optString("clActDesign"))) {
                clActDesign = json.optDouble("clActDesign");
            }
        }
        if (json.has("clActChange")) {
            if(RegexUtil.isNumber(json.optString("clActChange"))) {
                clActChange = json.optDouble("clActChange");
            }
        }
        if (json.has("clDoDesign")) {
            if(RegexUtil.isNumber(json.optString("clDoDesign"))) {
                clDoDesign = json.optDouble("clDoDesign");
            }
        }
        if (json.has("clDoChange")) {
            if(RegexUtil.isNumber(json.optString("clDoChange"))) {
                clDoChange = json.optDouble("clDoChange");
            }
        }
        if (json.has("clUpDesign")) {
            if(RegexUtil.isNumber(json.optString("clUpDesign"))) {
                clUpDesign = json.optDouble("clUpDesign");
            }
        }
        if (json.has("clUpChange")) {
            if(RegexUtil.isNumber(json.optString("clUpChange"))) {
                clUpChange = json.optDouble("clUpChange");
            }
        }
        if (json.has("clDownDesign")) {
            if(RegexUtil.isNumber(json.optString("clDownDesign"))) {
                clDownDesign = json.optDouble("clDownDesign");
            }
        }
        if (json.has("clDownChange")) {
            if(RegexUtil.isNumber(json.optString("clDownChange"))) {
                clDownChange = json.optDouble("clDownChange");
            }
        }
        if (json.has("clInfo")) {
            clInfo = json.optString("clInfo");
        }
    }

    public Map toMap() {
        Map map = new HashMap<>();
        if(clId == null) {
            clId = -1;
        }
        map.put("clId", clId);
        map.put("clCode", clCode);
        map.put("clType", clType);
        map.put("clName", clName);
        map.put("clUnit", clUnit);
        if(clBudget == null) {
            clBudget = -1.0;
        }
        map.put("clBudget", clBudget);
        if(clDwgDesign == null) {
            clDwgDesign = -1.0;
        }
        map.put("clDwgDesign", clDwgDesign);
        if(clDwgChange == null) {
            clDwgChange = -1.0;
        }
        map.put("clDwgChange", clDwgChange);
        if(clChkDesign == null) {
            clChkDesign = -1.0;
        }
        map.put("clChkDesign", clChkDesign);
        if(clChkChange == null) {
            clChkChange = -1.0;
        }
        map.put("clChkChange", clChkChange);
        if(clActDesign == null) {
            clActDesign = -1.0;
        }
        map.put("clActDesign", clActDesign);
        if(clActChange == null) {
            clActChange = -1.0;
        }
        map.put("clActChange", clActChange);
        if(clDoDesign == null) {
            clDoDesign = -1.0;
        }
        map.put("clDoDesign", clDoDesign);
        if(clDoChange == null) {
            clDoChange = -1.0;
        }
        map.put("clDoChange", clDoChange);
        if(clUpDesign == null) {
            clUpDesign = -1.0;
        }
        map.put("clUpDesign", clUpDesign);
        if(clUpChange == null) {
            clUpChange = -1.0;
        }
        map.put("clUpChange", clUpChange);
        if(clDownDesign == null) {
            clDownDesign = -1.0;
        }
        map.put("clDownDesign", clDownDesign);
        if(clDownChange == null) {
            clDownChange = -1.0;
        }
        map.put("clDownChange", clDownChange);
        map.put("clInfo", clInfo);

        return map;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        if(clId == null) {
            clId = -1;
        }
        json.put("clId", clId);
        json.put("clCode", clCode);
        json.put("clType", clType);
        json.put("clName", clName);
        json.put("clUnit", clUnit);
        if(clBudget == null) {
            clBudget = -1.0;
        }
        json.put("clBudget", clBudget);
        if(clDwgDesign == null) {
            clDwgDesign = -1.0;
        }
        json.put("clDwgDesign", clDwgDesign);
        if(clDwgChange == null) {
            clDwgChange = -1.0;
        }
        json.put("clDwgChange", clDwgChange);
        if(clChkDesign == null) {
            clChkDesign = -1.0;
        }
        json.put("clChkDesign", clChkDesign);
        if(clChkChange == null) {
            clChkChange = -1.0;
        }
        json.put("clChkChange", clChkChange);
        if(clActDesign == null) {
            clActDesign = -1.0;
        }
        json.put("clActDesign", clActDesign);
        if(clActChange == null) {
            clActChange = -1.0;
        }
        json.put("clActChange", clActChange);
        if(clDoDesign == null) {
            clDoDesign = -1.0;
        }
        json.put("clDoDesign", clDoDesign);
        if(clDoChange == null) {
            clDoChange = -1.0;
        }
        json.put("clDoChange", clDoChange);
        if(clUpDesign == null) {
            clUpDesign = -1.0;
        }
        json.put("clUpDesign", clUpDesign);
        if(clUpChange == null) {
            clUpChange = -1.0;
        }
        json.put("clUpChange", clUpChange);
        if(clDownDesign == null) {
            clDownDesign = -1.0;
        }
        json.put("clDownDesign", clDownDesign);
        if(clDownChange == null) {
            clDownChange = -1.0;
        }
        json.put("clDownChange", clDownChange);
        json.put("clInfo", clInfo);

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
        CostLayer other = (CostLayer) that;
        return (this.getClId() == null ? other.getClId() == null : this.getClId().equals(other.getClId()))
                && (this.getClCode() == null ? other.getClCode() == null : this.getClCode().equals(other.getClCode()))
                && (this.getClType() == null ? other.getClType() == null : this.getClType().equals(other.getClType()))
                && (this.getClName() == null ? other.getClName() == null : this.getClName().equals(other.getClName()))
                && (this.getClUnit() == null ? other.getClUnit() == null : this.getClUnit().equals(other.getClUnit()))
                && (this.getClBudget() == null ? other.getClBudget() == null : this.getClBudget().equals(other.getClBudget()))
                && (this.getClDwgDesign() == null ? other.getClDwgDesign() == null : this.getClDwgDesign().equals(other.getClDwgDesign()))
                && (this.getClDwgChange() == null ? other.getClDwgChange() == null : this.getClDwgChange().equals(other.getClDwgChange()))
                && (this.getClChkDesign() == null ? other.getClChkDesign() == null : this.getClChkDesign().equals(other.getClChkDesign()))
                && (this.getClChkChange() == null ? other.getClChkChange() == null : this.getClChkChange().equals(other.getClChkChange()))
                && (this.getClActDesign() == null ? other.getClActDesign() == null : this.getClActDesign().equals(other.getClActDesign()))
                && (this.getClActChange() == null ? other.getClActChange() == null : this.getClActChange().equals(other.getClActChange()))
                && (this.getClDoDesign() == null ? other.getClDoDesign() == null : this.getClDoDesign().equals(other.getClDoDesign()))
                && (this.getClDoChange() == null ? other.getClDoChange() == null : this.getClDoChange().equals(other.getClDoChange()))
                && (this.getClUpDesign() == null ? other.getClUpDesign() == null : this.getClUpDesign().equals(other.getClUpDesign()))
                && (this.getClUpChange() == null ? other.getClUpChange() == null : this.getClUpChange().equals(other.getClUpChange()))
                && (this.getClDownDesign() == null ? other.getClDownDesign() == null : this.getClDownDesign().equals(other.getClDownDesign()))
                && (this.getClDownChange() == null ? other.getClDownChange() == null : this.getClDownChange().equals(other.getClDownChange()))
                && (this.getClInfo() == null ? other.getClInfo() == null : this.getClInfo().equals(other.getClInfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getClId() == null) ? 0 : getClId().hashCode());
        result = prime * result + ((getClCode() == null) ? 0 : getClCode().hashCode());
        result = prime * result + ((getClType() == null) ? 0 : getClType().hashCode());
        result = prime * result + ((getClName() == null) ? 0 : getClName().hashCode());
        result = prime * result + ((getClUnit() == null) ? 0 : getClUnit().hashCode());
        result = prime * result + ((getClBudget() == null) ? 0 : getClBudget().hashCode());
        result = prime * result + ((getClDwgDesign() == null) ? 0 : getClDwgDesign().hashCode());
        result = prime * result + ((getClDwgChange() == null) ? 0 : getClDwgChange().hashCode());
        result = prime * result + ((getClChkDesign() == null) ? 0 : getClChkDesign().hashCode());
        result = prime * result + ((getClChkChange() == null) ? 0 : getClChkChange().hashCode());
        result = prime * result + ((getClActDesign() == null) ? 0 : getClActDesign().hashCode());
        result = prime * result + ((getClActChange() == null) ? 0 : getClActChange().hashCode());
        result = prime * result + ((getClDoDesign() == null) ? 0 : getClDoDesign().hashCode());
        result = prime * result + ((getClDoChange() == null) ? 0 : getClDoChange().hashCode());
        result = prime * result + ((getClUpDesign() == null) ? 0 : getClUpDesign().hashCode());
        result = prime * result + ((getClUpChange() == null) ? 0 : getClUpChange().hashCode());
        result = prime * result + ((getClDownDesign() == null) ? 0 : getClDownDesign().hashCode());
        result = prime * result + ((getClDownChange() == null) ? 0 : getClDownChange().hashCode());
        result = prime * result + ((getClInfo() == null) ? 0 : getClInfo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", clId=").append(clId);
        sb.append(", clCode=").append(clCode);
        sb.append(", clType=").append(clType);
        sb.append(", clName=").append(clName);
        sb.append(", clUnit=").append(clUnit);
        sb.append(", clBudget=").append(clBudget);
        sb.append(", clDwgDesign=").append(clDwgDesign);
        sb.append(", clDwgChange=").append(clDwgChange);
        sb.append(", clChkDesign=").append(clChkDesign);
        sb.append(", clChkChange=").append(clChkChange);
        sb.append(", clActDesign=").append(clActDesign);
        sb.append(", clActChange=").append(clActChange);
        sb.append(", clDoDesign=").append(clDoDesign);
        sb.append(", clDoChange=").append(clDoChange);
        sb.append(", clUpDesign=").append(clUpDesign);
        sb.append(", clUpChange=").append(clUpChange);
        sb.append(", clDownDesign=").append(clDownDesign);
        sb.append(", clDownChange=").append(clDownChange);
        sb.append(", clInfo=").append(clInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
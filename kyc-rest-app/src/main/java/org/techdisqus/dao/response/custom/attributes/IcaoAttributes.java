
package org.techdisqus.dao.response.custom.attributes;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "icaoBgUniformity",
    "icaoBgUniformityMax",
    "icaoBgUniformityMin",
    "icaoBrightness",
    "icaoBrightnessMax",
    "icaoBrightnessMin",
    "icaoColorProfile",
    "icaoColorProfileMax",
    "icaoColorProfileMin",
    "icaoCompilance",
    "icaoContrast",
    "icaoContrastMax",
    "icaoContrastMin",
    "icaoEyeDistance",
    "icaoEyeDistanceMax",
    "icaoEyeDistanceMin",
    "icaoEyeGaze",
    "icaoEyeGazeMax",
    "icaoEyeGazeMin",
    "icaoGlasses",
    "icaoGlassesMax",
    "icaoGlassesMin",
    "icaoGlassesStatusMode",
    "icaoHeavyFrame",
    "icaoHeavyFrameMax",
    "icaoHeavyFrameMin",
    "icaoHorizNoseRootPos",
    "icaoHorizNoseRootPosMax",
    "icaoHorizNoseRootPosMin",
    "icaoLeftEyeStatus",
    "icaoLeftEyeStatusMax",
    "icaoLeftEyeStatusMin",
    "icaoLeftEyeStatusMode",
    "icaoMouthStatus",
    "icaoMouthStatusMax",
    "icaoMouthStatusMin",
    "icaoMouthStatusMode",
    "icaoMultipleFaces",
    "icaoNoseShadow",
    "icaoNoseShadowMax",
    "icaoNoseShadowMin",
    "icaoPitchAngle",
    "icaoPitchAngleMax",
    "icaoPitchAngleMin",
    "icaoRectWidth",
    "icaoRectWidthMax",
    "icaoRectWidthMin",
    "icaoRedEyeLeft",
    "icaoRedEyeLeftMax",
    "icaoRedEyeLeftMin",
    "icaoRedEyeRight",
    "icaoRedEyeRightMax",
    "icaoRedEyeRightMin",
    "icaoRightEyeStatus",
    "icaoRightEyeStatusMax",
    "icaoRightEyeStatusMin",
    "icaoRightEyeStatusMode",
    "icaoRollAngle",
    "icaoRollAngleMax",
    "icaoRollAngleMin",
    "icaoShadow",
    "icaoShadowMax",
    "icaoShadowMin",
    "icaoSharpness",
    "icaoSharpnessMax",
    "icaoSharpnessMin",
    "icaoSpecularity",
    "icaoSpecularityMax",
    "icaoSpecularityMin",
    "icaoVerticalEyePosition",
    "icaoVerticalEyePositionMax",
    "icaoVerticalEyePositionMin",
    "icaoYawAngle",
    "icaoYawAngleMax",
    "icaoYawAngleMin"
})
@Generated("jsonschema2pojo")
public class IcaoAttributes {

    @JsonProperty("icaoBgUniformity")
    private String icaoBgUniformity;
    @JsonProperty("icaoBgUniformityMax")
    private String icaoBgUniformityMax;
    @JsonProperty("icaoBgUniformityMin")
    private String icaoBgUniformityMin;
    @JsonProperty("icaoBrightness")
    private String icaoBrightness;
    @JsonProperty("icaoBrightnessMax")
    private String icaoBrightnessMax;
    @JsonProperty("icaoBrightnessMin")
    private String icaoBrightnessMin;
    @JsonProperty("icaoColorProfile")
    private String icaoColorProfile;
    @JsonProperty("icaoColorProfileMax")
    private String icaoColorProfileMax;
    @JsonProperty("icaoColorProfileMin")
    private String icaoColorProfileMin;
    @JsonProperty("icaoCompilance")
    private String icaoCompilance;
    @JsonProperty("icaoContrast")
    private String icaoContrast;
    @JsonProperty("icaoContrastMax")
    private String icaoContrastMax;
    @JsonProperty("icaoContrastMin")
    private String icaoContrastMin;
    @JsonProperty("icaoEyeDistance")
    private String icaoEyeDistance;
    @JsonProperty("icaoEyeDistanceMax")
    private String icaoEyeDistanceMax;
    @JsonProperty("icaoEyeDistanceMin")
    private String icaoEyeDistanceMin;
    @JsonProperty("icaoEyeGaze")
    private String icaoEyeGaze;
    @JsonProperty("icaoEyeGazeMax")
    private String icaoEyeGazeMax;
    @JsonProperty("icaoEyeGazeMin")
    private String icaoEyeGazeMin;
    @JsonProperty("icaoGlasses")
    private String icaoGlasses;
    @JsonProperty("icaoGlassesMax")
    private String icaoGlassesMax;
    @JsonProperty("icaoGlassesMin")
    private String icaoGlassesMin;
    @JsonProperty("icaoGlassesStatusMode")
    private String icaoGlassesStatusMode;
    @JsonProperty("icaoHeavyFrame")
    private String icaoHeavyFrame;
    @JsonProperty("icaoHeavyFrameMax")
    private String icaoHeavyFrameMax;
    @JsonProperty("icaoHeavyFrameMin")
    private String icaoHeavyFrameMin;
    @JsonProperty("icaoHorizNoseRootPos")
    private String icaoHorizNoseRootPos;
    @JsonProperty("icaoHorizNoseRootPosMax")
    private String icaoHorizNoseRootPosMax;
    @JsonProperty("icaoHorizNoseRootPosMin")
    private String icaoHorizNoseRootPosMin;
    @JsonProperty("icaoLeftEyeStatus")
    private String icaoLeftEyeStatus;
    @JsonProperty("icaoLeftEyeStatusMax")
    private String icaoLeftEyeStatusMax;
    @JsonProperty("icaoLeftEyeStatusMin")
    private String icaoLeftEyeStatusMin;
    @JsonProperty("icaoLeftEyeStatusMode")
    private String icaoLeftEyeStatusMode;
    @JsonProperty("icaoMouthStatus")
    private String icaoMouthStatus;
    @JsonProperty("icaoMouthStatusMax")
    private String icaoMouthStatusMax;
    @JsonProperty("icaoMouthStatusMin")
    private String icaoMouthStatusMin;
    @JsonProperty("icaoMouthStatusMode")
    private String icaoMouthStatusMode;
    @JsonProperty("icaoMultipleFaces")
    private String icaoMultipleFaces;
    @JsonProperty("icaoNoseShadow")
    private String icaoNoseShadow;
    @JsonProperty("icaoNoseShadowMax")
    private String icaoNoseShadowMax;
    @JsonProperty("icaoNoseShadowMin")
    private String icaoNoseShadowMin;
    @JsonProperty("icaoPitchAngle")
    private String icaoPitchAngle;
    @JsonProperty("icaoPitchAngleMax")
    private String icaoPitchAngleMax;
    @JsonProperty("icaoPitchAngleMin")
    private String icaoPitchAngleMin;
    @JsonProperty("icaoRectWidth")
    private String icaoRectWidth;
    @JsonProperty("icaoRectWidthMax")
    private String icaoRectWidthMax;
    @JsonProperty("icaoRectWidthMin")
    private String icaoRectWidthMin;
    @JsonProperty("icaoRedEyeLeft")
    private String icaoRedEyeLeft;
    @JsonProperty("icaoRedEyeLeftMax")
    private String icaoRedEyeLeftMax;
    @JsonProperty("icaoRedEyeLeftMin")
    private String icaoRedEyeLeftMin;
    @JsonProperty("icaoRedEyeRight")
    private String icaoRedEyeRight;
    @JsonProperty("icaoRedEyeRightMax")
    private String icaoRedEyeRightMax;
    @JsonProperty("icaoRedEyeRightMin")
    private String icaoRedEyeRightMin;
    @JsonProperty("icaoRightEyeStatus")
    private String icaoRightEyeStatus;
    @JsonProperty("icaoRightEyeStatusMax")
    private String icaoRightEyeStatusMax;
    @JsonProperty("icaoRightEyeStatusMin")
    private String icaoRightEyeStatusMin;
    @JsonProperty("icaoRightEyeStatusMode")
    private String icaoRightEyeStatusMode;
    @JsonProperty("icaoRollAngle")
    private String icaoRollAngle;
    @JsonProperty("icaoRollAngleMax")
    private String icaoRollAngleMax;
    @JsonProperty("icaoRollAngleMin")
    private String icaoRollAngleMin;
    @JsonProperty("icaoShadow")
    private String icaoShadow;
    @JsonProperty("icaoShadowMax")
    private String icaoShadowMax;
    @JsonProperty("icaoShadowMin")
    private String icaoShadowMin;
    @JsonProperty("icaoSharpness")
    private String icaoSharpness;
    @JsonProperty("icaoSharpnessMax")
    private String icaoSharpnessMax;
    @JsonProperty("icaoSharpnessMin")
    private String icaoSharpnessMin;
    @JsonProperty("icaoSpecularity")
    private String icaoSpecularity;
    @JsonProperty("icaoSpecularityMax")
    private String icaoSpecularityMax;
    @JsonProperty("icaoSpecularityMin")
    private String icaoSpecularityMin;
    @JsonProperty("icaoVerticalEyePosition")
    private String icaoVerticalEyePosition;
    @JsonProperty("icaoVerticalEyePositionMax")
    private String icaoVerticalEyePositionMax;
    @JsonProperty("icaoVerticalEyePositionMin")
    private String icaoVerticalEyePositionMin;
    @JsonProperty("icaoYawAngle")
    private String icaoYawAngle;
    @JsonProperty("icaoYawAngleMax")
    private String icaoYawAngleMax;
    @JsonProperty("icaoYawAngleMin")
    private String icaoYawAngleMin;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("icaoBgUniformity")
    public String getIcaoBgUniformity() {
        return icaoBgUniformity;
    }

    @JsonProperty("icaoBgUniformity")
    public void setIcaoBgUniformity(String icaoBgUniformity) {
        this.icaoBgUniformity = icaoBgUniformity;
    }

    public IcaoAttributes withIcaoBgUniformity(String icaoBgUniformity) {
        this.icaoBgUniformity = icaoBgUniformity;
        return this;
    }

    @JsonProperty("icaoBgUniformityMax")
    public String getIcaoBgUniformityMax() {
        return icaoBgUniformityMax;
    }

    @JsonProperty("icaoBgUniformityMax")
    public void setIcaoBgUniformityMax(String icaoBgUniformityMax) {
        this.icaoBgUniformityMax = icaoBgUniformityMax;
    }

    public IcaoAttributes withIcaoBgUniformityMax(String icaoBgUniformityMax) {
        this.icaoBgUniformityMax = icaoBgUniformityMax;
        return this;
    }

    @JsonProperty("icaoBgUniformityMin")
    public String getIcaoBgUniformityMin() {
        return icaoBgUniformityMin;
    }

    @JsonProperty("icaoBgUniformityMin")
    public void setIcaoBgUniformityMin(String icaoBgUniformityMin) {
        this.icaoBgUniformityMin = icaoBgUniformityMin;
    }

    public IcaoAttributes withIcaoBgUniformityMin(String icaoBgUniformityMin) {
        this.icaoBgUniformityMin = icaoBgUniformityMin;
        return this;
    }

    @JsonProperty("icaoBrightness")
    public String getIcaoBrightness() {
        return icaoBrightness;
    }

    @JsonProperty("icaoBrightness")
    public void setIcaoBrightness(String icaoBrightness) {
        this.icaoBrightness = icaoBrightness;
    }

    public IcaoAttributes withIcaoBrightness(String icaoBrightness) {
        this.icaoBrightness = icaoBrightness;
        return this;
    }

    @JsonProperty("icaoBrightnessMax")
    public String getIcaoBrightnessMax() {
        return icaoBrightnessMax;
    }

    @JsonProperty("icaoBrightnessMax")
    public void setIcaoBrightnessMax(String icaoBrightnessMax) {
        this.icaoBrightnessMax = icaoBrightnessMax;
    }

    public IcaoAttributes withIcaoBrightnessMax(String icaoBrightnessMax) {
        this.icaoBrightnessMax = icaoBrightnessMax;
        return this;
    }

    @JsonProperty("icaoBrightnessMin")
    public String getIcaoBrightnessMin() {
        return icaoBrightnessMin;
    }

    @JsonProperty("icaoBrightnessMin")
    public void setIcaoBrightnessMin(String icaoBrightnessMin) {
        this.icaoBrightnessMin = icaoBrightnessMin;
    }

    public IcaoAttributes withIcaoBrightnessMin(String icaoBrightnessMin) {
        this.icaoBrightnessMin = icaoBrightnessMin;
        return this;
    }

    @JsonProperty("icaoColorProfile")
    public String getIcaoColorProfile() {
        return icaoColorProfile;
    }

    @JsonProperty("icaoColorProfile")
    public void setIcaoColorProfile(String icaoColorProfile) {
        this.icaoColorProfile = icaoColorProfile;
    }

    public IcaoAttributes withIcaoColorProfile(String icaoColorProfile) {
        this.icaoColorProfile = icaoColorProfile;
        return this;
    }

    @JsonProperty("icaoColorProfileMax")
    public String getIcaoColorProfileMax() {
        return icaoColorProfileMax;
    }

    @JsonProperty("icaoColorProfileMax")
    public void setIcaoColorProfileMax(String icaoColorProfileMax) {
        this.icaoColorProfileMax = icaoColorProfileMax;
    }

    public IcaoAttributes withIcaoColorProfileMax(String icaoColorProfileMax) {
        this.icaoColorProfileMax = icaoColorProfileMax;
        return this;
    }

    @JsonProperty("icaoColorProfileMin")
    public String getIcaoColorProfileMin() {
        return icaoColorProfileMin;
    }

    @JsonProperty("icaoColorProfileMin")
    public void setIcaoColorProfileMin(String icaoColorProfileMin) {
        this.icaoColorProfileMin = icaoColorProfileMin;
    }

    public IcaoAttributes withIcaoColorProfileMin(String icaoColorProfileMin) {
        this.icaoColorProfileMin = icaoColorProfileMin;
        return this;
    }

    @JsonProperty("icaoCompilance")
    public String getIcaoCompilance() {
        return icaoCompilance;
    }

    @JsonProperty("icaoCompilance")
    public void setIcaoCompilance(String icaoCompilance) {
        this.icaoCompilance = icaoCompilance;
    }

    public IcaoAttributes withIcaoCompilance(String icaoCompilance) {
        this.icaoCompilance = icaoCompilance;
        return this;
    }

    @JsonProperty("icaoContrast")
    public String getIcaoContrast() {
        return icaoContrast;
    }

    @JsonProperty("icaoContrast")
    public void setIcaoContrast(String icaoContrast) {
        this.icaoContrast = icaoContrast;
    }

    public IcaoAttributes withIcaoContrast(String icaoContrast) {
        this.icaoContrast = icaoContrast;
        return this;
    }

    @JsonProperty("icaoContrastMax")
    public String getIcaoContrastMax() {
        return icaoContrastMax;
    }

    @JsonProperty("icaoContrastMax")
    public void setIcaoContrastMax(String icaoContrastMax) {
        this.icaoContrastMax = icaoContrastMax;
    }

    public IcaoAttributes withIcaoContrastMax(String icaoContrastMax) {
        this.icaoContrastMax = icaoContrastMax;
        return this;
    }

    @JsonProperty("icaoContrastMin")
    public String getIcaoContrastMin() {
        return icaoContrastMin;
    }

    @JsonProperty("icaoContrastMin")
    public void setIcaoContrastMin(String icaoContrastMin) {
        this.icaoContrastMin = icaoContrastMin;
    }

    public IcaoAttributes withIcaoContrastMin(String icaoContrastMin) {
        this.icaoContrastMin = icaoContrastMin;
        return this;
    }

    @JsonProperty("icaoEyeDistance")
    public String getIcaoEyeDistance() {
        return icaoEyeDistance;
    }

    @JsonProperty("icaoEyeDistance")
    public void setIcaoEyeDistance(String icaoEyeDistance) {
        this.icaoEyeDistance = icaoEyeDistance;
    }

    public IcaoAttributes withIcaoEyeDistance(String icaoEyeDistance) {
        this.icaoEyeDistance = icaoEyeDistance;
        return this;
    }

    @JsonProperty("icaoEyeDistanceMax")
    public String getIcaoEyeDistanceMax() {
        return icaoEyeDistanceMax;
    }

    @JsonProperty("icaoEyeDistanceMax")
    public void setIcaoEyeDistanceMax(String icaoEyeDistanceMax) {
        this.icaoEyeDistanceMax = icaoEyeDistanceMax;
    }

    public IcaoAttributes withIcaoEyeDistanceMax(String icaoEyeDistanceMax) {
        this.icaoEyeDistanceMax = icaoEyeDistanceMax;
        return this;
    }

    @JsonProperty("icaoEyeDistanceMin")
    public String getIcaoEyeDistanceMin() {
        return icaoEyeDistanceMin;
    }

    @JsonProperty("icaoEyeDistanceMin")
    public void setIcaoEyeDistanceMin(String icaoEyeDistanceMin) {
        this.icaoEyeDistanceMin = icaoEyeDistanceMin;
    }

    public IcaoAttributes withIcaoEyeDistanceMin(String icaoEyeDistanceMin) {
        this.icaoEyeDistanceMin = icaoEyeDistanceMin;
        return this;
    }

    @JsonProperty("icaoEyeGaze")
    public String getIcaoEyeGaze() {
        return icaoEyeGaze;
    }

    @JsonProperty("icaoEyeGaze")
    public void setIcaoEyeGaze(String icaoEyeGaze) {
        this.icaoEyeGaze = icaoEyeGaze;
    }

    public IcaoAttributes withIcaoEyeGaze(String icaoEyeGaze) {
        this.icaoEyeGaze = icaoEyeGaze;
        return this;
    }

    @JsonProperty("icaoEyeGazeMax")
    public String getIcaoEyeGazeMax() {
        return icaoEyeGazeMax;
    }

    @JsonProperty("icaoEyeGazeMax")
    public void setIcaoEyeGazeMax(String icaoEyeGazeMax) {
        this.icaoEyeGazeMax = icaoEyeGazeMax;
    }

    public IcaoAttributes withIcaoEyeGazeMax(String icaoEyeGazeMax) {
        this.icaoEyeGazeMax = icaoEyeGazeMax;
        return this;
    }

    @JsonProperty("icaoEyeGazeMin")
    public String getIcaoEyeGazeMin() {
        return icaoEyeGazeMin;
    }

    @JsonProperty("icaoEyeGazeMin")
    public void setIcaoEyeGazeMin(String icaoEyeGazeMin) {
        this.icaoEyeGazeMin = icaoEyeGazeMin;
    }

    public IcaoAttributes withIcaoEyeGazeMin(String icaoEyeGazeMin) {
        this.icaoEyeGazeMin = icaoEyeGazeMin;
        return this;
    }

    @JsonProperty("icaoGlasses")
    public String getIcaoGlasses() {
        return icaoGlasses;
    }

    @JsonProperty("icaoGlasses")
    public void setIcaoGlasses(String icaoGlasses) {
        this.icaoGlasses = icaoGlasses;
    }

    public IcaoAttributes withIcaoGlasses(String icaoGlasses) {
        this.icaoGlasses = icaoGlasses;
        return this;
    }

    @JsonProperty("icaoGlassesMax")
    public String getIcaoGlassesMax() {
        return icaoGlassesMax;
    }

    @JsonProperty("icaoGlassesMax")
    public void setIcaoGlassesMax(String icaoGlassesMax) {
        this.icaoGlassesMax = icaoGlassesMax;
    }

    public IcaoAttributes withIcaoGlassesMax(String icaoGlassesMax) {
        this.icaoGlassesMax = icaoGlassesMax;
        return this;
    }

    @JsonProperty("icaoGlassesMin")
    public String getIcaoGlassesMin() {
        return icaoGlassesMin;
    }

    @JsonProperty("icaoGlassesMin")
    public void setIcaoGlassesMin(String icaoGlassesMin) {
        this.icaoGlassesMin = icaoGlassesMin;
    }

    public IcaoAttributes withIcaoGlassesMin(String icaoGlassesMin) {
        this.icaoGlassesMin = icaoGlassesMin;
        return this;
    }

    @JsonProperty("icaoGlassesStatusMode")
    public String getIcaoGlassesStatusMode() {
        return icaoGlassesStatusMode;
    }

    @JsonProperty("icaoGlassesStatusMode")
    public void setIcaoGlassesStatusMode(String icaoGlassesStatusMode) {
        this.icaoGlassesStatusMode = icaoGlassesStatusMode;
    }

    public IcaoAttributes withIcaoGlassesStatusMode(String icaoGlassesStatusMode) {
        this.icaoGlassesStatusMode = icaoGlassesStatusMode;
        return this;
    }

    @JsonProperty("icaoHeavyFrame")
    public String getIcaoHeavyFrame() {
        return icaoHeavyFrame;
    }

    @JsonProperty("icaoHeavyFrame")
    public void setIcaoHeavyFrame(String icaoHeavyFrame) {
        this.icaoHeavyFrame = icaoHeavyFrame;
    }

    public IcaoAttributes withIcaoHeavyFrame(String icaoHeavyFrame) {
        this.icaoHeavyFrame = icaoHeavyFrame;
        return this;
    }

    @JsonProperty("icaoHeavyFrameMax")
    public String getIcaoHeavyFrameMax() {
        return icaoHeavyFrameMax;
    }

    @JsonProperty("icaoHeavyFrameMax")
    public void setIcaoHeavyFrameMax(String icaoHeavyFrameMax) {
        this.icaoHeavyFrameMax = icaoHeavyFrameMax;
    }

    public IcaoAttributes withIcaoHeavyFrameMax(String icaoHeavyFrameMax) {
        this.icaoHeavyFrameMax = icaoHeavyFrameMax;
        return this;
    }

    @JsonProperty("icaoHeavyFrameMin")
    public String getIcaoHeavyFrameMin() {
        return icaoHeavyFrameMin;
    }

    @JsonProperty("icaoHeavyFrameMin")
    public void setIcaoHeavyFrameMin(String icaoHeavyFrameMin) {
        this.icaoHeavyFrameMin = icaoHeavyFrameMin;
    }

    public IcaoAttributes withIcaoHeavyFrameMin(String icaoHeavyFrameMin) {
        this.icaoHeavyFrameMin = icaoHeavyFrameMin;
        return this;
    }

    @JsonProperty("icaoHorizNoseRootPos")
    public String getIcaoHorizNoseRootPos() {
        return icaoHorizNoseRootPos;
    }

    @JsonProperty("icaoHorizNoseRootPos")
    public void setIcaoHorizNoseRootPos(String icaoHorizNoseRootPos) {
        this.icaoHorizNoseRootPos = icaoHorizNoseRootPos;
    }

    public IcaoAttributes withIcaoHorizNoseRootPos(String icaoHorizNoseRootPos) {
        this.icaoHorizNoseRootPos = icaoHorizNoseRootPos;
        return this;
    }

    @JsonProperty("icaoHorizNoseRootPosMax")
    public String getIcaoHorizNoseRootPosMax() {
        return icaoHorizNoseRootPosMax;
    }

    @JsonProperty("icaoHorizNoseRootPosMax")
    public void setIcaoHorizNoseRootPosMax(String icaoHorizNoseRootPosMax) {
        this.icaoHorizNoseRootPosMax = icaoHorizNoseRootPosMax;
    }

    public IcaoAttributes withIcaoHorizNoseRootPosMax(String icaoHorizNoseRootPosMax) {
        this.icaoHorizNoseRootPosMax = icaoHorizNoseRootPosMax;
        return this;
    }

    @JsonProperty("icaoHorizNoseRootPosMin")
    public String getIcaoHorizNoseRootPosMin() {
        return icaoHorizNoseRootPosMin;
    }

    @JsonProperty("icaoHorizNoseRootPosMin")
    public void setIcaoHorizNoseRootPosMin(String icaoHorizNoseRootPosMin) {
        this.icaoHorizNoseRootPosMin = icaoHorizNoseRootPosMin;
    }

    public IcaoAttributes withIcaoHorizNoseRootPosMin(String icaoHorizNoseRootPosMin) {
        this.icaoHorizNoseRootPosMin = icaoHorizNoseRootPosMin;
        return this;
    }

    @JsonProperty("icaoLeftEyeStatus")
    public String getIcaoLeftEyeStatus() {
        return icaoLeftEyeStatus;
    }

    @JsonProperty("icaoLeftEyeStatus")
    public void setIcaoLeftEyeStatus(String icaoLeftEyeStatus) {
        this.icaoLeftEyeStatus = icaoLeftEyeStatus;
    }

    public IcaoAttributes withIcaoLeftEyeStatus(String icaoLeftEyeStatus) {
        this.icaoLeftEyeStatus = icaoLeftEyeStatus;
        return this;
    }

    @JsonProperty("icaoLeftEyeStatusMax")
    public String getIcaoLeftEyeStatusMax() {
        return icaoLeftEyeStatusMax;
    }

    @JsonProperty("icaoLeftEyeStatusMax")
    public void setIcaoLeftEyeStatusMax(String icaoLeftEyeStatusMax) {
        this.icaoLeftEyeStatusMax = icaoLeftEyeStatusMax;
    }

    public IcaoAttributes withIcaoLeftEyeStatusMax(String icaoLeftEyeStatusMax) {
        this.icaoLeftEyeStatusMax = icaoLeftEyeStatusMax;
        return this;
    }

    @JsonProperty("icaoLeftEyeStatusMin")
    public String getIcaoLeftEyeStatusMin() {
        return icaoLeftEyeStatusMin;
    }

    @JsonProperty("icaoLeftEyeStatusMin")
    public void setIcaoLeftEyeStatusMin(String icaoLeftEyeStatusMin) {
        this.icaoLeftEyeStatusMin = icaoLeftEyeStatusMin;
    }

    public IcaoAttributes withIcaoLeftEyeStatusMin(String icaoLeftEyeStatusMin) {
        this.icaoLeftEyeStatusMin = icaoLeftEyeStatusMin;
        return this;
    }

    @JsonProperty("icaoLeftEyeStatusMode")
    public String getIcaoLeftEyeStatusMode() {
        return icaoLeftEyeStatusMode;
    }

    @JsonProperty("icaoLeftEyeStatusMode")
    public void setIcaoLeftEyeStatusMode(String icaoLeftEyeStatusMode) {
        this.icaoLeftEyeStatusMode = icaoLeftEyeStatusMode;
    }

    public IcaoAttributes withIcaoLeftEyeStatusMode(String icaoLeftEyeStatusMode) {
        this.icaoLeftEyeStatusMode = icaoLeftEyeStatusMode;
        return this;
    }

    @JsonProperty("icaoMouthStatus")
    public String getIcaoMouthStatus() {
        return icaoMouthStatus;
    }

    @JsonProperty("icaoMouthStatus")
    public void setIcaoMouthStatus(String icaoMouthStatus) {
        this.icaoMouthStatus = icaoMouthStatus;
    }

    public IcaoAttributes withIcaoMouthStatus(String icaoMouthStatus) {
        this.icaoMouthStatus = icaoMouthStatus;
        return this;
    }

    @JsonProperty("icaoMouthStatusMax")
    public String getIcaoMouthStatusMax() {
        return icaoMouthStatusMax;
    }

    @JsonProperty("icaoMouthStatusMax")
    public void setIcaoMouthStatusMax(String icaoMouthStatusMax) {
        this.icaoMouthStatusMax = icaoMouthStatusMax;
    }

    public IcaoAttributes withIcaoMouthStatusMax(String icaoMouthStatusMax) {
        this.icaoMouthStatusMax = icaoMouthStatusMax;
        return this;
    }

    @JsonProperty("icaoMouthStatusMin")
    public String getIcaoMouthStatusMin() {
        return icaoMouthStatusMin;
    }

    @JsonProperty("icaoMouthStatusMin")
    public void setIcaoMouthStatusMin(String icaoMouthStatusMin) {
        this.icaoMouthStatusMin = icaoMouthStatusMin;
    }

    public IcaoAttributes withIcaoMouthStatusMin(String icaoMouthStatusMin) {
        this.icaoMouthStatusMin = icaoMouthStatusMin;
        return this;
    }

    @JsonProperty("icaoMouthStatusMode")
    public String getIcaoMouthStatusMode() {
        return icaoMouthStatusMode;
    }

    @JsonProperty("icaoMouthStatusMode")
    public void setIcaoMouthStatusMode(String icaoMouthStatusMode) {
        this.icaoMouthStatusMode = icaoMouthStatusMode;
    }

    public IcaoAttributes withIcaoMouthStatusMode(String icaoMouthStatusMode) {
        this.icaoMouthStatusMode = icaoMouthStatusMode;
        return this;
    }

    @JsonProperty("icaoMultipleFaces")
    public String getIcaoMultipleFaces() {
        return icaoMultipleFaces;
    }

    @JsonProperty("icaoMultipleFaces")
    public void setIcaoMultipleFaces(String icaoMultipleFaces) {
        this.icaoMultipleFaces = icaoMultipleFaces;
    }

    public IcaoAttributes withIcaoMultipleFaces(String icaoMultipleFaces) {
        this.icaoMultipleFaces = icaoMultipleFaces;
        return this;
    }

    @JsonProperty("icaoNoseShadow")
    public String getIcaoNoseShadow() {
        return icaoNoseShadow;
    }

    @JsonProperty("icaoNoseShadow")
    public void setIcaoNoseShadow(String icaoNoseShadow) {
        this.icaoNoseShadow = icaoNoseShadow;
    }

    public IcaoAttributes withIcaoNoseShadow(String icaoNoseShadow) {
        this.icaoNoseShadow = icaoNoseShadow;
        return this;
    }

    @JsonProperty("icaoNoseShadowMax")
    public String getIcaoNoseShadowMax() {
        return icaoNoseShadowMax;
    }

    @JsonProperty("icaoNoseShadowMax")
    public void setIcaoNoseShadowMax(String icaoNoseShadowMax) {
        this.icaoNoseShadowMax = icaoNoseShadowMax;
    }

    public IcaoAttributes withIcaoNoseShadowMax(String icaoNoseShadowMax) {
        this.icaoNoseShadowMax = icaoNoseShadowMax;
        return this;
    }

    @JsonProperty("icaoNoseShadowMin")
    public String getIcaoNoseShadowMin() {
        return icaoNoseShadowMin;
    }

    @JsonProperty("icaoNoseShadowMin")
    public void setIcaoNoseShadowMin(String icaoNoseShadowMin) {
        this.icaoNoseShadowMin = icaoNoseShadowMin;
    }

    public IcaoAttributes withIcaoNoseShadowMin(String icaoNoseShadowMin) {
        this.icaoNoseShadowMin = icaoNoseShadowMin;
        return this;
    }

    @JsonProperty("icaoPitchAngle")
    public String getIcaoPitchAngle() {
        return icaoPitchAngle;
    }

    @JsonProperty("icaoPitchAngle")
    public void setIcaoPitchAngle(String icaoPitchAngle) {
        this.icaoPitchAngle = icaoPitchAngle;
    }

    public IcaoAttributes withIcaoPitchAngle(String icaoPitchAngle) {
        this.icaoPitchAngle = icaoPitchAngle;
        return this;
    }

    @JsonProperty("icaoPitchAngleMax")
    public String getIcaoPitchAngleMax() {
        return icaoPitchAngleMax;
    }

    @JsonProperty("icaoPitchAngleMax")
    public void setIcaoPitchAngleMax(String icaoPitchAngleMax) {
        this.icaoPitchAngleMax = icaoPitchAngleMax;
    }

    public IcaoAttributes withIcaoPitchAngleMax(String icaoPitchAngleMax) {
        this.icaoPitchAngleMax = icaoPitchAngleMax;
        return this;
    }

    @JsonProperty("icaoPitchAngleMin")
    public String getIcaoPitchAngleMin() {
        return icaoPitchAngleMin;
    }

    @JsonProperty("icaoPitchAngleMin")
    public void setIcaoPitchAngleMin(String icaoPitchAngleMin) {
        this.icaoPitchAngleMin = icaoPitchAngleMin;
    }

    public IcaoAttributes withIcaoPitchAngleMin(String icaoPitchAngleMin) {
        this.icaoPitchAngleMin = icaoPitchAngleMin;
        return this;
    }

    @JsonProperty("icaoRectWidth")
    public String getIcaoRectWidth() {
        return icaoRectWidth;
    }

    @JsonProperty("icaoRectWidth")
    public void setIcaoRectWidth(String icaoRectWidth) {
        this.icaoRectWidth = icaoRectWidth;
    }

    public IcaoAttributes withIcaoRectWidth(String icaoRectWidth) {
        this.icaoRectWidth = icaoRectWidth;
        return this;
    }

    @JsonProperty("icaoRectWidthMax")
    public String getIcaoRectWidthMax() {
        return icaoRectWidthMax;
    }

    @JsonProperty("icaoRectWidthMax")
    public void setIcaoRectWidthMax(String icaoRectWidthMax) {
        this.icaoRectWidthMax = icaoRectWidthMax;
    }

    public IcaoAttributes withIcaoRectWidthMax(String icaoRectWidthMax) {
        this.icaoRectWidthMax = icaoRectWidthMax;
        return this;
    }

    @JsonProperty("icaoRectWidthMin")
    public String getIcaoRectWidthMin() {
        return icaoRectWidthMin;
    }

    @JsonProperty("icaoRectWidthMin")
    public void setIcaoRectWidthMin(String icaoRectWidthMin) {
        this.icaoRectWidthMin = icaoRectWidthMin;
    }

    public IcaoAttributes withIcaoRectWidthMin(String icaoRectWidthMin) {
        this.icaoRectWidthMin = icaoRectWidthMin;
        return this;
    }

    @JsonProperty("icaoRedEyeLeft")
    public String getIcaoRedEyeLeft() {
        return icaoRedEyeLeft;
    }

    @JsonProperty("icaoRedEyeLeft")
    public void setIcaoRedEyeLeft(String icaoRedEyeLeft) {
        this.icaoRedEyeLeft = icaoRedEyeLeft;
    }

    public IcaoAttributes withIcaoRedEyeLeft(String icaoRedEyeLeft) {
        this.icaoRedEyeLeft = icaoRedEyeLeft;
        return this;
    }

    @JsonProperty("icaoRedEyeLeftMax")
    public String getIcaoRedEyeLeftMax() {
        return icaoRedEyeLeftMax;
    }

    @JsonProperty("icaoRedEyeLeftMax")
    public void setIcaoRedEyeLeftMax(String icaoRedEyeLeftMax) {
        this.icaoRedEyeLeftMax = icaoRedEyeLeftMax;
    }

    public IcaoAttributes withIcaoRedEyeLeftMax(String icaoRedEyeLeftMax) {
        this.icaoRedEyeLeftMax = icaoRedEyeLeftMax;
        return this;
    }

    @JsonProperty("icaoRedEyeLeftMin")
    public String getIcaoRedEyeLeftMin() {
        return icaoRedEyeLeftMin;
    }

    @JsonProperty("icaoRedEyeLeftMin")
    public void setIcaoRedEyeLeftMin(String icaoRedEyeLeftMin) {
        this.icaoRedEyeLeftMin = icaoRedEyeLeftMin;
    }

    public IcaoAttributes withIcaoRedEyeLeftMin(String icaoRedEyeLeftMin) {
        this.icaoRedEyeLeftMin = icaoRedEyeLeftMin;
        return this;
    }

    @JsonProperty("icaoRedEyeRight")
    public String getIcaoRedEyeRight() {
        return icaoRedEyeRight;
    }

    @JsonProperty("icaoRedEyeRight")
    public void setIcaoRedEyeRight(String icaoRedEyeRight) {
        this.icaoRedEyeRight = icaoRedEyeRight;
    }

    public IcaoAttributes withIcaoRedEyeRight(String icaoRedEyeRight) {
        this.icaoRedEyeRight = icaoRedEyeRight;
        return this;
    }

    @JsonProperty("icaoRedEyeRightMax")
    public String getIcaoRedEyeRightMax() {
        return icaoRedEyeRightMax;
    }

    @JsonProperty("icaoRedEyeRightMax")
    public void setIcaoRedEyeRightMax(String icaoRedEyeRightMax) {
        this.icaoRedEyeRightMax = icaoRedEyeRightMax;
    }

    public IcaoAttributes withIcaoRedEyeRightMax(String icaoRedEyeRightMax) {
        this.icaoRedEyeRightMax = icaoRedEyeRightMax;
        return this;
    }

    @JsonProperty("icaoRedEyeRightMin")
    public String getIcaoRedEyeRightMin() {
        return icaoRedEyeRightMin;
    }

    @JsonProperty("icaoRedEyeRightMin")
    public void setIcaoRedEyeRightMin(String icaoRedEyeRightMin) {
        this.icaoRedEyeRightMin = icaoRedEyeRightMin;
    }

    public IcaoAttributes withIcaoRedEyeRightMin(String icaoRedEyeRightMin) {
        this.icaoRedEyeRightMin = icaoRedEyeRightMin;
        return this;
    }

    @JsonProperty("icaoRightEyeStatus")
    public String getIcaoRightEyeStatus() {
        return icaoRightEyeStatus;
    }

    @JsonProperty("icaoRightEyeStatus")
    public void setIcaoRightEyeStatus(String icaoRightEyeStatus) {
        this.icaoRightEyeStatus = icaoRightEyeStatus;
    }

    public IcaoAttributes withIcaoRightEyeStatus(String icaoRightEyeStatus) {
        this.icaoRightEyeStatus = icaoRightEyeStatus;
        return this;
    }

    @JsonProperty("icaoRightEyeStatusMax")
    public String getIcaoRightEyeStatusMax() {
        return icaoRightEyeStatusMax;
    }

    @JsonProperty("icaoRightEyeStatusMax")
    public void setIcaoRightEyeStatusMax(String icaoRightEyeStatusMax) {
        this.icaoRightEyeStatusMax = icaoRightEyeStatusMax;
    }

    public IcaoAttributes withIcaoRightEyeStatusMax(String icaoRightEyeStatusMax) {
        this.icaoRightEyeStatusMax = icaoRightEyeStatusMax;
        return this;
    }

    @JsonProperty("icaoRightEyeStatusMin")
    public String getIcaoRightEyeStatusMin() {
        return icaoRightEyeStatusMin;
    }

    @JsonProperty("icaoRightEyeStatusMin")
    public void setIcaoRightEyeStatusMin(String icaoRightEyeStatusMin) {
        this.icaoRightEyeStatusMin = icaoRightEyeStatusMin;
    }

    public IcaoAttributes withIcaoRightEyeStatusMin(String icaoRightEyeStatusMin) {
        this.icaoRightEyeStatusMin = icaoRightEyeStatusMin;
        return this;
    }

    @JsonProperty("icaoRightEyeStatusMode")
    public String getIcaoRightEyeStatusMode() {
        return icaoRightEyeStatusMode;
    }

    @JsonProperty("icaoRightEyeStatusMode")
    public void setIcaoRightEyeStatusMode(String icaoRightEyeStatusMode) {
        this.icaoRightEyeStatusMode = icaoRightEyeStatusMode;
    }

    public IcaoAttributes withIcaoRightEyeStatusMode(String icaoRightEyeStatusMode) {
        this.icaoRightEyeStatusMode = icaoRightEyeStatusMode;
        return this;
    }

    @JsonProperty("icaoRollAngle")
    public String getIcaoRollAngle() {
        return icaoRollAngle;
    }

    @JsonProperty("icaoRollAngle")
    public void setIcaoRollAngle(String icaoRollAngle) {
        this.icaoRollAngle = icaoRollAngle;
    }

    public IcaoAttributes withIcaoRollAngle(String icaoRollAngle) {
        this.icaoRollAngle = icaoRollAngle;
        return this;
    }

    @JsonProperty("icaoRollAngleMax")
    public String getIcaoRollAngleMax() {
        return icaoRollAngleMax;
    }

    @JsonProperty("icaoRollAngleMax")
    public void setIcaoRollAngleMax(String icaoRollAngleMax) {
        this.icaoRollAngleMax = icaoRollAngleMax;
    }

    public IcaoAttributes withIcaoRollAngleMax(String icaoRollAngleMax) {
        this.icaoRollAngleMax = icaoRollAngleMax;
        return this;
    }

    @JsonProperty("icaoRollAngleMin")
    public String getIcaoRollAngleMin() {
        return icaoRollAngleMin;
    }

    @JsonProperty("icaoRollAngleMin")
    public void setIcaoRollAngleMin(String icaoRollAngleMin) {
        this.icaoRollAngleMin = icaoRollAngleMin;
    }

    public IcaoAttributes withIcaoRollAngleMin(String icaoRollAngleMin) {
        this.icaoRollAngleMin = icaoRollAngleMin;
        return this;
    }

    @JsonProperty("icaoShadow")
    public String getIcaoShadow() {
        return icaoShadow;
    }

    @JsonProperty("icaoShadow")
    public void setIcaoShadow(String icaoShadow) {
        this.icaoShadow = icaoShadow;
    }

    public IcaoAttributes withIcaoShadow(String icaoShadow) {
        this.icaoShadow = icaoShadow;
        return this;
    }

    @JsonProperty("icaoShadowMax")
    public String getIcaoShadowMax() {
        return icaoShadowMax;
    }

    @JsonProperty("icaoShadowMax")
    public void setIcaoShadowMax(String icaoShadowMax) {
        this.icaoShadowMax = icaoShadowMax;
    }

    public IcaoAttributes withIcaoShadowMax(String icaoShadowMax) {
        this.icaoShadowMax = icaoShadowMax;
        return this;
    }

    @JsonProperty("icaoShadowMin")
    public String getIcaoShadowMin() {
        return icaoShadowMin;
    }

    @JsonProperty("icaoShadowMin")
    public void setIcaoShadowMin(String icaoShadowMin) {
        this.icaoShadowMin = icaoShadowMin;
    }

    public IcaoAttributes withIcaoShadowMin(String icaoShadowMin) {
        this.icaoShadowMin = icaoShadowMin;
        return this;
    }

    @JsonProperty("icaoSharpness")
    public String getIcaoSharpness() {
        return icaoSharpness;
    }

    @JsonProperty("icaoSharpness")
    public void setIcaoSharpness(String icaoSharpness) {
        this.icaoSharpness = icaoSharpness;
    }

    public IcaoAttributes withIcaoSharpness(String icaoSharpness) {
        this.icaoSharpness = icaoSharpness;
        return this;
    }

    @JsonProperty("icaoSharpnessMax")
    public String getIcaoSharpnessMax() {
        return icaoSharpnessMax;
    }

    @JsonProperty("icaoSharpnessMax")
    public void setIcaoSharpnessMax(String icaoSharpnessMax) {
        this.icaoSharpnessMax = icaoSharpnessMax;
    }

    public IcaoAttributes withIcaoSharpnessMax(String icaoSharpnessMax) {
        this.icaoSharpnessMax = icaoSharpnessMax;
        return this;
    }

    @JsonProperty("icaoSharpnessMin")
    public String getIcaoSharpnessMin() {
        return icaoSharpnessMin;
    }

    @JsonProperty("icaoSharpnessMin")
    public void setIcaoSharpnessMin(String icaoSharpnessMin) {
        this.icaoSharpnessMin = icaoSharpnessMin;
    }

    public IcaoAttributes withIcaoSharpnessMin(String icaoSharpnessMin) {
        this.icaoSharpnessMin = icaoSharpnessMin;
        return this;
    }

    @JsonProperty("icaoSpecularity")
    public String getIcaoSpecularity() {
        return icaoSpecularity;
    }

    @JsonProperty("icaoSpecularity")
    public void setIcaoSpecularity(String icaoSpecularity) {
        this.icaoSpecularity = icaoSpecularity;
    }

    public IcaoAttributes withIcaoSpecularity(String icaoSpecularity) {
        this.icaoSpecularity = icaoSpecularity;
        return this;
    }

    @JsonProperty("icaoSpecularityMax")
    public String getIcaoSpecularityMax() {
        return icaoSpecularityMax;
    }

    @JsonProperty("icaoSpecularityMax")
    public void setIcaoSpecularityMax(String icaoSpecularityMax) {
        this.icaoSpecularityMax = icaoSpecularityMax;
    }

    public IcaoAttributes withIcaoSpecularityMax(String icaoSpecularityMax) {
        this.icaoSpecularityMax = icaoSpecularityMax;
        return this;
    }

    @JsonProperty("icaoSpecularityMin")
    public String getIcaoSpecularityMin() {
        return icaoSpecularityMin;
    }

    @JsonProperty("icaoSpecularityMin")
    public void setIcaoSpecularityMin(String icaoSpecularityMin) {
        this.icaoSpecularityMin = icaoSpecularityMin;
    }

    public IcaoAttributes withIcaoSpecularityMin(String icaoSpecularityMin) {
        this.icaoSpecularityMin = icaoSpecularityMin;
        return this;
    }

    @JsonProperty("icaoVerticalEyePosition")
    public String getIcaoVerticalEyePosition() {
        return icaoVerticalEyePosition;
    }

    @JsonProperty("icaoVerticalEyePosition")
    public void setIcaoVerticalEyePosition(String icaoVerticalEyePosition) {
        this.icaoVerticalEyePosition = icaoVerticalEyePosition;
    }

    public IcaoAttributes withIcaoVerticalEyePosition(String icaoVerticalEyePosition) {
        this.icaoVerticalEyePosition = icaoVerticalEyePosition;
        return this;
    }

    @JsonProperty("icaoVerticalEyePositionMax")
    public String getIcaoVerticalEyePositionMax() {
        return icaoVerticalEyePositionMax;
    }

    @JsonProperty("icaoVerticalEyePositionMax")
    public void setIcaoVerticalEyePositionMax(String icaoVerticalEyePositionMax) {
        this.icaoVerticalEyePositionMax = icaoVerticalEyePositionMax;
    }

    public IcaoAttributes withIcaoVerticalEyePositionMax(String icaoVerticalEyePositionMax) {
        this.icaoVerticalEyePositionMax = icaoVerticalEyePositionMax;
        return this;
    }

    @JsonProperty("icaoVerticalEyePositionMin")
    public String getIcaoVerticalEyePositionMin() {
        return icaoVerticalEyePositionMin;
    }

    @JsonProperty("icaoVerticalEyePositionMin")
    public void setIcaoVerticalEyePositionMin(String icaoVerticalEyePositionMin) {
        this.icaoVerticalEyePositionMin = icaoVerticalEyePositionMin;
    }

    public IcaoAttributes withIcaoVerticalEyePositionMin(String icaoVerticalEyePositionMin) {
        this.icaoVerticalEyePositionMin = icaoVerticalEyePositionMin;
        return this;
    }

    @JsonProperty("icaoYawAngle")
    public String getIcaoYawAngle() {
        return icaoYawAngle;
    }

    @JsonProperty("icaoYawAngle")
    public void setIcaoYawAngle(String icaoYawAngle) {
        this.icaoYawAngle = icaoYawAngle;
    }

    public IcaoAttributes withIcaoYawAngle(String icaoYawAngle) {
        this.icaoYawAngle = icaoYawAngle;
        return this;
    }

    @JsonProperty("icaoYawAngleMax")
    public String getIcaoYawAngleMax() {
        return icaoYawAngleMax;
    }

    @JsonProperty("icaoYawAngleMax")
    public void setIcaoYawAngleMax(String icaoYawAngleMax) {
        this.icaoYawAngleMax = icaoYawAngleMax;
    }

    public IcaoAttributes withIcaoYawAngleMax(String icaoYawAngleMax) {
        this.icaoYawAngleMax = icaoYawAngleMax;
        return this;
    }

    @JsonProperty("icaoYawAngleMin")
    public String getIcaoYawAngleMin() {
        return icaoYawAngleMin;
    }

    @JsonProperty("icaoYawAngleMin")
    public void setIcaoYawAngleMin(String icaoYawAngleMin) {
        this.icaoYawAngleMin = icaoYawAngleMin;
    }

    public IcaoAttributes withIcaoYawAngleMin(String icaoYawAngleMin) {
        this.icaoYawAngleMin = icaoYawAngleMin;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public IcaoAttributes withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}

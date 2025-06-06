/*
 * Digital Identity Service API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.50.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.innovatrics.dot.integrationsamples.disapi.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.innovatrics.dot.integrationsamples.disapi.model.QualityCheckDetail;
import java.io.IOException;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.innovatrics.dot.integrationsamples.disapi.JSON;

/**
 * Quality check details
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-19T13:31:50.465535+05:30[Asia/Kolkata]", comments = "Generator version: 7.8.0")
public class QualityDetails {
  public static final String SERIALIZED_NAME_SHARPNESS = "sharpness";
  @SerializedName(SERIALIZED_NAME_SHARPNESS)
  private QualityCheckDetail sharpness;

  public static final String SERIALIZED_NAME_BRIGHTNESS = "brightness";
  @SerializedName(SERIALIZED_NAME_BRIGHTNESS)
  private QualityCheckDetail brightness;

  public static final String SERIALIZED_NAME_HOTSPOTS = "hotspots";
  @SerializedName(SERIALIZED_NAME_HOTSPOTS)
  private QualityCheckDetail hotspots;

  public QualityDetails() {
  }

  public QualityDetails sharpness(QualityCheckDetail sharpness) {
    this.sharpness = sharpness;
    return this;
  }

  /**
   * Get sharpness
   * @return sharpness
   */
  @javax.annotation.Nonnull
  public QualityCheckDetail getSharpness() {
    return sharpness;
  }

  public void setSharpness(QualityCheckDetail sharpness) {
    this.sharpness = sharpness;
  }


  public QualityDetails brightness(QualityCheckDetail brightness) {
    this.brightness = brightness;
    return this;
  }

  /**
   * Get brightness
   * @return brightness
   */
  @javax.annotation.Nonnull
  public QualityCheckDetail getBrightness() {
    return brightness;
  }

  public void setBrightness(QualityCheckDetail brightness) {
    this.brightness = brightness;
  }


  public QualityDetails hotspots(QualityCheckDetail hotspots) {
    this.hotspots = hotspots;
    return this;
  }

  /**
   * Get hotspots
   * @return hotspots
   */
  @javax.annotation.Nonnull
  public QualityCheckDetail getHotspots() {
    return hotspots;
  }

  public void setHotspots(QualityCheckDetail hotspots) {
    this.hotspots = hotspots;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QualityDetails qualityDetails = (QualityDetails) o;
    return Objects.equals(this.sharpness, qualityDetails.sharpness) &&
        Objects.equals(this.brightness, qualityDetails.brightness) &&
        Objects.equals(this.hotspots, qualityDetails.hotspots);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sharpness, brightness, hotspots);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QualityDetails {\n");
    sb.append("    sharpness: ").append(toIndentedString(sharpness)).append("\n");
    sb.append("    brightness: ").append(toIndentedString(brightness)).append("\n");
    sb.append("    hotspots: ").append(toIndentedString(hotspots)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("sharpness");
    openapiFields.add("brightness");
    openapiFields.add("hotspots");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("sharpness");
    openapiRequiredFields.add("brightness");
    openapiRequiredFields.add("hotspots");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to QualityDetails
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!QualityDetails.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in QualityDetails is not found in the empty JSON string", QualityDetails.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!QualityDetails.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `QualityDetails` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : QualityDetails.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the required field `sharpness`
      QualityCheckDetail.validateJsonElement(jsonObj.get("sharpness"));
      // validate the required field `brightness`
      QualityCheckDetail.validateJsonElement(jsonObj.get("brightness"));
      // validate the required field `hotspots`
      QualityCheckDetail.validateJsonElement(jsonObj.get("hotspots"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!QualityDetails.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'QualityDetails' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<QualityDetails> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(QualityDetails.class));

       return (TypeAdapter<T>) new TypeAdapter<QualityDetails>() {
           @Override
           public void write(JsonWriter out, QualityDetails value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public QualityDetails read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of QualityDetails given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of QualityDetails
   * @throws IOException if the JSON string is invalid with respect to QualityDetails
   */
  public static QualityDetails fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, QualityDetails.class);
  }

  /**
   * Convert an instance of QualityDetails to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


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
import com.innovatrics.dot.integrationsamples.disapi.model.FaceDetection;
import com.innovatrics.dot.integrationsamples.disapi.model.Links;
import com.innovatrics.dot.integrationsamples.disapi.model.ResourceData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * CreateSelfieResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-19T13:31:50.465535+05:30[Asia/Kolkata]", comments = "Generator version: 7.8.0")
public class CreateSelfieResponse {
  public static final String SERIALIZED_NAME_DETECTION = "detection";
  @SerializedName(SERIALIZED_NAME_DETECTION)
  private FaceDetection detection;

  public static final String SERIALIZED_NAME_LINKS = "links";
  @SerializedName(SERIALIZED_NAME_LINKS)
  private Links links;

  /**
   * The face detection error code
   */
  @JsonAdapter(ErrorCodeEnum.Adapter.class)
  public enum ErrorCodeEnum {
    NO_FACE_DETECTED("NO_FACE_DETECTED"),
    
    INVALID_DATA("INVALID_DATA"),
    
    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private String value;

    ErrorCodeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ErrorCodeEnum fromValue(String value) {
      for (ErrorCodeEnum b : ErrorCodeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return UNKNOWN_DEFAULT_OPEN_API;
    }

    public static class Adapter extends TypeAdapter<ErrorCodeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ErrorCodeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ErrorCodeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ErrorCodeEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      ErrorCodeEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_ERROR_CODE = "errorCode";
  @SerializedName(SERIALIZED_NAME_ERROR_CODE)
  private ErrorCodeEnum errorCode;

  /**
   * The face detection warnings
   */
  @JsonAdapter(WarningsEnum.Adapter.class)
  public enum WarningsEnum {
    MULTIPLE_FACES_DETECTED("MULTIPLE_FACES_DETECTED"),
    
    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private String value;

    WarningsEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static WarningsEnum fromValue(String value) {
      for (WarningsEnum b : WarningsEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return UNKNOWN_DEFAULT_OPEN_API;
    }

    public static class Adapter extends TypeAdapter<WarningsEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final WarningsEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public WarningsEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return WarningsEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      WarningsEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_WARNINGS = "warnings";
  @SerializedName(SERIALIZED_NAME_WARNINGS)
  private List<WarningsEnum> warnings = new ArrayList<>();

  public static final String SERIALIZED_NAME_ADDITIONAL_DATA = "additionalData";
  @SerializedName(SERIALIZED_NAME_ADDITIONAL_DATA)
  private ResourceData additionalData;

  public CreateSelfieResponse() {
  }

  public CreateSelfieResponse(
     ErrorCodeEnum errorCode, 
     List<WarningsEnum> warnings
  ) {
    this();
    this.errorCode = errorCode;
    this.warnings = warnings;
  }

  public CreateSelfieResponse detection(FaceDetection detection) {
    this.detection = detection;
    return this;
  }

  /**
   * Get detection
   * @return detection
   */
  @javax.annotation.Nullable
  public FaceDetection getDetection() {
    return detection;
  }

  public void setDetection(FaceDetection detection) {
    this.detection = detection;
  }


  public CreateSelfieResponse links(Links links) {
    this.links = links;
    return this;
  }

  /**
   * Get links
   * @return links
   */
  @javax.annotation.Nullable
  public Links getLinks() {
    return links;
  }

  public void setLinks(Links links) {
    this.links = links;
  }


  /**
   * The face detection error code
   * @return errorCode
   */
  @javax.annotation.Nullable
  public ErrorCodeEnum getErrorCode() {
    return errorCode;
  }



  /**
   * The face detection warnings
   * @return warnings
   */
  @javax.annotation.Nullable
  public List<WarningsEnum> getWarnings() {
    return warnings;
  }



  public CreateSelfieResponse additionalData(ResourceData additionalData) {
    this.additionalData = additionalData;
    return this;
  }

  /**
   * Get additionalData
   * @return additionalData
   */
  @javax.annotation.Nullable
  public ResourceData getAdditionalData() {
    return additionalData;
  }

  public void setAdditionalData(ResourceData additionalData) {
    this.additionalData = additionalData;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateSelfieResponse createSelfieResponse = (CreateSelfieResponse) o;
    return Objects.equals(this.detection, createSelfieResponse.detection) &&
        Objects.equals(this.links, createSelfieResponse.links) &&
        Objects.equals(this.errorCode, createSelfieResponse.errorCode) &&
        Objects.equals(this.warnings, createSelfieResponse.warnings) &&
        Objects.equals(this.additionalData, createSelfieResponse.additionalData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(detection, links, errorCode, warnings, additionalData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateSelfieResponse {\n");
    sb.append("    detection: ").append(toIndentedString(detection)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    warnings: ").append(toIndentedString(warnings)).append("\n");
    sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
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
    openapiFields.add("detection");
    openapiFields.add("links");
    openapiFields.add("errorCode");
    openapiFields.add("warnings");
    openapiFields.add("additionalData");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to CreateSelfieResponse
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!CreateSelfieResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CreateSelfieResponse is not found in the empty JSON string", CreateSelfieResponse.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!CreateSelfieResponse.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CreateSelfieResponse` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the optional field `detection`
      if (jsonObj.get("detection") != null && !jsonObj.get("detection").isJsonNull()) {
        FaceDetection.validateJsonElement(jsonObj.get("detection"));
      }
      // validate the optional field `links`
      if (jsonObj.get("links") != null && !jsonObj.get("links").isJsonNull()) {
        Links.validateJsonElement(jsonObj.get("links"));
      }
      if ((jsonObj.get("errorCode") != null && !jsonObj.get("errorCode").isJsonNull()) && !jsonObj.get("errorCode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `errorCode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("errorCode").toString()));
      }
      // validate the optional field `errorCode`
      if (jsonObj.get("errorCode") != null && !jsonObj.get("errorCode").isJsonNull()) {
        ErrorCodeEnum.validateJsonElement(jsonObj.get("errorCode"));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("warnings") != null && !jsonObj.get("warnings").isJsonNull() && !jsonObj.get("warnings").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `warnings` to be an array in the JSON string but got `%s`", jsonObj.get("warnings").toString()));
      }
      // validate the optional field `additionalData`
      if (jsonObj.get("additionalData") != null && !jsonObj.get("additionalData").isJsonNull()) {
        ResourceData.validateJsonElement(jsonObj.get("additionalData"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CreateSelfieResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CreateSelfieResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CreateSelfieResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CreateSelfieResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<CreateSelfieResponse>() {
           @Override
           public void write(JsonWriter out, CreateSelfieResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CreateSelfieResponse read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of CreateSelfieResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CreateSelfieResponse
   * @throws IOException if the JSON string is invalid with respect to CreateSelfieResponse
   */
  public static CreateSelfieResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CreateSelfieResponse.class);
  }

  /**
   * Convert an instance of CreateSelfieResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


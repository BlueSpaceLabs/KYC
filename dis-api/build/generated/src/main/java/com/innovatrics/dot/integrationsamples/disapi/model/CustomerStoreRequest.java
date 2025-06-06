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
 * CustomerStoreRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-19T13:31:50.465535+05:30[Asia/Kolkata]", comments = "Generator version: 7.8.0")
public class CustomerStoreRequest {
  public static final String SERIALIZED_NAME_EXTERNAL_ID = "externalId";
  @SerializedName(SERIALIZED_NAME_EXTERNAL_ID)
  private String externalId;

  /**
   * Onboarding status of the customer to be stored in the Trust Platform. Use the FINISHED status only if you have collected all required data of the customer.
   */
  @JsonAdapter(OnboardingStatusEnum.Adapter.class)
  public enum OnboardingStatusEnum {
    IN_PROGRESS("IN_PROGRESS"),
    
    FINISHED("FINISHED"),
    
    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private String value;

    OnboardingStatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static OnboardingStatusEnum fromValue(String value) {
      for (OnboardingStatusEnum b : OnboardingStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return UNKNOWN_DEFAULT_OPEN_API;
    }

    public static class Adapter extends TypeAdapter<OnboardingStatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OnboardingStatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OnboardingStatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return OnboardingStatusEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      OnboardingStatusEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_ONBOARDING_STATUS = "onboardingStatus";
  @SerializedName(SERIALIZED_NAME_ONBOARDING_STATUS)
  private OnboardingStatusEnum onboardingStatus;

  public CustomerStoreRequest() {
  }

  public CustomerStoreRequest externalId(String externalId) {
    this.externalId = externalId;
    return this;
  }

  /**
   * External identifier of the customer (for pairing between Trust Platform and external database), limited to alphanumeric, &#39;.&#39;, &#39;-&#39; and &#39;_&#39; characters and maximum length of 64. If not supplied, the UUID of the customer present in the request URL is used instead.
   * @return externalId
   */
  @javax.annotation.Nullable
  public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }


  public CustomerStoreRequest onboardingStatus(OnboardingStatusEnum onboardingStatus) {
    this.onboardingStatus = onboardingStatus;
    return this;
  }

  /**
   * Onboarding status of the customer to be stored in the Trust Platform. Use the FINISHED status only if you have collected all required data of the customer.
   * @return onboardingStatus
   */
  @javax.annotation.Nonnull
  public OnboardingStatusEnum getOnboardingStatus() {
    return onboardingStatus;
  }

  public void setOnboardingStatus(OnboardingStatusEnum onboardingStatus) {
    this.onboardingStatus = onboardingStatus;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerStoreRequest customerStoreRequest = (CustomerStoreRequest) o;
    return Objects.equals(this.externalId, customerStoreRequest.externalId) &&
        Objects.equals(this.onboardingStatus, customerStoreRequest.onboardingStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalId, onboardingStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerStoreRequest {\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    onboardingStatus: ").append(toIndentedString(onboardingStatus)).append("\n");
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
    openapiFields.add("externalId");
    openapiFields.add("onboardingStatus");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("onboardingStatus");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to CustomerStoreRequest
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!CustomerStoreRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CustomerStoreRequest is not found in the empty JSON string", CustomerStoreRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!CustomerStoreRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CustomerStoreRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CustomerStoreRequest.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("externalId") != null && !jsonObj.get("externalId").isJsonNull()) && !jsonObj.get("externalId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `externalId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("externalId").toString()));
      }
      if (!jsonObj.get("onboardingStatus").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `onboardingStatus` to be a primitive type in the JSON string but got `%s`", jsonObj.get("onboardingStatus").toString()));
      }
      // validate the required field `onboardingStatus`
      OnboardingStatusEnum.validateJsonElement(jsonObj.get("onboardingStatus"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CustomerStoreRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CustomerStoreRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CustomerStoreRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CustomerStoreRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<CustomerStoreRequest>() {
           @Override
           public void write(JsonWriter out, CustomerStoreRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CustomerStoreRequest read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of CustomerStoreRequest given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CustomerStoreRequest
   * @throws IOException if the JSON string is invalid with respect to CustomerStoreRequest
   */
  public static CustomerStoreRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CustomerStoreRequest.class);
  }

  /**
   * Convert an instance of CustomerStoreRequest to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


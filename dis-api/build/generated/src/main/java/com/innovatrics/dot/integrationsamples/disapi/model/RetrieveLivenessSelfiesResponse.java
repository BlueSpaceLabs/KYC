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
import com.innovatrics.dot.integrationsamples.disapi.model.LivenessRecordSelfie;
import com.innovatrics.dot.integrationsamples.disapi.model.LivenessSelfie;
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
 * RetrieveLivenessSelfiesResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-19T13:31:50.465535+05:30[Asia/Kolkata]", comments = "Generator version: 7.8.0")
public class RetrieveLivenessSelfiesResponse {
  public static final String SERIALIZED_NAME_SELFIES = "selfies";
  @SerializedName(SERIALIZED_NAME_SELFIES)
  private List<LivenessSelfie> selfies = new ArrayList<>();

  public static final String SERIALIZED_NAME_RECORD_SELFIES = "recordSelfies";
  @SerializedName(SERIALIZED_NAME_RECORD_SELFIES)
  private List<LivenessRecordSelfie> recordSelfies = new ArrayList<>();

  public RetrieveLivenessSelfiesResponse() {
  }

  public RetrieveLivenessSelfiesResponse(
     List<LivenessSelfie> selfies, 
     List<LivenessRecordSelfie> recordSelfies
  ) {
    this();
    this.selfies = selfies;
    this.recordSelfies = recordSelfies;
  }

  /**
   * Get selfies
   * @return selfies
   */
  @javax.annotation.Nullable
  public List<LivenessSelfie> getSelfies() {
    return selfies;
  }



  /**
   * Get recordSelfies
   * @return recordSelfies
   */
  @javax.annotation.Nullable
  public List<LivenessRecordSelfie> getRecordSelfies() {
    return recordSelfies;
  }




  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RetrieveLivenessSelfiesResponse retrieveLivenessSelfiesResponse = (RetrieveLivenessSelfiesResponse) o;
    return Objects.equals(this.selfies, retrieveLivenessSelfiesResponse.selfies) &&
        Objects.equals(this.recordSelfies, retrieveLivenessSelfiesResponse.recordSelfies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(selfies, recordSelfies);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RetrieveLivenessSelfiesResponse {\n");
    sb.append("    selfies: ").append(toIndentedString(selfies)).append("\n");
    sb.append("    recordSelfies: ").append(toIndentedString(recordSelfies)).append("\n");
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
    openapiFields.add("selfies");
    openapiFields.add("recordSelfies");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to RetrieveLivenessSelfiesResponse
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!RetrieveLivenessSelfiesResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RetrieveLivenessSelfiesResponse is not found in the empty JSON string", RetrieveLivenessSelfiesResponse.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!RetrieveLivenessSelfiesResponse.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RetrieveLivenessSelfiesResponse` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (jsonObj.get("selfies") != null && !jsonObj.get("selfies").isJsonNull()) {
        JsonArray jsonArrayselfies = jsonObj.getAsJsonArray("selfies");
        if (jsonArrayselfies != null) {
          // ensure the json data is an array
          if (!jsonObj.get("selfies").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `selfies` to be an array in the JSON string but got `%s`", jsonObj.get("selfies").toString()));
          }

          // validate the optional field `selfies` (array)
          for (int i = 0; i < jsonArrayselfies.size(); i++) {
            LivenessSelfie.validateJsonElement(jsonArrayselfies.get(i));
          };
        }
      }
      if (jsonObj.get("recordSelfies") != null && !jsonObj.get("recordSelfies").isJsonNull()) {
        JsonArray jsonArrayrecordSelfies = jsonObj.getAsJsonArray("recordSelfies");
        if (jsonArrayrecordSelfies != null) {
          // ensure the json data is an array
          if (!jsonObj.get("recordSelfies").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `recordSelfies` to be an array in the JSON string but got `%s`", jsonObj.get("recordSelfies").toString()));
          }

          // validate the optional field `recordSelfies` (array)
          for (int i = 0; i < jsonArrayrecordSelfies.size(); i++) {
            LivenessRecordSelfie.validateJsonElement(jsonArrayrecordSelfies.get(i));
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RetrieveLivenessSelfiesResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RetrieveLivenessSelfiesResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RetrieveLivenessSelfiesResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RetrieveLivenessSelfiesResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<RetrieveLivenessSelfiesResponse>() {
           @Override
           public void write(JsonWriter out, RetrieveLivenessSelfiesResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RetrieveLivenessSelfiesResponse read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of RetrieveLivenessSelfiesResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of RetrieveLivenessSelfiesResponse
   * @throws IOException if the JSON string is invalid with respect to RetrieveLivenessSelfiesResponse
   */
  public static RetrieveLivenessSelfiesResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RetrieveLivenessSelfiesResponse.class);
  }

  /**
   * Convert an instance of RetrieveLivenessSelfiesResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


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
 * GlassesResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-19T13:31:50.465535+05:30[Asia/Kolkata]", comments = "Generator version: 7.8.0")
public class GlassesResponse {
  public static final String SERIALIZED_NAME_SCORE = "score";
  @SerializedName(SERIALIZED_NAME_SCORE)
  private Double score;

  public static final String SERIALIZED_NAME_TINTED = "tinted";
  @SerializedName(SERIALIZED_NAME_TINTED)
  private Double tinted;

  public static final String SERIALIZED_NAME_HEAVY_FRAME = "heavyFrame";
  @SerializedName(SERIALIZED_NAME_HEAVY_FRAME)
  private Double heavyFrame;

  public GlassesResponse() {
  }

  public GlassesResponse(
     Double score, 
     Double tinted, 
     Double heavyFrame
  ) {
    this();
    this.score = score;
    this.tinted = tinted;
    this.heavyFrame = heavyFrame;
  }

  /**
   * The glasses score
   * minimum: 0
   * maximum: 1
   * @return score
   */
  @javax.annotation.Nullable
  public Double getScore() {
    return score;
  }



  /**
   * The tinted glasses score
   * minimum: 0
   * maximum: 1
   * @return tinted
   */
  @javax.annotation.Nullable
  public Double getTinted() {
    return tinted;
  }



  /**
   * The glasses with heavy frame score
   * minimum: 0
   * maximum: 1
   * @return heavyFrame
   */
  @javax.annotation.Nullable
  public Double getHeavyFrame() {
    return heavyFrame;
  }




  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GlassesResponse glassesResponse = (GlassesResponse) o;
    return Objects.equals(this.score, glassesResponse.score) &&
        Objects.equals(this.tinted, glassesResponse.tinted) &&
        Objects.equals(this.heavyFrame, glassesResponse.heavyFrame);
  }

  @Override
  public int hashCode() {
    return Objects.hash(score, tinted, heavyFrame);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GlassesResponse {\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
    sb.append("    tinted: ").append(toIndentedString(tinted)).append("\n");
    sb.append("    heavyFrame: ").append(toIndentedString(heavyFrame)).append("\n");
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
    openapiFields.add("score");
    openapiFields.add("tinted");
    openapiFields.add("heavyFrame");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to GlassesResponse
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!GlassesResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in GlassesResponse is not found in the empty JSON string", GlassesResponse.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!GlassesResponse.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `GlassesResponse` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GlassesResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GlassesResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GlassesResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GlassesResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<GlassesResponse>() {
           @Override
           public void write(JsonWriter out, GlassesResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public GlassesResponse read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of GlassesResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of GlassesResponse
   * @throws IOException if the JSON string is invalid with respect to GlassesResponse
   */
  public static GlassesResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GlassesResponse.class);
  }

  /**
   * Convert an instance of GlassesResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


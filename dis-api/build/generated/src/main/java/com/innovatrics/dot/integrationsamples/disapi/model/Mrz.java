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
import com.innovatrics.dot.integrationsamples.disapi.model.Td1Mrz;
import com.innovatrics.dot.integrationsamples.disapi.model.Td2Mrz;
import com.innovatrics.dot.integrationsamples.disapi.model.Td3Mrz;
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
 * Parsed machine readable zone
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-19T13:31:50.465535+05:30[Asia/Kolkata]", comments = "Generator version: 7.8.0")
public class Mrz {
  public static final String SERIALIZED_NAME_TD1 = "td1";
  @SerializedName(SERIALIZED_NAME_TD1)
  private Td1Mrz td1;

  public static final String SERIALIZED_NAME_TD2 = "td2";
  @SerializedName(SERIALIZED_NAME_TD2)
  private Td2Mrz td2;

  public static final String SERIALIZED_NAME_TD3 = "td3";
  @SerializedName(SERIALIZED_NAME_TD3)
  private Td3Mrz td3;

  public Mrz() {
  }

  public Mrz td1(Td1Mrz td1) {
    this.td1 = td1;
    return this;
  }

  /**
   * Get td1
   * @return td1
   */
  @javax.annotation.Nullable
  public Td1Mrz getTd1() {
    return td1;
  }

  public void setTd1(Td1Mrz td1) {
    this.td1 = td1;
  }


  public Mrz td2(Td2Mrz td2) {
    this.td2 = td2;
    return this;
  }

  /**
   * Get td2
   * @return td2
   */
  @javax.annotation.Nullable
  public Td2Mrz getTd2() {
    return td2;
  }

  public void setTd2(Td2Mrz td2) {
    this.td2 = td2;
  }


  public Mrz td3(Td3Mrz td3) {
    this.td3 = td3;
    return this;
  }

  /**
   * Get td3
   * @return td3
   */
  @javax.annotation.Nullable
  public Td3Mrz getTd3() {
    return td3;
  }

  public void setTd3(Td3Mrz td3) {
    this.td3 = td3;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Mrz mrz = (Mrz) o;
    return Objects.equals(this.td1, mrz.td1) &&
        Objects.equals(this.td2, mrz.td2) &&
        Objects.equals(this.td3, mrz.td3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(td1, td2, td3);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Mrz {\n");
    sb.append("    td1: ").append(toIndentedString(td1)).append("\n");
    sb.append("    td2: ").append(toIndentedString(td2)).append("\n");
    sb.append("    td3: ").append(toIndentedString(td3)).append("\n");
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
    openapiFields.add("td1");
    openapiFields.add("td2");
    openapiFields.add("td3");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to Mrz
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Mrz.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Mrz is not found in the empty JSON string", Mrz.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Mrz.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Mrz` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the optional field `td1`
      if (jsonObj.get("td1") != null && !jsonObj.get("td1").isJsonNull()) {
        Td1Mrz.validateJsonElement(jsonObj.get("td1"));
      }
      // validate the optional field `td2`
      if (jsonObj.get("td2") != null && !jsonObj.get("td2").isJsonNull()) {
        Td2Mrz.validateJsonElement(jsonObj.get("td2"));
      }
      // validate the optional field `td3`
      if (jsonObj.get("td3") != null && !jsonObj.get("td3").isJsonNull()) {
        Td3Mrz.validateJsonElement(jsonObj.get("td3"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Mrz.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Mrz' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Mrz> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Mrz.class));

       return (TypeAdapter<T>) new TypeAdapter<Mrz>() {
           @Override
           public void write(JsonWriter out, Mrz value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Mrz read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of Mrz given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of Mrz
   * @throws IOException if the JSON string is invalid with respect to Mrz
   */
  public static Mrz fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Mrz.class);
  }

  /**
   * Convert an instance of Mrz to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


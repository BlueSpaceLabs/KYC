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
import com.innovatrics.dot.integrationsamples.disapi.model.Point;
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
 * The region of the interest. The coordinates of the rectangle.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-19T13:31:50.465535+05:30[Asia/Kolkata]", comments = "Generator version: 7.8.0")
public class Roi {
  public static final String SERIALIZED_NAME_TOP_LEFT = "topLeft";
  @SerializedName(SERIALIZED_NAME_TOP_LEFT)
  private Point topLeft;

  public static final String SERIALIZED_NAME_TOP_RIGHT = "topRight";
  @SerializedName(SERIALIZED_NAME_TOP_RIGHT)
  private Point topRight;

  public static final String SERIALIZED_NAME_BOTTOM_RIGHT = "bottomRight";
  @SerializedName(SERIALIZED_NAME_BOTTOM_RIGHT)
  private Point bottomRight;

  public static final String SERIALIZED_NAME_BOTTOM_LEFT = "bottomLeft";
  @SerializedName(SERIALIZED_NAME_BOTTOM_LEFT)
  private Point bottomLeft;

  public Roi() {
  }

  public Roi topLeft(Point topLeft) {
    this.topLeft = topLeft;
    return this;
  }

  /**
   * Get topLeft
   * @return topLeft
   */
  @javax.annotation.Nonnull
  public Point getTopLeft() {
    return topLeft;
  }

  public void setTopLeft(Point topLeft) {
    this.topLeft = topLeft;
  }


  public Roi topRight(Point topRight) {
    this.topRight = topRight;
    return this;
  }

  /**
   * Get topRight
   * @return topRight
   */
  @javax.annotation.Nonnull
  public Point getTopRight() {
    return topRight;
  }

  public void setTopRight(Point topRight) {
    this.topRight = topRight;
  }


  public Roi bottomRight(Point bottomRight) {
    this.bottomRight = bottomRight;
    return this;
  }

  /**
   * Get bottomRight
   * @return bottomRight
   */
  @javax.annotation.Nonnull
  public Point getBottomRight() {
    return bottomRight;
  }

  public void setBottomRight(Point bottomRight) {
    this.bottomRight = bottomRight;
  }


  public Roi bottomLeft(Point bottomLeft) {
    this.bottomLeft = bottomLeft;
    return this;
  }

  /**
   * Get bottomLeft
   * @return bottomLeft
   */
  @javax.annotation.Nonnull
  public Point getBottomLeft() {
    return bottomLeft;
  }

  public void setBottomLeft(Point bottomLeft) {
    this.bottomLeft = bottomLeft;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Roi roi = (Roi) o;
    return Objects.equals(this.topLeft, roi.topLeft) &&
        Objects.equals(this.topRight, roi.topRight) &&
        Objects.equals(this.bottomRight, roi.bottomRight) &&
        Objects.equals(this.bottomLeft, roi.bottomLeft);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topLeft, topRight, bottomRight, bottomLeft);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Roi {\n");
    sb.append("    topLeft: ").append(toIndentedString(topLeft)).append("\n");
    sb.append("    topRight: ").append(toIndentedString(topRight)).append("\n");
    sb.append("    bottomRight: ").append(toIndentedString(bottomRight)).append("\n");
    sb.append("    bottomLeft: ").append(toIndentedString(bottomLeft)).append("\n");
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
    openapiFields.add("topLeft");
    openapiFields.add("topRight");
    openapiFields.add("bottomRight");
    openapiFields.add("bottomLeft");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("topLeft");
    openapiRequiredFields.add("topRight");
    openapiRequiredFields.add("bottomRight");
    openapiRequiredFields.add("bottomLeft");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to Roi
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Roi.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Roi is not found in the empty JSON string", Roi.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Roi.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Roi` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : Roi.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the required field `topLeft`
      Point.validateJsonElement(jsonObj.get("topLeft"));
      // validate the required field `topRight`
      Point.validateJsonElement(jsonObj.get("topRight"));
      // validate the required field `bottomRight`
      Point.validateJsonElement(jsonObj.get("bottomRight"));
      // validate the required field `bottomLeft`
      Point.validateJsonElement(jsonObj.get("bottomLeft"));
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Roi.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Roi' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Roi> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Roi.class));

       return (TypeAdapter<T>) new TypeAdapter<Roi>() {
           @Override
           public void write(JsonWriter out, Roi value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Roi read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of Roi given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of Roi
   * @throws IOException if the JSON string is invalid with respect to Roi
   */
  public static Roi fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Roi.class);
  }

  /**
   * Convert an instance of Roi to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


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
 * Values for the given textual attribute retrieved by:- OCR from different sources on the document photo.- Reading from the document&#39;s chip
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-19T13:31:50.465535+05:30[Asia/Kolkata]", comments = "Generator version: 7.8.0")
public class MultiValueAttributeWithoutMrz {
  public static final String SERIALIZED_NAME_VISUAL_ZONE = "visualZone";
  @SerializedName(SERIALIZED_NAME_VISUAL_ZONE)
  private String visualZone;

  public static final String SERIALIZED_NAME_VISUAL_ZONE_DUPLICATES = "visualZoneDuplicates";
  @SerializedName(SERIALIZED_NAME_VISUAL_ZONE_DUPLICATES)
  private List<String> visualZoneDuplicates = new ArrayList<>();

  public static final String SERIALIZED_NAME_CHIP = "chip";
  @SerializedName(SERIALIZED_NAME_CHIP)
  private String chip;

  public static final String SERIALIZED_NAME_BARCODE = "barcode";
  @SerializedName(SERIALIZED_NAME_BARCODE)
  private String barcode;

  public MultiValueAttributeWithoutMrz() {
  }

  public MultiValueAttributeWithoutMrz(
     String visualZone, 
     List<String> visualZoneDuplicates, 
     String chip, 
     String barcode
  ) {
    this();
    this.visualZone = visualZone;
    this.visualZoneDuplicates = visualZoneDuplicates;
    this.chip = chip;
    this.barcode = barcode;
  }

  /**
   * The attribute value obtained from the document&#39;s visual zone.
   * @return visualZone
   */
  @javax.annotation.Nullable
  public String getVisualZone() {
    return visualZone;
  }



  /**
   * The attribute is a duplicated field type on the document, the value is obtained from the document&#39;s visual zone.
   * @return visualZoneDuplicates
   */
  @javax.annotation.Nullable
  public List<String> getVisualZoneDuplicates() {
    return visualZoneDuplicates;
  }



  /**
   * The attribute value obtained from the document&#39;s chip.
   * @return chip
   */
  @javax.annotation.Nullable
  public String getChip() {
    return chip;
  }



  /**
   * The attribute value obtained from the document&#39;s barcode.
   * @return barcode
   */
  @javax.annotation.Nullable
  public String getBarcode() {
    return barcode;
  }




  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MultiValueAttributeWithoutMrz multiValueAttributeWithoutMrz = (MultiValueAttributeWithoutMrz) o;
    return Objects.equals(this.visualZone, multiValueAttributeWithoutMrz.visualZone) &&
        Objects.equals(this.visualZoneDuplicates, multiValueAttributeWithoutMrz.visualZoneDuplicates) &&
        Objects.equals(this.chip, multiValueAttributeWithoutMrz.chip) &&
        Objects.equals(this.barcode, multiValueAttributeWithoutMrz.barcode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(visualZone, visualZoneDuplicates, chip, barcode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MultiValueAttributeWithoutMrz {\n");
    sb.append("    visualZone: ").append(toIndentedString(visualZone)).append("\n");
    sb.append("    visualZoneDuplicates: ").append(toIndentedString(visualZoneDuplicates)).append("\n");
    sb.append("    chip: ").append(toIndentedString(chip)).append("\n");
    sb.append("    barcode: ").append(toIndentedString(barcode)).append("\n");
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
    openapiFields.add("visualZone");
    openapiFields.add("visualZoneDuplicates");
    openapiFields.add("chip");
    openapiFields.add("barcode");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to MultiValueAttributeWithoutMrz
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!MultiValueAttributeWithoutMrz.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in MultiValueAttributeWithoutMrz is not found in the empty JSON string", MultiValueAttributeWithoutMrz.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!MultiValueAttributeWithoutMrz.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `MultiValueAttributeWithoutMrz` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("visualZone") != null && !jsonObj.get("visualZone").isJsonNull()) && !jsonObj.get("visualZone").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `visualZone` to be a primitive type in the JSON string but got `%s`", jsonObj.get("visualZone").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("visualZoneDuplicates") != null && !jsonObj.get("visualZoneDuplicates").isJsonNull() && !jsonObj.get("visualZoneDuplicates").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `visualZoneDuplicates` to be an array in the JSON string but got `%s`", jsonObj.get("visualZoneDuplicates").toString()));
      }
      if ((jsonObj.get("chip") != null && !jsonObj.get("chip").isJsonNull()) && !jsonObj.get("chip").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `chip` to be a primitive type in the JSON string but got `%s`", jsonObj.get("chip").toString()));
      }
      if ((jsonObj.get("barcode") != null && !jsonObj.get("barcode").isJsonNull()) && !jsonObj.get("barcode").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `barcode` to be a primitive type in the JSON string but got `%s`", jsonObj.get("barcode").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!MultiValueAttributeWithoutMrz.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'MultiValueAttributeWithoutMrz' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<MultiValueAttributeWithoutMrz> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(MultiValueAttributeWithoutMrz.class));

       return (TypeAdapter<T>) new TypeAdapter<MultiValueAttributeWithoutMrz>() {
           @Override
           public void write(JsonWriter out, MultiValueAttributeWithoutMrz value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public MultiValueAttributeWithoutMrz read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of MultiValueAttributeWithoutMrz given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of MultiValueAttributeWithoutMrz
   * @throws IOException if the JSON string is invalid with respect to MultiValueAttributeWithoutMrz
   */
  public static MultiValueAttributeWithoutMrz fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, MultiValueAttributeWithoutMrz.class);
  }

  /**
   * Convert an instance of MultiValueAttributeWithoutMrz to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


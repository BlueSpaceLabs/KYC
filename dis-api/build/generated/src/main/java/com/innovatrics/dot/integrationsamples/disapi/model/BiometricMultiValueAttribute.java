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
 * Values for the given biometric attribute retrieved from different sources by facial biometry or by OCR.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-19T13:31:50.465535+05:30[Asia/Kolkata]", comments = "Generator version: 7.8.0")
public class BiometricMultiValueAttribute {
  public static final String SERIALIZED_NAME_VISUAL_ZONE = "visualZone";
  @SerializedName(SERIALIZED_NAME_VISUAL_ZONE)
  private String visualZone;

  public static final String SERIALIZED_NAME_VISUAL_ZONE_DUPLICATES = "visualZoneDuplicates";
  @SerializedName(SERIALIZED_NAME_VISUAL_ZONE_DUPLICATES)
  private List<String> visualZoneDuplicates = new ArrayList<>();

  public static final String SERIALIZED_NAME_MRZ = "mrz";
  @SerializedName(SERIALIZED_NAME_MRZ)
  private String mrz;

  public static final String SERIALIZED_NAME_CHIP = "chip";
  @SerializedName(SERIALIZED_NAME_CHIP)
  private String chip;

  public static final String SERIALIZED_NAME_SELFIE = "selfie";
  @SerializedName(SERIALIZED_NAME_SELFIE)
  private String selfie;

  public static final String SERIALIZED_NAME_DOCUMENT_PORTRAIT = "documentPortrait";
  @SerializedName(SERIALIZED_NAME_DOCUMENT_PORTRAIT)
  private String documentPortrait;

  public BiometricMultiValueAttribute() {
  }

  public BiometricMultiValueAttribute(
     String visualZone, 
     List<String> visualZoneDuplicates, 
     String mrz, 
     String chip, 
     String selfie, 
     String documentPortrait
  ) {
    this();
    this.visualZone = visualZone;
    this.visualZoneDuplicates = visualZoneDuplicates;
    this.mrz = mrz;
    this.chip = chip;
    this.selfie = selfie;
    this.documentPortrait = documentPortrait;
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
   * The attribute value obtained from the document&#39;s machine readable zone.
   * @return mrz
   */
  @javax.annotation.Nullable
  public String getMrz() {
    return mrz;
  }



  /**
   * The attribute value read from the document&#39;s chip.
   * @return chip
   */
  @javax.annotation.Nullable
  public String getChip() {
    return chip;
  }



  /**
   * The attribute value obtained from the selfie.
   * @return selfie
   */
  @javax.annotation.Nullable
  public String getSelfie() {
    return selfie;
  }



  /**
   * The attribute value obtained from the document&#39;s portrait.
   * @return documentPortrait
   */
  @javax.annotation.Nullable
  public String getDocumentPortrait() {
    return documentPortrait;
  }




  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BiometricMultiValueAttribute biometricMultiValueAttribute = (BiometricMultiValueAttribute) o;
    return Objects.equals(this.visualZone, biometricMultiValueAttribute.visualZone) &&
        Objects.equals(this.visualZoneDuplicates, biometricMultiValueAttribute.visualZoneDuplicates) &&
        Objects.equals(this.mrz, biometricMultiValueAttribute.mrz) &&
        Objects.equals(this.chip, biometricMultiValueAttribute.chip) &&
        Objects.equals(this.selfie, biometricMultiValueAttribute.selfie) &&
        Objects.equals(this.documentPortrait, biometricMultiValueAttribute.documentPortrait);
  }

  @Override
  public int hashCode() {
    return Objects.hash(visualZone, visualZoneDuplicates, mrz, chip, selfie, documentPortrait);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BiometricMultiValueAttribute {\n");
    sb.append("    visualZone: ").append(toIndentedString(visualZone)).append("\n");
    sb.append("    visualZoneDuplicates: ").append(toIndentedString(visualZoneDuplicates)).append("\n");
    sb.append("    mrz: ").append(toIndentedString(mrz)).append("\n");
    sb.append("    chip: ").append(toIndentedString(chip)).append("\n");
    sb.append("    selfie: ").append(toIndentedString(selfie)).append("\n");
    sb.append("    documentPortrait: ").append(toIndentedString(documentPortrait)).append("\n");
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
    openapiFields.add("mrz");
    openapiFields.add("chip");
    openapiFields.add("selfie");
    openapiFields.add("documentPortrait");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to BiometricMultiValueAttribute
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!BiometricMultiValueAttribute.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in BiometricMultiValueAttribute is not found in the empty JSON string", BiometricMultiValueAttribute.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!BiometricMultiValueAttribute.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `BiometricMultiValueAttribute` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
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
      if ((jsonObj.get("mrz") != null && !jsonObj.get("mrz").isJsonNull()) && !jsonObj.get("mrz").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `mrz` to be a primitive type in the JSON string but got `%s`", jsonObj.get("mrz").toString()));
      }
      if ((jsonObj.get("chip") != null && !jsonObj.get("chip").isJsonNull()) && !jsonObj.get("chip").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `chip` to be a primitive type in the JSON string but got `%s`", jsonObj.get("chip").toString()));
      }
      if ((jsonObj.get("selfie") != null && !jsonObj.get("selfie").isJsonNull()) && !jsonObj.get("selfie").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `selfie` to be a primitive type in the JSON string but got `%s`", jsonObj.get("selfie").toString()));
      }
      if ((jsonObj.get("documentPortrait") != null && !jsonObj.get("documentPortrait").isJsonNull()) && !jsonObj.get("documentPortrait").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `documentPortrait` to be a primitive type in the JSON string but got `%s`", jsonObj.get("documentPortrait").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!BiometricMultiValueAttribute.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'BiometricMultiValueAttribute' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<BiometricMultiValueAttribute> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(BiometricMultiValueAttribute.class));

       return (TypeAdapter<T>) new TypeAdapter<BiometricMultiValueAttribute>() {
           @Override
           public void write(JsonWriter out, BiometricMultiValueAttribute value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public BiometricMultiValueAttribute read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of BiometricMultiValueAttribute given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of BiometricMultiValueAttribute
   * @throws IOException if the JSON string is invalid with respect to BiometricMultiValueAttribute
   */
  public static BiometricMultiValueAttribute fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, BiometricMultiValueAttribute.class);
  }

  /**
   * Convert an instance of BiometricMultiValueAttribute to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


package org.techdisqus.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.techdisqus.request.KycRequestHeaders;
import org.techdisqus.response.Entity;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.core.io.Resource;

@Component
public class AddressServiceImpl implements AddressService {

    private List<Province> provinces;
    private List<City> cities;
    private List<Barangay> barnagays;

    @Value("classpath:address/province.json")
    private Resource provinceResource;

    @Value("classpath:address/cities.json")
    private Resource citiesResource;

    @Value("classpath:address/barangays.json")
    private Resource barangaysResource;

    @SneakyThrows
    @Override
    public List<Entity> getEntities(String code, String type, KycRequestHeaders kycRequestHeaders) {

        if (type.equals("province")) {

            return provinces.stream().map(province -> Entity.builder()
                    .name(province.getProvinceName())
                    .code(province.getProvinceCode())
                    .build()).toList();

        } else if (type.equals("cities")) {

            return cities.stream()
                    .filter(city -> city.getProvinceCode().equals(code))
                    .map(city -> Entity.builder()
                            .name(city.getCityName())
                            .code(city.getCityCode())
                            .build()).toList();
        } else if (type.equals("barangays")) {

            return barnagays.stream()
                    .filter(barangay -> barangay.getCityCode().equals(code))
                    .map(barangay -> Entity.builder()
                            .name(barangay.getBrgyName())
                            .code(barangay.getBrgyCode())
                            .build()).toList();
        }


        return List.of();
    }

    @Data
    @NoArgsConstructor
    public static class Province {
        @JsonProperty("province_code")
        private String provinceCode;

        @JsonProperty("province_name")
        private String provinceName;

        @JsonProperty("psgc_code")
        private String psgcCode;

        @JsonProperty("region_code")
        private String regionCode;

        // Getters and setters...
    }


    @Data
    @NoArgsConstructor
    private static class City {

        @JsonProperty("city_code")
        private String cityCode;

        @JsonProperty("city_name")
        private String cityName;

        @JsonProperty("province_code")
        private String provinceCode;

        @JsonProperty("psgc_code")
        private String psgcCode;

        @JsonProperty("region_desc")
        private String regionDesc;


    }

    @Data
    @NoArgsConstructor
    public static class Barangay {

        @JsonProperty("brgy_code")
        private String brgyCode;

        @JsonProperty("brgy_name")
        private String brgyName;

        @JsonProperty("city_code")
        private String cityCode;

        @JsonProperty("province_code")
        private String provinceCode;

        @JsonProperty("region_code")
        private String regionCode;
    }

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        new Thread(() -> {
            try (InputStream inputStream = provinceResource.getInputStream()) {
                provinces = mapper.readValue(inputStream, new TypeReference<>() {
                });
            } catch (Exception e) {
                throw new RuntimeException("Failed to load provinces", e);
            }
        }).start();

        new Thread(() -> {
            try (InputStream inputStream = citiesResource.getInputStream()) {

                cities = mapper.readValue(inputStream, new TypeReference<>() {
                });
            } catch (Exception e) {
                throw new RuntimeException("Failed to load provinces", e);
            }
        }).start();

        new Thread(() -> {
            try (InputStream inputStream = barangaysResource.getInputStream()) {
                barnagays = mapper.readValue(inputStream, new TypeReference<>() {
                });
            } catch (Exception e) {
                throw new RuntimeException("Failed to load provinces", e);
            }
        }).start();
    }


}

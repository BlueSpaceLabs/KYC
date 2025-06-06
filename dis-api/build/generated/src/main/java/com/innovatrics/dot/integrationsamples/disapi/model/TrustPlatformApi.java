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

import com.innovatrics.dot.integrationsamples.disapi.ApiCallback;
import com.innovatrics.dot.integrationsamples.disapi.ApiClient;
import com.innovatrics.dot.integrationsamples.disapi.ApiException;
import com.innovatrics.dot.integrationsamples.disapi.ApiResponse;
import com.innovatrics.dot.integrationsamples.disapi.Configuration;
import com.innovatrics.dot.integrationsamples.disapi.Pair;
import com.innovatrics.dot.integrationsamples.disapi.ProgressRequestBody;
import com.innovatrics.dot.integrationsamples.disapi.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.innovatrics.dot.integrationsamples.disapi.model.CustomerStoreRequest;
import com.innovatrics.dot.integrationsamples.disapi.model.ErrorResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrustPlatformApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public TrustPlatformApi() {
        this(Configuration.getDefaultApiClient());
    }

    public TrustPlatformApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for storeInTrustPlatform
     * @param id  (required)
     * @param customerStoreRequest  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 500 </td><td> Internal Server Error  Possible error codes:  - UNEXPECTED_ERROR </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad request  Possible error codes:  - INVALID_ID  - INVALID_REQUEST_BODY </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Conflict  Possible error codes:  - CONFLICT </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not found  Possible error codes:  - NOT_FOUND </td><td>  -  </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call storeInTrustPlatformCall(String id, CustomerStoreRequest customerStoreRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = customerStoreRequest;

        // create path and map variables
        String localVarPath = "/api/v1/customers/{id}/store"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "api" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call storeInTrustPlatformValidateBeforeCall(String id, CustomerStoreRequest customerStoreRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling storeInTrustPlatform(Async)");
        }

        // verify the required parameter 'customerStoreRequest' is set
        if (customerStoreRequest == null) {
            throw new ApiException("Missing the required parameter 'customerStoreRequest' when calling storeInTrustPlatform(Async)");
        }

        return storeInTrustPlatformCall(id, customerStoreRequest, _callback);

    }

    /**
     * Store customer in the Trust Platform
     * 
     * @param id  (required)
     * @param customerStoreRequest  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 500 </td><td> Internal Server Error  Possible error codes:  - UNEXPECTED_ERROR </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad request  Possible error codes:  - INVALID_ID  - INVALID_REQUEST_BODY </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Conflict  Possible error codes:  - CONFLICT </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not found  Possible error codes:  - NOT_FOUND </td><td>  -  </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
     </table>
     */
    public void storeInTrustPlatform(String id, CustomerStoreRequest customerStoreRequest) throws ApiException {
        storeInTrustPlatformWithHttpInfo(id, customerStoreRequest);
    }

    /**
     * Store customer in the Trust Platform
     * 
     * @param id  (required)
     * @param customerStoreRequest  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 500 </td><td> Internal Server Error  Possible error codes:  - UNEXPECTED_ERROR </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad request  Possible error codes:  - INVALID_ID  - INVALID_REQUEST_BODY </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Conflict  Possible error codes:  - CONFLICT </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not found  Possible error codes:  - NOT_FOUND </td><td>  -  </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Void> storeInTrustPlatformWithHttpInfo(String id, CustomerStoreRequest customerStoreRequest) throws ApiException {
        okhttp3.Call localVarCall = storeInTrustPlatformValidateBeforeCall(id, customerStoreRequest, null);
        return localVarApiClient.execute(localVarCall);
    }

    /**
     * Store customer in the Trust Platform (asynchronously)
     * 
     * @param id  (required)
     * @param customerStoreRequest  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 500 </td><td> Internal Server Error  Possible error codes:  - UNEXPECTED_ERROR </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Bad request  Possible error codes:  - INVALID_ID  - INVALID_REQUEST_BODY </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> Forbidden </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Conflict  Possible error codes:  - CONFLICT </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Unauthorized </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Not found  Possible error codes:  - NOT_FOUND </td><td>  -  </td></tr>
        <tr><td> 204 </td><td> No Content </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call storeInTrustPlatformAsync(String id, CustomerStoreRequest customerStoreRequest, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = storeInTrustPlatformValidateBeforeCall(id, customerStoreRequest, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }
}

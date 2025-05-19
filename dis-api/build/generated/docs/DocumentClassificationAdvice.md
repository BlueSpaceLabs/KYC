

# DocumentClassificationAdvice

Advice to the classification process defining the expected document type, issuing country, edition or type of travel document. This is optional input. If not provided, classification will try to match among all supported documents. If provided and document in image is different, an error is returned.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**countries** | **List&lt;String&gt;** | The list of Alpha-3 ISO 3166 country codes |  [optional] |
|**types** | **List&lt;String&gt;** | The list of the identity document types |  [optional] |
|**editions** | **List&lt;String&gt;** | The list of the document editions |  [optional] |
|**machineReadableTravelDocuments** | **List&lt;String&gt;** | The list of the MRZ types |  [optional] |






# CreateDocumentPageResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**documentType** | [**DocumentType**](DocumentType.md) |  |  [optional] |
|**pageType** | **String** | Document&#39;s page type |  [optional] [readonly] |
|**detection** | [**DocumentDetection**](DocumentDetection.md) |  |  [optional] |
|**errorCode** | [**ErrorCodeEnum**](#ErrorCodeEnum) | The document page processing error code |  [optional] [readonly] |
|**warnings** | [**List&lt;WarningsEnum&gt;**](#List&lt;WarningsEnum&gt;) | The document page processing warnings |  [optional] [readonly] |
|**links** | [**Links**](Links.md) |  |  [optional] |
|**additionalData** | [**ResourceData**](ResourceData.md) |  |  [optional] |



## Enum: ErrorCodeEnum

| Name | Value |
|---- | -----|
| NO_CARD_CORNERS_DETECTED | &quot;NO_CARD_CORNERS_DETECTED&quot; |
| PAGE_DOESNT_MATCH_DOCUMENT_TYPE_OF_PREVIOUS_PAGE | &quot;PAGE_DOESNT_MATCH_DOCUMENT_TYPE_OF_PREVIOUS_PAGE&quot; |
| INVALID_DATA | &quot;INVALID_DATA&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |



## Enum: List&lt;WarningsEnum&gt;

| Name | Value |
|---- | -----|
| PORTRAIT_NOT_GUARANTEED_OF_THE_SAME_PERSON | &quot;PORTRAIT_NOT_GUARANTEED_OF_THE_SAME_PERSON&quot; |
| MISSING_FRONT_PAGE | &quot;MISSING_FRONT_PAGE&quot; |
| DOCUMENT_TYPE_NOT_RECOGNIZED | &quot;DOCUMENT_TYPE_NOT_RECOGNIZED&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |




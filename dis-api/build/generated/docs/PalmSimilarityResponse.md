

# PalmSimilarityResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**score** | **Double** | The palm similarity score. The higher score indicates higher similarity of matched palms. |  [optional] [readonly] |
|**errorCode** | [**ErrorCodeEnum**](#ErrorCodeEnum) | The palm matching error code |  [optional] [readonly] |



## Enum: ErrorCodeEnum

| Name | Value |
|---- | -----|
| VERSION_MISMATCH | &quot;PALM_TEMPLATE_VERSION_MISMATCH&quot; |
| INVALID_DATA | &quot;PALM_TEMPLATE_INVALID_DATA&quot; |
| MATCHING_FAILED | &quot;PALM_TEMPLATE_MATCHING_FAILED&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |




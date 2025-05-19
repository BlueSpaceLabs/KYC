

# CreatePalmResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The palm&#39;s ID |  [optional] [readonly] |
|**detection** | [**PalmDetectionDto**](PalmDetectionDto.md) |  |  [optional] |
|**links** | [**Links**](Links.md) |  |  [optional] |
|**errorCode** | [**ErrorCodeEnum**](#ErrorCodeEnum) | The palm detection error code |  [optional] [readonly] |



## Enum: ErrorCodeEnum

| Name | Value |
|---- | -----|
| NO_PALM_DETECTED | &quot;NO_PALM_DETECTED&quot; |
| INVALID_DATA | &quot;INVALID_DATA&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |




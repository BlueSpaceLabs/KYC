

# CreateCustomerLivenessRecordResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**selfie** | [**SelfieFromLivenessRecord**](SelfieFromLivenessRecord.md) |  |  [optional] |
|**links** | [**LivenessRecordLinks**](LivenessRecordLinks.md) |  |  [optional] |
|**errorCode** | [**ErrorCodeEnum**](#ErrorCodeEnum) | The face detection error code |  [optional] [readonly] |
|**additionalData** | [**ResourceData**](ResourceData.md) |  |  [optional] |



## Enum: ErrorCodeEnum

| Name | Value |
|---- | -----|
| INVALID_DATA | &quot;INVALID_DATA&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |






# EvaluateCustomerLivenessResponse

Result of the liveness evaluation. Please, read the chapters \"Passive Liveness\" and \"Active Liveness\" of the DOT documentation to evaluate the calculated score.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**score** | **Double** | The liveness score |  [optional] [readonly] |
|**errorCode** | [**ErrorCodeEnum**](#ErrorCodeEnum) | The liveness error code |  [optional] [readonly] |



## Enum: ErrorCodeEnum

| Name | Value |
|---- | -----|
| NOT_ENOUGH_DATA | &quot;NOT_ENOUGH_DATA&quot; |
| INVALID_DATA | &quot;INVALID_DATA&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |




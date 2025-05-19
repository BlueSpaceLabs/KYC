

# CreateCustomerLivenessSelfieResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**errorCode** | [**ErrorCodeEnum**](#ErrorCodeEnum) | The face detection error code |  [optional] [readonly] |
|**warnings** | [**List&lt;WarningsEnum&gt;**](#List&lt;WarningsEnum&gt;) | The face detection warnings |  [optional] [readonly] |



## Enum: ErrorCodeEnum

| Name | Value |
|---- | -----|
| NO_FACE_DETECTED | &quot;NO_FACE_DETECTED&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |



## Enum: List&lt;WarningsEnum&gt;

| Name | Value |
|---- | -----|
| MULTIPLE_FACES_DETECTED | &quot;MULTIPLE_FACES_DETECTED&quot; |
| LOW_QUALITY | &quot;LOW_QUALITY&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |






# CreateFaceResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The face&#39;s ID |  [optional] [readonly] |
|**detection** | [**FaceDetection**](FaceDetection.md) |  |  [optional] |
|**links** | [**Links**](Links.md) |  |  [optional] |
|**errorCode** | [**ErrorCodeEnum**](#ErrorCodeEnum) | The face detection error code |  [optional] [readonly] |
|**warnings** | [**List&lt;WarningsEnum&gt;**](#List&lt;WarningsEnum&gt;) | The face detection warnings |  [optional] [readonly] |



## Enum: ErrorCodeEnum

| Name | Value |
|---- | -----|
| MULTIPLE_FACES_DETECTED | &quot;MULTIPLE_FACES_DETECTED&quot; |
| NO_FACE_DETECTED | &quot;NO_FACE_DETECTED&quot; |
| INVALID_DATA | &quot;INVALID_DATA&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |



## Enum: List&lt;WarningsEnum&gt;

| Name | Value |
|---- | -----|
| MULTIPLE_FACES_DETECTED | &quot;MULTIPLE_FACES_DETECTED&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |






# FaceDetectionProperties

The face detection properties

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**mode** | [**ModeEnum**](#ModeEnum) | The face detection mode. The &#x60;strict&#x60; detection detects face but returns error if multiple faces are detected in the image. The &#x60;free&#x60; detection detects faces in the image and returns the biggest one with warning if there are multiple faces detected.  |  [optional] |
|**faceSizeRatio** | [**FaceSizeRatio**](FaceSizeRatio.md) |  |  [optional] |



## Enum: ModeEnum

| Name | Value |
|---- | -----|
| FREE | &quot;FREE&quot; |
| STRICT | &quot;STRICT&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |






# CreateCustomerLivenessSelfieRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**image** | [**Image**](Image.md) |  |  [optional] |
|**selfieOrigin** | [**SelfieOrigin**](SelfieOrigin.md) |  |  [optional] |
|**assertion** | [**AssertionEnum**](#AssertionEnum) | Definition of the active liveness challenge that the customer&#39;s face has to display in the provided selfie photo. E.g. if it is expected that the face is looking to top left corner of the screen, assertion EYE_GAZE_TOP_LEFT has to be used. |  |



## Enum: AssertionEnum

| Name | Value |
|---- | -----|
| EYE_GAZE_TOP_LEFT | &quot;EYE_GAZE_TOP_LEFT&quot; |
| EYE_GAZE_TOP_RIGHT | &quot;EYE_GAZE_TOP_RIGHT&quot; |
| EYE_GAZE_BOTTOM_LEFT | &quot;EYE_GAZE_BOTTOM_LEFT&quot; |
| EYE_GAZE_BOTTOM_RIGHT | &quot;EYE_GAZE_BOTTOM_RIGHT&quot; |
| SMILE | &quot;SMILE&quot; |
| NEUTRAL | &quot;NEUTRAL&quot; |
| NONE | &quot;NONE&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |




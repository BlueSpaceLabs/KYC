

# DocumentPageQuality


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**fine** | **Boolean** | The quality check result |  [readonly] |
|**issues** | [**List&lt;IssuesEnum&gt;**](#List&lt;IssuesEnum&gt;) | The list of the quality check issues if the quality check failed |  [optional] |
|**warnings** | [**List&lt;WarningsEnum&gt;**](#List&lt;WarningsEnum&gt;) | The list of warnings from the quality check |  [optional] [readonly] |
|**details** | [**QualityDetails**](QualityDetails.md) |  |  |



## Enum: List&lt;IssuesEnum&gt;

| Name | Value |
|---- | -----|
| BRIGHTNESS_HIGH | &quot;BRIGHTNESS_HIGH&quot; |
| BRIGHTNESS_LOW | &quot;BRIGHTNESS_LOW&quot; |
| HOTSPOTS_SCORE_HIGH | &quot;HOTSPOTS_SCORE_HIGH&quot; |
| SHARPNESS_LOW | &quot;SHARPNESS_LOW&quot; |
| DOCUMENT_SMALL | &quot;DOCUMENT_SMALL&quot; |
| DOCUMENT_OUT_OF_IMAGE | &quot;DOCUMENT_OUT_OF_IMAGE&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |



## Enum: List&lt;WarningsEnum&gt;

| Name | Value |
|---- | -----|
| DOCUMENT_CLOSE_TO_IMAGE_BORDER | &quot;DOCUMENT_CLOSE_TO_IMAGE_BORDER&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |




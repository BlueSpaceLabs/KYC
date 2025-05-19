

# DocumentInspectResponse

Results of the inspection of customer's document. Please, read the chapter \"ID Document Authenticity Evaluation\" of the DOT documentation.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**expired** | **Boolean** | True if the document is expired at the time of the customer&#39;s on-boarding. This attribute is available only if the document&#39;s expiry date is available. |  [optional] [readonly] |
|**mrzInspection** | [**MrzInspection**](MrzInspection.md) |  |  [optional] |
|**portraitInspection** | [**PortraitInspection**](PortraitInspection.md) |  |  [optional] |
|**visualZoneInspection** | [**VisualZoneInspection**](VisualZoneInspection.md) |  |  [optional] |
|**pageTampering** | [**Map&lt;String, PageTamperingInspection&gt;**](PageTamperingInspection.md) |  |  [optional] [readonly] |
|**chipInspection** | [**DocumentChipInspection**](DocumentChipInspection.md) |  |  [optional] |




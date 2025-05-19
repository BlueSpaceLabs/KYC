

# PageTamperingInspection

Result of the visual detection indicating possibly fraudulent documents based on the appearance of the image.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**colorProfileChangeDetected** | **Boolean** | True if there is a significant change in color profile of the submitted document against a supported document (e.g. the supplied photo is in greyscale) |  [optional] [readonly] |
|**looksLikeScreenshot** | **Boolean** | True if the submitted document was detected to be photographed from a screen |  [optional] [readonly] |
|**tamperedTexts** | **Boolean** | True if the submitted document shows signs of text manipulation |  [optional] [readonly] |
|**looksLikePrintCopy** | **Boolean** | True if the submitted document shows signs of Print Copy manipulation |  [optional] [readonly] |




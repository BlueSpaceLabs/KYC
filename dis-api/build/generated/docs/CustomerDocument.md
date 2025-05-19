

# CustomerDocument

Details of the customer's document retrieved by OCR from ID document photo. The dates are in format YYYY-MM-DD.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**DocumentType**](DocumentType.md) |  |  [optional] |
|**pageTypes** | **List&lt;String&gt;** | Document&#39;s page types |  [readonly] |
|**dateOfIssue** | [**MultiValueAttribute**](MultiValueAttribute.md) |  |  [optional] |
|**dateOfExpiry** | [**MultiValueAttribute**](MultiValueAttribute.md) |  |  [optional] |
|**documentNumber** | [**MultiValueAttribute**](MultiValueAttribute.md) |  |  [optional] |
|**issuingAuthority** | [**MultiValueAttribute**](MultiValueAttribute.md) |  |  [optional] |
|**additionalTexts** | [**Map&lt;String, MultiValueAttributeWithoutMrz&gt;**](MultiValueAttributeWithoutMrz.md) | The map of additional document texts. The map keys are text field types. |  [optional] [readonly] |
|**mrz** | [**Mrz**](Mrz.md) |  |  [optional] |
|**barcodes** | **Map&lt;String, Map&lt;String, Barcode&gt;&gt;** |  |  [optional] [readonly] |
|**links** | [**CustomerDocumentLinks**](CustomerDocumentLinks.md) |  |  |




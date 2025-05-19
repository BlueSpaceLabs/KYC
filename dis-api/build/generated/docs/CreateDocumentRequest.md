

# CreateDocumentRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**advice** | [**DocumentAdvice**](DocumentAdvice.md) |  |  [optional] |
|**sources** | [**List&lt;SourcesEnum&gt;**](#List&lt;SourcesEnum&gt;) | The document sources. The chosen document sources indicate which part of the document should be processed. For instance, if only MRZ is requested, the document is classified only by MRZ, and only MRZ is recognized and processed. |  [optional] |



## Enum: List&lt;SourcesEnum&gt;

| Name | Value |
|---- | -----|
| VIZ | &quot;VIZ&quot; |
| MRZ | &quot;MRZ&quot; |
| BARCODE | &quot;BARCODE&quot; |
| DOCUMENT_PORTRAIT | &quot;DOCUMENT_PORTRAIT&quot; |
| GLOBAL_OCR | &quot;GLOBAL_OCR&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |




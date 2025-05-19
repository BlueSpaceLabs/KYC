

# CustomerStoreRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**externalId** | **String** | External identifier of the customer (for pairing between Trust Platform and external database), limited to alphanumeric, &#39;.&#39;, &#39;-&#39; and &#39;_&#39; characters and maximum length of 64. If not supplied, the UUID of the customer present in the request URL is used instead. |  [optional] |
|**onboardingStatus** | [**OnboardingStatusEnum**](#OnboardingStatusEnum) | Onboarding status of the customer to be stored in the Trust Platform. Use the FINISHED status only if you have collected all required data of the customer. |  |



## Enum: OnboardingStatusEnum

| Name | Value |
|---- | -----|
| IN_PROGRESS | &quot;IN_PROGRESS&quot; |
| FINISHED | &quot;FINISHED&quot; |
| UNKNOWN_DEFAULT_OPEN_API | &quot;unknown_default_open_api&quot; |




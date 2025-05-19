

# Td2Mrz

Parsed TD2 machine readable zone

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**documentCode** | **String** | Document&#39;s code |  [readonly] |
|**issuingAuthority** | **String** | Document&#39;s issuing authority |  [readonly] |
|**surname** | **String** | Holder&#39;s surname |  [readonly] |
|**givenNames** | **String** | Holder&#39;s given names |  [readonly] |
|**documentNumber** | **String** | Document&#39;s number |  [readonly] |
|**nationality** | **String** | Holder&#39;s nationality |  [readonly] |
|**dateOfBirth** | **String** | Holder&#39;s date of the birth, format: &#x60;YYMMDD&#x60; |  [readonly] |
|**gender** | **String** | Holder&#39;s gender, format: &#x60;M&#x60; for male, &#x60;F&#x60; for female, empty string for undefined gender. |  [readonly] |
|**dateOfExpiry** | **String** | Document&#39;s date of the expiration, format: &#x60;YYMMDD&#x60; |  [readonly] |
|**optionalDataSecondLine** | **String** | Optional data - second line |  [optional] [readonly] |
|**checkDigitsValidity** | [**Td2MrzCheckDigitsValidity**](Td2MrzCheckDigitsValidity.md) |  |  |




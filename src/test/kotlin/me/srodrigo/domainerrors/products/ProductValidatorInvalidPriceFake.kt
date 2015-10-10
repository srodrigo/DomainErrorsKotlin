package me.srodrigo.domainerrors.products

class ProductValidatorInvalidPriceFake(product: Product) : ProductValidator(product) {
	override fun validate(): CreateProductValidationError {
		return CreateProductValidationError(CreateProductValidationError.ErrorType.INVALID_PRICE)
	}
}

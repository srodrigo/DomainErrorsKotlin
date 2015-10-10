package me.srodrigo.domainerrors

import me.srodrigo.domainerrors.CreateProductValidationError
import me.srodrigo.domainerrors.Product
import me.srodrigo.domainerrors.ProductValidator

class ProductValidatorInvalidQuantityFake(product: Product) : ProductValidator(product) {
	override fun validate(): CreateProductValidationError {
		return CreateProductValidationError(CreateProductValidationError.ErrorType.INVALID_QUANTITY)
	}
}

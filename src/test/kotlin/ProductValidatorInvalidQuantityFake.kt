class ProductValidatorInvalidQuantityFake(product: Product) : ProductValidator(product) {
	override fun validate(): CreateProductValidationError {
		return CreateProductValidationError(CreateProductValidationError.ErrorType.INVALID_QUANTITY)
	}
}

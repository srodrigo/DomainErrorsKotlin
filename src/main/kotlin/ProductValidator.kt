open class ProductValidator(val product: Product) {
	open fun validate(): CreateProductValidationError? {
		return null
	}
}

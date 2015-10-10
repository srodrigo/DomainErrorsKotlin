package me.srodrigo.domainerrors.products

open class ProductValidator(val product: Product) {
	open fun validate(): CreateProductValidationError? {
		return null
	}
}

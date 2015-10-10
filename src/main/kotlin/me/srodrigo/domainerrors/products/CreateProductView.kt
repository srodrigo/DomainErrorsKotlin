package me.srodrigo.domainerrors.products

interface CreateProductView {
	fun showCreatedProduct()
	fun showCreatedProductInvalidPriceError()
	fun showCreatedProductInvalidQuantityError()
	fun showNotLoggedError()
}
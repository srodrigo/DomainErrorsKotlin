package me.srodrigo.domainerrors

interface CreateProductView {
	fun showCreatedProduct()
	fun showCreatedProductInvalidPriceError()
	fun showCreatedProductInvalidQuantityError()
	fun showNotLoggedError()
}
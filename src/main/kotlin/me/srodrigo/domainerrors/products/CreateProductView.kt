package me.srodrigo.domainerrors.products

import me.srodrigo.domainerrors.session.SessionView

interface CreateProductView : SessionView {
	fun showCreatedProduct()
	fun showCreatedProductInvalidPriceError()
	fun showCreatedProductInvalidQuantityError()
}

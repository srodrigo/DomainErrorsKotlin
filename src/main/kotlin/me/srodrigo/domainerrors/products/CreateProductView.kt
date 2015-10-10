package me.srodrigo.domainerrors.products

import me.srodrigo.domainerrors.GenericView
import me.srodrigo.domainerrors.session.SessionView

interface CreateProductView : GenericView, SessionView {
	fun showCreatedProduct()
	fun showCreatedProductInvalidPriceError()
	fun showCreatedProductInvalidQuantityError()
}

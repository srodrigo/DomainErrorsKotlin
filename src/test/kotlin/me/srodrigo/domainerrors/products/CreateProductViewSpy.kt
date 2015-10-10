package me.srodrigo.domainerrors.products

class CreateProductViewSpy : CreateProductView {

	var showCreatedProductCalls = 0
		private set

	var showCreatedProductInvalidPriceErrorCalls = 0
		private set

	var showCreatedProductInvalidQuantityErrorCalls = 0
		private set

	var showNotLoggedErrorCalls = 0
		private set

	override fun showCreatedProduct() {
		showCreatedProductCalls++
	}

	override fun showCreatedProductInvalidPriceError() {
		showCreatedProductInvalidPriceErrorCalls++
	}

	override fun showCreatedProductInvalidQuantityError() {
		showCreatedProductInvalidQuantityErrorCalls++;
	}

	override fun showNotLoggedError() {
		showNotLoggedErrorCalls++
	}

}

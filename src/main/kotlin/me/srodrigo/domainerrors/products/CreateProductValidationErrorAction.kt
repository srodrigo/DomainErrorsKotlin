package me.srodrigo.domainerrors.products

import me.srodrigo.domainerrors.InteractorErrorAction

class CreateProductValidationErrorAction(private val view: CreateProductView)
		: InteractorErrorAction<CreateProductValidationError> {

	override fun onError(error: CreateProductValidationError) {
		when (error.errorType) {
			CreateProductValidationError.ErrorType.INVALID_QUANTITY -> view.showCreatedProductInvalidQuantityError()
			CreateProductValidationError.ErrorType.INVALID_PRICE -> view.showCreatedProductInvalidPriceError()
		}
	}
}

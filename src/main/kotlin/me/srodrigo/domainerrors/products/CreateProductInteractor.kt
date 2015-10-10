package me.srodrigo.domainerrors.products

import me.srodrigo.domainerrors.Interactor
import me.srodrigo.domainerrors.session.LoginService
import me.srodrigo.domainerrors.session.NotLoggedError

class CreateProductInteractor(private val loginService: LoginService, private val productValidator: ProductValidator)
		: Interactor<CreateProductResponse> {

	override fun call(): CreateProductResponse {
		if (!loginService.isLogged()) {
			return CreateProductResponse(error = NotLoggedError())
		}

		val validationError = productValidator.validate()
		if (validationError != null) {
			return CreateProductResponse(error = validationError)
		}

		return CreateProductResponse(productValidator.product)
	}
}

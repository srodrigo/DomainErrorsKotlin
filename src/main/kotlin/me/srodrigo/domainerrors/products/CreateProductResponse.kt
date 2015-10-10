package me.srodrigo.domainerrors.products

import me.srodrigo.domainerrors.InteractorError
import me.srodrigo.domainerrors.InteractorResponse

class CreateProductResponse(response: Product? = null, error: InteractorError? = null)
		: InteractorResponse<Product>(response, error)

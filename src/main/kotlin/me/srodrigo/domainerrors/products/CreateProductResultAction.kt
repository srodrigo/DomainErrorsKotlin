package me.srodrigo.domainerrors.products

import me.srodrigo.domainerrors.InteractorResult

class CreateProductResultAction(private val view: CreateProductView) : InteractorResult<CreateProductResponse> {
	override fun onResult(result: CreateProductResponse) {
		view.showCreatedProduct()
	}
}

package me.srodrigo.domainerrors.session

import me.srodrigo.domainerrors.InteractorErrorAction
import me.srodrigo.domainerrors.products.CreateProductView

class NotLoggedErrorAction public constructor(var view: CreateProductView) : InteractorErrorAction<NotLoggedError> {
	override fun onError(error: NotLoggedError) {
		view.showNotLoggedError()
	}
}

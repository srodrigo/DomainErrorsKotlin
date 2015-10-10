package me.srodrigo.domainerrors

class GenericErrorAction(val view: GenericView) : InteractorErrorAction<GenericError> {
	override fun onError(error: GenericError) {
		view.showGenericError()
	}
}

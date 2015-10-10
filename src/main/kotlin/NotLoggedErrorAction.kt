class NotLoggedErrorAction(var view: CreateProductView) : InteractorErrorAction<NotLoggedError> {
	override fun onError(error: NotLoggedError) {
		view.showNotLoggedError()
	}
}

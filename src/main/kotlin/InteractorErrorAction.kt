interface InteractorErrorAction<T : InteractorError> {
	fun onError(error: T)
}
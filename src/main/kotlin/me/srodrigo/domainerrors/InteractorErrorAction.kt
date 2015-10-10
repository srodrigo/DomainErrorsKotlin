package me.srodrigo.domainerrors

interface InteractorErrorAction<T : InteractorError> {
	fun onError(error: T)
}
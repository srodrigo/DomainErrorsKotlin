package me.srodrigo.domainerrors

open class InteractorResponse<T>(val response: T?, val error: InteractorError?) {

	fun hasError(): Boolean = error != null
}
package me.srodrigo.domainerrors

interface InteractorResult<T> {
	fun onResult(result: T)
}
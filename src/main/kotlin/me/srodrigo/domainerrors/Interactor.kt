package me.srodrigo.domainerrors

import java.util.concurrent.Callable

interface Interactor<T> : Callable<T> {
	override fun call(): T
}

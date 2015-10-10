package me.srodrigo.domainerrors

import java.util.concurrent.Future

interface InteractorInvoker {
	fun <T : InteractorResponse<out Any>> execute(execution: InteractorExecution<T>): Future<T>?
}

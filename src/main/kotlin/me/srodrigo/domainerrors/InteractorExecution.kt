package me.srodrigo.domainerrors

import java.util.HashMap
import java.util.concurrent.Future

class InteractorExecution<T : InteractorResponse<out Any>>(val interactor: Interactor<T>,
                                                           val interactorResult: InteractorResult<T>) {

	private val errors = HashMap<Class<out InteractorError>, InteractorErrorAction<in InteractorError>> ()

	fun <E : InteractorError>error(javaClass: Class<E>, errorAction: InteractorErrorAction<out InteractorError>): InteractorExecution<T> {
		errors[javaClass] = errorAction as InteractorErrorAction<in InteractorError>
		return this
	}

	fun execute(invoker: InteractorInvoker): Future<T>? = invoker.execute(this)

	fun getAction(javaClass: Class<InteractorError>) = errors[javaClass]!!
}

package me.srodrigo.domainerrors

import java.util.*
import java.util.concurrent.Future

class InteractorExecution<T : InteractorResponse<out Any>>(val interactor: Interactor<T>,
                                                           val interactorResult: InteractorResult<T>) {

	private val genericErrorClass = GenericError::class.java

	private val errors = HashMap<Class<out InteractorError>, InteractorErrorAction<in InteractorError>> ()

	fun <E : InteractorError>error(javaClass: Class<E>, errorAction: InteractorErrorAction<out InteractorError>): InteractorExecution<T> {
		errors[javaClass] = castErrorAction(errorAction)
		return this
	}

	fun genericErrorAction(errorAction: InteractorErrorAction<out InteractorError>): InteractorExecution<T> {
		errors[genericErrorClass] = castErrorAction(errorAction)
		return this
	}

	private fun castErrorAction(errorAction: InteractorErrorAction<out InteractorError>) =
			errorAction as InteractorErrorAction<in InteractorError>

	fun execute(invoker: InteractorInvoker): Future<T>? = invoker.execute(this)

	fun getAction(javaClass: Class<InteractorError>) = errors[javaClass]

	/**
	 * Returns an optional, as it's not mandatory to be subscribed to generic errors from everywhere
	 */
	fun getGenericErrorAction() = errors[genericErrorClass]
}

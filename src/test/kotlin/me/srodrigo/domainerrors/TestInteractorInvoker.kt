package me.srodrigo.domainerrors

import java.util.concurrent.Future

class TestInteractorInvoker : InteractorInvoker {
	override fun <T : InteractorResponse<out Any>> execute(execution: InteractorExecution<T>): Future<T>? {
		try {
			val response = execution.interactor.call()
			if (response.hasError()) {
				onErrorAction(execution, response)
			} else {
				onResultAction(execution, response)
			}
		} catch (e: Exception) {
			doGenericErrorAction(execution, GenericError(e))
		}

		return null
	}

	private fun <T : InteractorResponse<out Any>> onResultAction(execution: InteractorExecution<T>, response: T) {
		execution.interactorResult.onResult(response)
	}

	private fun <T : InteractorResponse<out Any>> onErrorAction(execution: InteractorExecution<T>, response: T) {
		val error: InteractorError = response.error!!
		val errorAction = execution.getAction(error.javaClass)
		errorAction?.onError(error) ?: doGenericErrorAction(execution, GenericError())
	}

	private fun <T : InteractorResponse<out Any>> doGenericErrorAction(execution: InteractorExecution<T>,
	                                                                   genericError: GenericError) {
		execution.getGenericErrorAction()?.onError(genericError)
	}
}

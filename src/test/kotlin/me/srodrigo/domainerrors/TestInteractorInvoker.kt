package me.srodrigo.domainerrors

import me.srodrigo.domainerrors.InteractorError
import me.srodrigo.domainerrors.InteractorExecution
import me.srodrigo.domainerrors.InteractorInvoker
import me.srodrigo.domainerrors.InteractorResponse
import java.util.concurrent.Future

class TestInteractorInvoker : InteractorInvoker {
	override fun <T : InteractorResponse<out Any>> execute(execution: InteractorExecution<T>): Future<T>? {
		val response = execution.interactor.call()
		if (response.hasError()) {
			val error: InteractorError = response.error!!
			val errorAction = execution.getAction(error.javaClass)
			errorAction.onError(error)
		} else {
			execution.interactorResult.onResult(response)
		}

		return null
	}
}

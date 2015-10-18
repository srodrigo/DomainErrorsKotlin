package me.srodrigo.domainerrors.products

import me.srodrigo.domainerrors.*
import me.srodrigo.domainerrors.session.NotLoggedError
import me.srodrigo.domainerrors.session.NotLoggedErrorAction

class CreateProductPresenter(private val view: CreateProductView, private val invoker: InteractorInvoker,
                             private val createProductInteractor: CreateProductInteractor) {

	fun onCreateProduct() {
		InteractorExecution(interactor = createProductInteractor,
				interactorResult = CreateProductResultAction(view))
				.error(CreateProductValidationError::class.java, CreateProductValidationErrorAction(view))
				.error(NotLoggedError::class.java, NotLoggedErrorAction(view))
				.genericErrorAction(GenericErrorAction(view))
				.execute(invoker)
	}
}

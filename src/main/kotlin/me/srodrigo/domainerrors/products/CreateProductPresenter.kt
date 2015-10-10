package me.srodrigo.domainerrors.products

import me.srodrigo.domainerrors.InteractorExecution
import me.srodrigo.domainerrors.InteractorInvoker
import me.srodrigo.domainerrors.InteractorResult
import me.srodrigo.domainerrors.session.NotLoggedError
import me.srodrigo.domainerrors.session.NotLoggedErrorAction

class CreateProductPresenter(private val view: CreateProductView, private val invoker: InteractorInvoker,
                             private val createProductInteractor: CreateProductInteractor) {

	fun onCreateProduct() {
		InteractorExecution(interactor = createProductInteractor,
				interactorResult = object : InteractorResult<CreateProductResponse> {
					override fun onResult(result: CreateProductResponse) {
						view.showCreatedProduct()
					}
				})
				.error(CreateProductValidationError::class.java, CreateProductValidationErrorAction(view))
				.error(NotLoggedError::class.java, NotLoggedErrorAction(view))
				.execute(invoker)
	}
}

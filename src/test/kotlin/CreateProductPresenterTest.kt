import org.junit.Assert
import org.junit.Before
import org.junit.Test
import kotlin.properties.Delegates

class CreateProductPresenterTest {

	private var invoker: InteractorInvoker by Delegates.notNull<InteractorInvoker>()
	private var view: CreateProductViewSpy by Delegates.notNull<CreateProductViewSpy>()

	@Before fun setUp() {
		invoker = TestInteractorInvoker()
		view = CreateProductViewSpy()
	}

	@Test fun whenLoggedIn_andInputIsValid_showCreatedProduct() {
		val loginService = LoginService()
		val productValidator = ProductValidator(Product())
		val presenter = createProductPresenter(loginService, productValidator)
		presenter.onCreateProduct()
		Assert.assertEquals(1, view.showCreatedProductCalls)
	}

	@Test fun whenLoggedIn_andPriceIsInvalid_showValidationError() {
		val loginService = LoginService()
		val productValidator = ProductValidatorInvalidPriceFake(Product())
		val presenter = createProductPresenter(loginService, productValidator)
		presenter.onCreateProduct()
		Assert.assertEquals(1, view.showCreatedProductInvalidPriceErrorCalls)
	}

	@Test fun whenLoggedIn_andQuantityIsInvalid_showValidationError() {
		val loginService = LoginService()
		val productValidator = ProductValidatorInvalidQuantityFake(Product())
		val presenter = createProductPresenter(loginService, productValidator)
		presenter.onCreateProduct()
		Assert.assertEquals(1, view.showCreatedProductInvalidQuantityErrorCalls)
	}

	@Test fun whenNotLoggedIn_showNotLoggedError() {
		val loginService = LoginServiceNotLoggedInFake()
		val productValidator = ProductValidator(Product())
		val presenter = createProductPresenter(loginService, productValidator)
		presenter.onCreateProduct()
		Assert.assertEquals(1, view.showNotLoggedErrorCalls)
	}

	private fun createProductPresenter(loginService: LoginService, productValidator: ProductValidator): CreateProductPresenter {
		val createProductInteractor = CreateProductInteractor(loginService, productValidator)
		val presenter = CreateProductPresenter(view, invoker, createProductInteractor)
		return presenter
	}
}

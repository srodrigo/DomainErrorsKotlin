class CreateProductValidationError(val errorType: CreateProductValidationError.ErrorType) : InteractorError {
	enum class ErrorType {
		INVALID_QUANTITY,
		INVALID_PRICE
	}
}

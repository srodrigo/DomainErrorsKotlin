class LoginServiceNotLoggedInFake : LoginService() {
	override fun isLogged(): Boolean = false
}

package me.srodrigo.domainerrors.session

class LoginServiceNotLoggedInFake : LoginService() {
	override fun isLogged(): Boolean = false
}

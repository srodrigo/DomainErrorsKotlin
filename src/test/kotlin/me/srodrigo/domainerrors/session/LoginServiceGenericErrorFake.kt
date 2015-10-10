package me.srodrigo.domainerrors.session

class LoginServiceGenericErrorFake : LoginService() {
	override fun isLogged(): Boolean = throw RuntimeException();
}

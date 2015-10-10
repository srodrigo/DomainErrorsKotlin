package me.srodrigo.domainerrors

import me.srodrigo.domainerrors.LoginService

class LoginServiceNotLoggedInFake : LoginService() {
	override fun isLogged(): Boolean = false
}

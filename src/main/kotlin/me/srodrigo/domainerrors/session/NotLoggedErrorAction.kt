package me.srodrigo.domainerrors.session

import me.srodrigo.domainerrors.InteractorErrorAction

class NotLoggedErrorAction public constructor(var view: SessionView) : InteractorErrorAction<NotLoggedError> {
	override fun onError(error: NotLoggedError) {
		view.showNotLoggedError()
	}
}

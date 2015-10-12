package me.srodrigo.domainerrors

class GenericError(val cause: Exception? = null) : InteractorError

package lotto.domain

sealed interface Input {
    data class Success(val data: String) : Input
    data class WrongInput(val errorMessage: String) : Input
}

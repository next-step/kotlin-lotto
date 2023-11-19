package lotto.domain

sealed interface Input {
    data class Success(val data: String) : Input
    data class Failure(val errorMessage: String) : Input
}

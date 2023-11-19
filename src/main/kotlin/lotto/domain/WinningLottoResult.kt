package lotto.domain

sealed class WinningLottoResult {
    data class Success(val data: WinningLotto) : WinningLottoResult()
    data class Failure(val errorMessage: String) : WinningLottoResult()
}

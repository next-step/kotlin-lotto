package lotto.domain

sealed class LottoResult {
    data class Success(val data: Lotto) : LottoResult()
    data class Failure(val errorMessage: String) : LottoResult()
}

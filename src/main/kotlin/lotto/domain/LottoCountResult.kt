package lotto.domain

sealed class LottoCountResult {
    data class Success(val data: LottoCount) : LottoCountResult()
    data class Failure(val errorMessage: String) : LottoCountResult()
}

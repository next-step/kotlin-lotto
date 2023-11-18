package lotto.domain.number

sealed class LottoNumberResult {
    data class Success(val data: LottoNumber) : LottoNumberResult()
    data class Failure(val errorMessage: String) : LottoNumberResult()
}

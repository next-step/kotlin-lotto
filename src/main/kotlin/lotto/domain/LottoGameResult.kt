package lotto.domain

val <T> T.exhaustive: T
    get() = this

sealed class LottoGameResult {
    data class Success(val prizeNumber: String, val bonusNumber: LottoNumber) : LottoGameResult()
    object InvalidBonusNumber : LottoGameResult()
    object InvalidPrizeLotto : LottoGameResult()
    object IsContainBonusNumber : LottoGameResult()
}

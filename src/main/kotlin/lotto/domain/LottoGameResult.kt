package lotto.domain

sealed class LottoGameResult {
    data class Success(
        val prizeNumber: String,
        val bonusNumber: LottoNumber,
        val lottoPrizeStatics: LottoPrizeStatics
    ) : LottoGameResult()

    object InvalidBonusNumber : LottoGameResult()
    object InvalidPrizeLotto : LottoGameResult()
    object IsContainBonusNumber : LottoGameResult()
}

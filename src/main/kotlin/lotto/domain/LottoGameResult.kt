package lotto.domain

sealed class LottoGameResult {
    data class Success(
        val lottoList: List<Lotto>,
        val prizeStatics: LottoPrizeStatics
    ) : LottoGameResult()

    object InvalidBonusNumber : LottoGameResult()
    object InvalidPrizeLotto : LottoGameResult()
    object IsContainBonusNumber : LottoGameResult()
}

package lotto.domain

sealed class LottoGameResult {
    data class Success(
        val winningLotto: WinningLotto,
        val prizeStatics: LottoPrizeStatics
    ) : LottoGameResult()

    object InvalidBonusNumber : LottoGameResult()
    object InvalidPrizeLotto : LottoGameResult()
    object IsContainBonusNumber : LottoGameResult()
}

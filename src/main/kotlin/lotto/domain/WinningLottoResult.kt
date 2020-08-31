package lotto.domain

sealed class WinningLottoResult {
    data class Success(
        val prizeLotto: Lotto,
        val bonusNumber: LottoNumber
    ) : WinningLottoResult()

    object InvalidBonusNumber : WinningLottoResult()
    object InvalidPrizeLotto : WinningLottoResult()
    object IsContainBonusNumber : WinningLottoResult()
}

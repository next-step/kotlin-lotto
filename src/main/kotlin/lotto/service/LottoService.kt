package lotto.service

import Lottos
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoPrice
import lotto.domain.LottoPurchaseManager
import lotto.domain.WinningLotto
import lotto.domain.WinningResult

class LottoService(private val purchaseManager: LottoPurchaseManager) {
    fun purchase(
        price: LottoPrice,
        manualLottos: List<Lotto> = emptyList(),
    ): Lottos {
        return purchaseManager.purchase(price, manualLottos)
    }

    fun checkWinning(
        lottos: Lottos,
        winningNumbers: Lotto,
        bonusNumber: LottoNumber,
    ): WinningResult {
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        return winningLotto.checkWinning(lottos)
    }
}

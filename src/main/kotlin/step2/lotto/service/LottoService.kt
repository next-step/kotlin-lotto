package step2.lotto.service

import step2.lotto.domain.PurchaseItem
import step2.lotto.domain.PlayResults
import step2.lotto.domain.WinningNumber

class LottoService {
    fun play(purchaseItem: PurchaseItem, winningNumber: WinningNumber): PlayResults =
        purchaseItem.lottos.match(winningNumber)
}

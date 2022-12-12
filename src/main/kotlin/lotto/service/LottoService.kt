package lotto.service

import lotto.domain.PlayResults
import lotto.domain.PurchaseItem
import lotto.domain.WinningNumber

class LottoService {
    fun play(purchaseItem: PurchaseItem, winningNumber: WinningNumber): PlayResults =
        purchaseItem.lottos.match(winningNumber)
}

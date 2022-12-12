package lotto.service

import lotto.domain.PlayResults
import lotto.domain.PurchaseItem
import lotto.domain.WinningNumber

class LottoService {
    fun play(purchaseItem: PurchaseItem, winningNumber: WinningNumber): PlayResults {
        val matchResults = purchaseItem.lottos.match(winningNumber)
        return PlayResults.of(matchResults, purchaseItem.buyAmount)
    }
}

package lotto.service.issue

import lotto.domain.Lotto
import lotto.domain.LottoFactory

object LottoIssueService {
    fun issue(purchaseAmount: Long): List<Lotto> {
        val purchaseCount = (purchaseAmount / Lotto.PRICE).toInt()

        return LottoFactory.createLottos(purchaseCount)
    }
}

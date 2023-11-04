package lotto.service

import lotto.domain.Lotto

object LottoIssueService {
    fun issue(purchaseAmount: Int): List<Lotto> {
        val purchaseCount = purchaseAmount / Lotto.PRICE

        return List(purchaseCount) { Lotto() }
    }
}

package lotto.service

import lotto.domain.Lotto

object LottoIssueService {
    fun issue(purchaseAmount: Long): List<Lotto> {
        val purchaseCount = (purchaseAmount / Lotto.PRICE).toInt()

        return List(purchaseCount) { Lotto() }
    }
}

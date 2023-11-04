package lotto.service

import lotto.domain.Lotto

object LottoIssueService {
    fun issue(purchasePrice: Int): List<Lotto> {
        val purchaseAmount = purchasePrice / Lotto.PRICE

        return List(purchaseAmount) { Lotto() }
    }
}

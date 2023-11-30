package lotto.view.order

import lotto.model.LottoGame

interface LottoOrderStrategy {
    fun issue(count: Int): List<LottoGame>
}

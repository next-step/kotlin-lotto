package lotto.view

import lotto.domain.LottoPaper

object LottoPaperView {
    fun print(lottoPaper: LottoPaper) {
        lottoPaper.lottos.forEach(LottoView::print)
    }
}

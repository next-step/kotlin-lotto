package lotto.view

import lotto.domain.LottoPaper

object LottoPaperView {
    fun print(lottoPaper: LottoPaper) {
        lottoPaper.lottos.forEach(LottoView::print)
    }

    fun print(lottoPaper1: LottoPaper, lottoPaper2: LottoPaper) {
        lottoPaper1.lottos.forEach(LottoView::print)
        lottoPaper2.lottos.forEach(LottoView::print)
    }
}

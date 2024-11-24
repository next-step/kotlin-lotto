package lotto.domain

import lotto.view.LottoView

class Lottos(val lottos: List<Lotto>) {
    fun drawLottos() {
        lottos.forEach(LottoView::drawLotto)
    }
}

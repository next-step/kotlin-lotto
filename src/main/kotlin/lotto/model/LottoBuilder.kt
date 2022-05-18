package lotto.model

import lotto.model.data.Lotto
import lotto.model.data.Lottos

interface LottoBuilder {
    fun createLotto(): Lotto
    fun createLottos(countOfLotto: Int) =
        Lottos(
            List(countOfLotto) { this.createLotto() }
        )
}

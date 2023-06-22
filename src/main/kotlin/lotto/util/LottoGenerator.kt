package lotto.util

import lotto.domain.Lotto
import lotto.domain.Lottos

interface LottoGenerator {

    fun getLottos(count: Int): Lottos {
        val lottoList = List(count) {
            getLotto()
        }
        return Lottos(lottoList)
    }

    fun getLotto(): Lotto
}

package lotto.domain

import lotto.domain.strategy.DrawStrategy
import lotto.domain.strategyImpl.AutoStrategy

class LottoGenerator(private val drawStrategy: DrawStrategy = AutoStrategy()) {

    fun getLotto(lottoTryCount: Int): List<Lotto> = List(lottoTryCount) { drawStrategy.draw() }

}

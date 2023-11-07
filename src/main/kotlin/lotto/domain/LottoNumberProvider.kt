package lotto.domain

import lotto.domain.strategy.DrawStrategy
import lotto.domain.strategyImpl.AutoStrategy

class LottoNumberProvider(private val drawStrategy: DrawStrategy = AutoStrategy()) {

    private var lottoList: MutableList<Lotto> = mutableListOf()

    fun getLotto(lottoTryCount: Int): List<Lotto> {
        repeat(lottoTryCount) {
            val lotto = drawStrategy.draw()
            lottoList.add(lotto)
        }

        return lottoList
    }
}

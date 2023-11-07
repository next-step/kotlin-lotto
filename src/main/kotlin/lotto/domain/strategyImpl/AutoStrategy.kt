package lotto.domain.strategyImpl

import lotto.domain.Lotto
import lotto.domain.strategy.DrawStrategy

class AutoStrategy : DrawStrategy {

    override fun draw(): Lotto {
        val lottoNumbers = (1..45).toList().shuffled()
        return Lotto(lottoNumbers.subList(0, 6).sorted())
    }
}

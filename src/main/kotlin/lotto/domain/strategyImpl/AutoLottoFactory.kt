package lotto.domain.strategyImpl

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.strategy.DrawStrategy

class AutoLottoFactory : DrawStrategy {

    override fun draw(): Lotto {
        val lotto = LottoNumber.getLottoNumbers()
        return Lotto(lotto)
    }
}

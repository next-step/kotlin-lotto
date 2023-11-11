package lotto.domain.strategyImpl

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.strategy.DrawStrategy

class AutoLottoFactory : DrawStrategy {

    override fun draw(): Lotto {
        val lottoNumbers = LottoNumber.lottoNumberRange.toList().shuffled()


        val sortedLotto = lottoNumbers.take(Lotto.LOTTO_NUMBER_COUNT).sorted()
        sortedLotto.map { LottoNumber(it) }

        return Lotto(sortedLotto)
    }
}

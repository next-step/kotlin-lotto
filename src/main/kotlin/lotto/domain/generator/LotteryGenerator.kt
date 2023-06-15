package lotto.domain.generator

import lotto.domain.Lottery
import lotto.domain.LotteryAdaptor
import lotto.domain.LottoNumber

object LotteryGenerator {

    private val lottoNumbers: List<LottoNumber> = LottoNumber.LOTTO_NUMBER_RANGE
        .map(::LottoNumber)

    fun draw(): Lottery = lottoNumbers.shuffled()
        .take(n = LotteryAdaptor.ALLOW_LOTTO_NUMBER_COUNT)
        .toSet()
        .run(::Lottery)
}

package lotto.domain.strategy

import lotto.domain.Lottery
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers

object LottoAutoGenerator : LottoGenerator {

    override fun generate(): Lottery {
        return ALL_LOTTO_NUMBERS.shuffled()
            .subList(0, LottoNumbers.LOTTO_NUMBER_COUNTS)
            .sortedBy { it.value }
            .let { Lottery.of(LottoNumbers.of(it)) }
    }

    private val ALL_LOTTO_NUMBERS: List<LottoNumber> =
        (LottoNumber.MIN_VALUE..LottoNumber.MAX_VALUE).map { LottoNumber.of(it) }
}

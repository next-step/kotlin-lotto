package lotto.domain.strategy

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers

object DefaultLottoNumberAutoGenerator : LottoNumberAutoGenerator {

    override fun generate(): LottoNumbers {
        return ALL_LOTTO_NUMBERS.shuffled()
            .subList(0, LottoNumbers.LOTTO_NUMBER_COUNTS)
            .sortedBy { it.value }
            .run { LottoNumbers.of(this) }
    }

    private val ALL_LOTTO_NUMBERS: List<LottoNumber> =
        (LottoNumber.MIN_VALUE..LottoNumber.MAX_VALUE).map { LottoNumber.of(it) }
}

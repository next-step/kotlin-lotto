package stringaddcalculator.lotto

import stringaddcalculator.lotto.LottoNumber.Companion.LOTTO_NUMBER_RANGE

interface LottoGenerator {
    fun generate(): Lotto
}

object RandomLottoGenerator : LottoGenerator {
    override fun generate(): Lotto {
        val lottoNumbers = LOTTO_NUMBER_RANGE
            .shuffled()
            .take(Lotto.SIZE_OF_LOTTO_NUMBERS)
            .map { LottoNumber(it) }
        return Lotto(lottoNumbers)
    }
}

class FixedLottoGenerator(
    private val fixedNumbers: Collection<Int>
) : LottoGenerator {
    override fun generate(): Lotto {
        val lottoNumbers = fixedNumbers.map { LottoNumber(it) }
        return Lotto(lottoNumbers)
    }
}

package lotto.domain.interfaces

import lotto.domain.LottoNumber
import lotto.domain.interfaces.LottoNumbers.Companion.MAX_LOTTO_INDEX
import lotto.domain.interfaces.LottoNumbers.Companion.MIN_LOTTO_INDEX

class LottoNumberGenerator : LottoNumbers {
    private val randomNumbers
        get() = LottoNumber
            .LOTTO_NUMBER_RANGE
            .toMutableList()
            .shuffled()
            .subList(MIN_LOTTO_INDEX, MAX_LOTTO_INDEX)
            .sorted()

    override fun createNumbers(): Set<LottoNumber> {
        return randomNumbers.map { number -> LottoNumber.of(number) }.toSet()
    }

    override fun convertLottoNumbers(inputs: List<Int>): Set<LottoNumber> {
        return inputs.toSortedSet().map { input -> LottoNumber.of(input) }.toSet()
    }
}

package lotto

import lotto.model.LottoNumber

object Fixtures {
    fun createSixLottoNumber(numbers: List<Int>): List<LottoNumber> {
        return numbers.map { LottoNumber.from(it) }
            .toList()
    }
}

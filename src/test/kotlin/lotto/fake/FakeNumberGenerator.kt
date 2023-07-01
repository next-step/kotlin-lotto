package lotto.fake

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.NumberGenerator

class FakeNumberGenerator(
    private val numbers: List<Int>
) : NumberGenerator {
    override fun generate(): LottoNumbers {
        return LottoNumbers(numbers.map { LottoNumber(it) })
    }
}

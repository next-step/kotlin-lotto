package lotto.domain

object LottoNumberGenerator {

    fun createFrom(): LottoNumber {
        val numbers = LottoNumber.RANGE
            .shuffled()
            .take(LottoNumber.COUNT)
            .sorted()
        return LottoNumber(numbers)
    }
}

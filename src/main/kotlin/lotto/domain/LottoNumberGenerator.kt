package lotto.domain

object LottoNumberGenerator {
    fun generateAutoLottoNumbers(): LottoNumbers {
        val randomNumbers = generatorRandomNumber()
        return LottoNumbers(randomNumbers.map { LottoNumber.of(it) }.toSet())
    }

    fun generatorRandomNumber(): List<Int> {
        return (LottoNumber.LOTTO_NUMBER_MIN_VALUE..LottoNumber.LOTTO_NUMBER_MAX_VALUE)
            .shuffled().take(LottoNumbers.LOTTO_NUMBER_COUNT).sorted()
    }
}

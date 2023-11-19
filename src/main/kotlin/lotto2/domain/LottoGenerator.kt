package lotto2.domain

object LottoGenerator : LottoFactory {
    override fun generate(): LottoNumbers {
        val randomNumbers = LottoNumbers.FULL_NUMBER_RANGE
            .shuffled()
            .take(LottoNumbers.MAIN_LOTTO_NUMBERS_COUNT)
            .sorted()

        return LottoNumbers(randomNumbers)
    }
}

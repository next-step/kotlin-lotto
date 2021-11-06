package lotto.domain

class LottoNumberGenerator : NumberGenerator {

    override fun generateLottoNumber(): List<LottoNumber> {
        val numbers = LottoNumber.LOTTO_NUMBERS
        val shuffledNumbers = numbers.shuffled()
        return shuffledNumbers.subList(LOTTO_NUMBER_START_INDEX, LOTTO_NUMBER_END_INDEX)
    }

    companion object {
        const val LOTTO_NUMBER_START_INDEX = 0
        const val LOTTO_NUMBER_END_INDEX = 6
    }
}

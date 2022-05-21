package lotto

object LottoCreator {
    private val LOTTO_NUMBERS = (1..45)

    private const val FIRST_LOTTERY_NUMBER_INDEX = 0
    private const val LAST_LOTTERY_NUMBER_INDEX = 6

    fun autoCreate(): LottoTicket {
        val lottoNumbers = LOTTO_NUMBERS.shuffled()
            .subList(FIRST_LOTTERY_NUMBER_INDEX, LAST_LOTTERY_NUMBER_INDEX)
            .sorted()

        return LottoTicket(lottoNumbers)
    }
}

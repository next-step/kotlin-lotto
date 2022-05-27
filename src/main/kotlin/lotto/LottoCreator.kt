package lotto

object LottoCreator {
    private const val PICK_LOTTO_NUMBER_SIZE = 6

    fun autoCreate(): LottoTicket {

        val lottoNumbers = LottoPolicy.LOTTO_NUMBER_RANGE
            .shuffled()
            .take(PICK_LOTTO_NUMBER_SIZE)
            .sorted()

        return LottoTicket(lottoNumbers)
    }
}

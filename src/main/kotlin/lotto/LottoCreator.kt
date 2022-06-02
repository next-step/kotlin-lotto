package lotto

object LottoCreator {
    private const val PICK_LOTTO_NUMBER_SIZE = 6

    fun autoCreate(count: Int): List<LottoTicket> {
        return List(count) { autoCreate() }
    }

    private fun autoCreate(): LottoTicket {
        val lottoNumbers = LottoNumber.LOTTO_NUMBER_RANGE
            .shuffled()
            .take(PICK_LOTTO_NUMBER_SIZE)
            .map(::LottoNumber)
        return LottoTicket.of(lottoNumbers)
    }

    fun manualCreate(numbers: Collection<LottoNumber>): LottoTicket {
        return LottoTicket.of(numbers)
    }
}

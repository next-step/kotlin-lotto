package lotto

object LottoFactory {
    private val numbers: List<Int> = List(45) { it + 1 }

    fun auto(count: Int): LottoTickets {
        val lottoTickets = List(count) {
            autoTicket()
        }
        return LottoTickets(lottoTickets)
    }

    private fun autoTicket(): LottoTicket {
        val shuffledNumbers = this.numbers.shuffled()
        val lottoNumbers: Set<LottoNumber> = List(LottoTicket.LOTTO_NUMBERS_SIZE) { LottoNumber.of(shuffledNumbers[it]) }.toSet()
        return LottoTicket(lottoNumbers)
    }
}

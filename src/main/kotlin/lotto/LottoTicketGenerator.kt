package lotto

class LottoTicketGenerator : RandomLottoTicketGenerator {

    private val lottoNumbers = createAllLottoNumbers()

    private fun createAllLottoNumbers(): List<LottoNumber> {
        return (LottoNumber.MIN_LOTTO_NUMBER..LottoNumber.MAX_LOTTO_NUMBER)
            .map { LottoNumber(it) }
    }

    override fun createRandomTicket(): LottoTicket {
        return lottoNumbers.shuffled()
            .subList(0, LottoTicket.LOTTO_NUMBER_COUNT)
            .let { LottoTicket(it) }
    }
}

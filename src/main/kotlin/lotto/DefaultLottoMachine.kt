package lotto

object DefaultLottoMachine : LottoMachine {

    override fun generate(): LottoTicket {
        return LottoTicket(lottoNumbers())
    }

    private fun lottoNumbers(): List<LottoNumber> {
        val lottoRange = 1..45
        return lottoRange.shuffled()
            .subList(0, 6)
            .map(::LottoNumber)
    }
}

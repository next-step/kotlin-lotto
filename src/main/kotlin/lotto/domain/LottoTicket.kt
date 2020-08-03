package lotto.domain

class LottoTicket(private val totalNumber: Int) {
    private val lottoLines = createLottoTicket(totalNumber)

    private fun createLottoTicket(totalNumber: Int): List<LottoSingleLine> {
        val list = mutableListOf<LottoSingleLine>()
        for (count in 1..totalNumber) {
            list.add(LottoSingleLine())
        }
        return list
    }
}

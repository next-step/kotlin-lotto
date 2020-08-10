package lotto.domain

class LottoWinningNumber(numbers: List<Int>) {

    val luckyLottoTicket: LottoTicket

    init {
        if (numbers.size != LottoTicket.LOTTO_NUMBER_COUNT_PER_TICKET) {
            throw IllegalArgumentException("로또 번호는 6자리여야합니다.")
        }
        if (numbers.size != numbers.distinct().size) {
            throw IllegalArgumentException("로또 번호는 중복불가능합니다")
        }
        luckyLottoTicket = LottoTicket(numbers.map { LottoNumber(it) })
        //bonusBallNumber = LottoNumber(bonusBall)
    }

    fun getLottoResultsOf(lottoTickets: List<LottoTicket>): List<Rank> {
        return lottoTickets.map { it.getMatchValueCount(luckyLottoTicket) }

//    fun getLottoResult(lottoTickets: List<LottoTicket>): List<Rank> {
//        var matchCount: Int = 0
//        var isBonusBall: Boolean = false
//        var ranks: List<Rank> = mutableListOf()
//        lottoTickets.forEach {
//            matchCount = it.getMatchValueCount(luckyLottoTicket)
//            isBonusBall = it.isExsitBonusBall(bonusBallNumber)
//            ranks.add(Rank.of(matchCount, isBonusBall))
//        }
//
//        return ranks
//    }

    }
}

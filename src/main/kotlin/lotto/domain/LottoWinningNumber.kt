package lotto.domain

class LottoWinningNumber(numbers: List<Int>, bonusBall: Int) {

    val luckyLottoTicket: LottoTicket
    val bonusBallNumber: LottoNumber

    init {
        if (numbers.size != LottoTicket.LOTTO_NUMBER_COUNT_PER_TICKET) {
            throw IllegalArgumentException("로또 번호는 6자리여야합니다.")
        }
        if (numbers.size != numbers.distinct().size) {
            throw IllegalArgumentException("로또 번호는 중복불가능합니다")
        }
        luckyLottoTicket = LottoTicket(numbers.map { LottoNumber(it) })
        bonusBallNumber = LottoNumber(bonusBall)
    }

    fun getLottoResultsOf(inputUserTicket: LottoTickets): List<Rank> {
        var rankList = mutableListOf<Rank>()

        inputUserTicket.lottoTickets.forEach {
            var matchCount = it.getMatchValueCount(luckyLottoTicket)
            val isBonusBall = it.isExistBonusBall(bonusBallNumber)
            val rank: Rank = Rank.of(matchCount, isBonusBall)
            rankList.add(rank)
        }
        return rankList
    }
}

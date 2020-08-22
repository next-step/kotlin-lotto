package lotto.domain

class LottoWinningNumber(numbers: List<Int>, bonusBall: Int) {

    private val luckyLottoTicket: LottoTicket
    private val bonusBallNumber: LottoNumber

    init {
        if (numbers.size != LottoTicket.LOTTO_NUMBER_COUNT_PER_TICKET) {
            throw IllegalArgumentException(NOT_FULFILL_TICKET_SIZE)
        }
        if (numbers.size != numbers.distinct().size) {
            throw IllegalArgumentException(NOT_ALLOW_DISTINCT_NUM)
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

    companion object {
        const val NOT_FULFILL_TICKET_SIZE = "6개의 번호가 필요합니다."
        const val NOT_ALLOW_DISTINCT_NUM = "로또 번호는 중복될 수 없습니다."
    }
}

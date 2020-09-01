package lotto.domain

class LottoTickets private constructor(val lottoTickets: List<LottoTicket>) {

    companion object {
        fun from(lottoTickets: List<LottoTicket>): LottoTickets {
            return LottoTickets(lottoTickets)
        }

        fun getWinningTicket(inputUserTicket: LottoTickets, luckyLottoTicket: LottoTicket, bonusBallNumber: LottoNumber): List<Rank> {
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
}

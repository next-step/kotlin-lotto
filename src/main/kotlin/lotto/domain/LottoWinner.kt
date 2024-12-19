package lotto.domain

data class LottoWinner(private val winTicket: LottoTicket, private val bonusNumber: LottoNumber) {
    fun getRank(ticket: LottoTicket): Rank {
        val matchCount =
            winTicket.lottoNumbers.filter {
                ticket.lottoNumbers.contains(it)
            }.size

        val matchBonus = ticket.lottoNumbers.contains(bonusNumber)
        return Rank.valueOf(matchCount, matchBonus)
    }
}

package lotto.business

class WinningLottoTicket(private val winningLottoNumbers: LottoTicket, private val bonusNumber: LottoNumber) {

    init {
        require(!winningLottoNumbers.contains(bonusNumber)) {
            "보너스 번호는 당첨 번호와 중복될 수 없습니다."
        }
    }

    fun compilePrizeResults(tickets: List<LottoTicket>): PrizeResults {
        return tickets.map {
            LotteryPrize.getPrize(
                it.matchCount(winningLottoNumbers.lottoNumbers), it.contains(bonusNumber)
            )
        }.groupingBy { it }.eachCount().let { PrizeResults(it) }
    }
}

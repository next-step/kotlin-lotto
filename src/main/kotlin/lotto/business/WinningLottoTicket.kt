package lotto.business

class WinningLottoTicket(lottoNumbers: Set<LottoNumber>) : LottoNumberSet(lottoNumbers) {
    init {
        validateNumbers()
    }

    fun compilePrizeResults(tickets: List<LottoTicket>): PrizeResults {
        return tickets.map { it.matchCount(sortedLottoNumbers) }
            .map { LotteryPrize.getPrize(it) }
            .groupingBy { it }
            .eachCount()
            .let { PrizeResults(it) }
    }

    fun validateBonusNumber(bonusNumber: LottoNumber) {
        require(!lottoNumbers.contains(bonusNumber)) {
            "보너스 번호는 당첨 번호와 중복될 수 없습니다."
        }
    }
}

package lotto.business

class WinningLottoTicket(lottoNumbers: Set<LottoNumber>) : LottoNumberSet(lottoNumbers) {

    fun compilePrizeResults(tickets: List<LottoTicket>, bonusNumber: LottoNumber): PrizeResults {
        return tickets.map { LotteryPrize.getPrize(it.matchCount(sortedLottoNumbers), it.contains(bonusNumber)) }
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

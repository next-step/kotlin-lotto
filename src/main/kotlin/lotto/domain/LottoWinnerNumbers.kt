package lotto.domain

data class LottoWinnerNumbers(val lottoNumbers: LottoNumbers, val bonusNumber: LottoNumber) {
    init {
        require(!lottoNumbers.contains(bonusNumber)) { INVALID_WINNER_NUMBERS_MESSAGE }
    }

    fun resultLottoPayout(purchasedLottoTickets: PurchasedLottoTickets): PurchasedLottoResults {
        val firstRank = mutableListOf<LottoTicket>()
        val secondRank = mutableListOf<LottoTicket>()
        val thirdRank = mutableListOf<LottoTicket>()
        val fourthRank = mutableListOf<LottoTicket>()
        val fifthRank = mutableListOf<LottoTicket>()

        purchasedLottoTickets.purchasedLottoTickets.forEach { lottoTicket ->
            numberMatchApply(
                lottoTicket = lottoTicket,
                firstRank = firstRank,
                secondRank = secondRank,
                thirdRank = thirdRank,
                fourthRank = fourthRank,
                fifthRank = fifthRank,
            )
        }

        return PurchasedLottoResults(
            purchasedCount = purchasedLottoTickets.purchasedCount,
            firstRankCount = firstRank.size,
            secondRankCount = secondRank.size,
            thirdRankCount = thirdRank.size,
            fourthRankCount = fourthRank.size,
            fifthRankCount = fifthRank.size,
        )
    }

    private fun numberMatchApply(
        lottoTicket: LottoTicket,
        firstRank: MutableList<LottoTicket>,
        secondRank: MutableList<LottoTicket>,
        thirdRank: MutableList<LottoTicket>,
        fourthRank: MutableList<LottoTicket>,
        fifthRank: MutableList<LottoTicket>,
    ) {
        val lottoWinnerRank = lottoTicket.checkLottoWinnerRank(lottoWinnerNumbers = this)

        when (lottoWinnerRank) {
            LottoWinnerRank.FIRST -> firstRank.add(lottoTicket)
            LottoWinnerRank.SECOND -> secondRank.add(lottoTicket)
            LottoWinnerRank.THIRD -> thirdRank.add(lottoTicket)
            LottoWinnerRank.FOURTH -> fourthRank.add(lottoTicket)
            LottoWinnerRank.FIFTH -> fifthRank.add(lottoTicket)
            else -> return
        }
    }

    companion object {
        const val INVALID_WINNER_NUMBERS_MESSAGE: String = "당첨 번호와 보너스 번호는 중복될 수 없습니다."
    }
}

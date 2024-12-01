package lotto.domain

data class PurchasedLottoTickets(val purchasedCount: Int, private val generateLottoNumbers: () -> Set<Int>) {
    val purchasedLottoTickets: List<LottoTicket> =
        List(purchasedCount) {
            LottoTicket(generateLottoNumbers = generateLottoNumbers)
        }

    init {
        require(purchasedCount >= PURCHASED_COUNT_MIN_VALUE) { INVALID_PURCHASED_COUNT_MESSAGE }
    }

    fun resultLottoPayout(lottoWinnerNumbers: LottoWinnerNumbers): PurchasedLottoResults {
        val threeNumberMatchs = mutableListOf<LottoTicket>()
        val fourNumberMatchs = mutableListOf<LottoTicket>()
        val fiveNumberMatchs = mutableListOf<LottoTicket>()
        val sixNumberMatchs = mutableListOf<LottoTicket>()

        purchasedLottoTickets.forEach { lottoTicket ->
            numberMatchApply(
                lottoTicket = lottoTicket,
                lottoWinnerNumbers = lottoWinnerNumbers,
                threeNumberMatchs = threeNumberMatchs,
                fourNumberMatchs = fourNumberMatchs,
                fiveNumberMatchs = fiveNumberMatchs,
                sixNumberMatchs = sixNumberMatchs,
            )
        }

        return PurchasedLottoResults(
            purchasedCount = purchasedCount,
            threeNumberMatchCount = threeNumberMatchs.size,
            fourNumberMatchCount = fourNumberMatchs.size,
            fiveNumberMatchCount = fiveNumberMatchs.size,
            sixNumberMatchCount = sixNumberMatchs.size,
        )
    }

    private fun numberMatchApply(
        lottoTicket: LottoTicket,
        lottoWinnerNumbers: LottoWinnerNumbers,
        threeNumberMatchs: MutableList<LottoTicket>,
        fourNumberMatchs: MutableList<LottoTicket>,
        fiveNumberMatchs: MutableList<LottoTicket>,
        sixNumberMatchs: MutableList<LottoTicket>,
    ) {
        val lottoNumberMatchPayout = lottoTicket.checkLottoWinnerNumbersMatchPayout(lottoWinnerNumbers)

        when (lottoNumberMatchPayout) {
            LottoNumberMatchPayout.THREE_NUMBER_MATCH -> threeNumberMatchs.add(lottoTicket)
            LottoNumberMatchPayout.FOUR_NUMBER_MATCH -> fourNumberMatchs.add(lottoTicket)
            LottoNumberMatchPayout.FIVE_NUMBER_MATCH -> fiveNumberMatchs.add(lottoTicket)
            LottoNumberMatchPayout.SIX_NUMBER_MATCH -> sixNumberMatchs.add(lottoTicket)
            else -> return
        }
    }

    companion object {
        const val PURCHASED_COUNT_MIN_VALUE: Int = 1
        const val INVALID_PURCHASED_COUNT_MESSAGE: String = "최소한 로또 1장 이상 구입해야 합니다"
    }
}

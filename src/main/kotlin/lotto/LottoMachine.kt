package lotto

class LottoMachine(private val lottoPay: Int, private val lottoPrizeInfo: LottoPrizeInfo) {

    companion object {
        private const val startNumber: Int = 1
        private const val endNumber: Int = 45
        private const val maxCount: Int = 6
    }

    fun issue(amount: Int): List<LottoData> {
        return if (lottoPay > amount) emptyList() else makeLottoList(amount)
    }

    fun getWinnerLottoData(winnerNumberData: WinnerNumberData, lottoDataList: List<LottoData>, amount: Int): WinnerLottoData {
        return WinnerLottoData(LottoWin(winnerNumberData).getWinners(lottoDataList), lottoPrizeInfo, amount)
    }

    private fun makeLottoList(amount: Int): List<LottoData> {
        return (1..(amount / lottoPay)).map { Lotto(startNumber, endNumber, maxCount).issue() }
    }
}

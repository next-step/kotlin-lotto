package lotto

class LottoMachine(private val lottoPay: Int, val lottoPrizeInfo: LottoPrizeInfo) {

    private val startNumber: Int = 1
    private val endNumber: Int = 45
    private val maxCount: Int = 6
    private var paymentAmount: Int = 0

    fun issue(amount: Int): List<LottoData> {
        paymentAmount = amount
        return if (lottoPay > amount) emptyList() else makeLottoList(amount)
    }

    fun getWinnerLottoData(winnerNumbers: List<Int>, lottoDataList: List<LottoData>): WinnerLottoData {
        return WinnerLottoData(LottoWin(winnerNumbers).getWinners(lottoDataList), lottoPrizeInfo, paymentAmount)
    }

    private fun makeLottoList(amount: Int): List<LottoData> {
        return (1..(amount / lottoPay)).map { Lotto(startNumber, endNumber, maxCount).issue() }
    }
}

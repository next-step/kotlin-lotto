package lotto

class LottoWin(private val winnerNumberData: WinnerNumberData) {

    fun getWinners(lottoDataList: List<LottoData>): List<LottoData> {
        return lottoDataList.filter { it.match(winnerNumberData.winnerNumbers, winnerNumberData.bonusNumber) }
    }
}

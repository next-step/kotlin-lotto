package lotto

class LottoWin(private val winNumbers: List<Int>) {

    fun getWinners(lottoDataList: List<LottoData>): List<LottoData> {
        return lottoDataList.filter { it.match(winNumbers) }
    }
}

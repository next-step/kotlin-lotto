package lotto.domain

import lotto.data.Lotto
import lotto.data.LottoNumber
import lotto.data.LottoRanking

class LottoGame {

    private val winningStatusMap = mutableMapOf<LottoRanking, Int>()

    fun buyLotto(cash: Int): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()
        val times = cash / GAME_COST

        repeat(times) {
            val randomLottoNumbers = LottoNumber.createRandomLotto()
            val lotto = LottoMachine.createSelectLotto(randomLottoNumbers)
            lottoList.add(lotto)
        }

        return lottoList
    }

    fun getWinningStats(winningNumberList: List<Int>, purchaseLottoList: List<Lotto>): Map<LottoRanking, Int> {

        val winningLotto = LottoMachine.createSelectLotto(LottoNumber.createLottoNumbers(winningNumberList))

        purchaseLottoList.forEach {
            val lottoRanking = LottoMachine.checkLotto(winningLotto, it)
            winningStatusMap[lottoRanking] = winningStatusMap.getOrDefault(lottoRanking, 0) + 1
        }
        return winningStatusMap
    }

    companion object {
        private const val GAME_COST = 1000
    }
}

package lotto

import lotto.LottoNumber.MAX_NUMBER
import lotto.LottoNumber.MIN_NUMBER

class LottoGame {
    private val winningStatusMap = mutableMapOf<LottoRanking, Int>()

    fun buyLotto(cash: Int): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()
        val times = cash / GAME_COST

        repeat(times) {
            lottoList.add(Lotto(createRandomNumber()))
        }

        return lottoList
    }

    private fun createRandomNumber(): List<Int> {
        return (MIN_NUMBER..MAX_NUMBER).shuffled()
            .subList(SUB_LIST_START_POSITION, SUB_LIST_START_POSITION + SUB_LIST_LENGTH).sorted()
    }

    fun getWinningStats(winningNumberList: List<Int>, purchaseLottoList: List<Lotto>): Map<LottoRanking, Int> {
        val winningLotto = Lotto(winningNumberList)
        purchaseLottoList.forEach {
            val lottoRanking = LottoMachine.checkLotto(winningLotto, it)
            winningStatusMap[lottoRanking] = winningStatusMap.getOrDefault(lottoRanking, 0) + 1
        }
        return winningStatusMap
    }

    companion object {
        private const val SUB_LIST_START_POSITION = 0
        private const val SUB_LIST_LENGTH = 6
        private const val GAME_COST = 1000
    }
}

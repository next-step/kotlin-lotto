package lotto.service

import lotto.data.Lotto
import lotto.data.LottoNumber
import lotto.data.LottoRanking
import lotto.domain.LottoMachine
import lotto.domain.RandomLogicInterface
import lotto.domain.WinningDomain

class LottoGame(private val randomLogic: RandomLogicInterface) {

    fun buyLotto(cash: Int): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()
        val times = cash / GAME_COST

        repeat(times) {
            val randomLottoNumbers = LottoNumber.createRandomLotto(randomLogic)
            val lotto = LottoMachine.createSelectLotto(randomLottoNumbers)
            lottoList.add(lotto)
        }

        return lottoList
    }

    fun getWinningStats(winningNumberList: List<Int>, purchaseLottoList: List<Lotto>): Map<LottoRanking, Int> {
        return WinningDomain.checkWinningResult(winningNumberList, purchaseLottoList)
    }

    companion object {
        private const val GAME_COST = 1000
    }
}

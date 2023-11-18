package lotto.service

import lotto.data.Lotto
import lotto.data.LottoNumber
import lotto.data.LottoRanking
import lotto.data.WinningLotto
import lotto.domain.LottoMachine
import lotto.domain.RandomLogicInterface
import lotto.domain.WinningDomain

class LottoGame(private val randomLogic: RandomLogicInterface) {

    fun buyLotto(cash: Int): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()
        val times = cash / GAME_COST

        repeat(times) {
            val lottoNumberCombination = LottoNumber.createRandomLottoNumber(randomLogic)
            lottoList.add(LottoMachine.createSelectLotto(lottoNumberCombination))
        }

        return lottoList
    }

    fun getWinningStats(winningLotto: WinningLotto, purchaseLottoList: List<Lotto>): Map<LottoRanking, Int> {

        return WinningDomain.checkWinningResult(winningLotto, purchaseLottoList)
    }

    companion object {
        private const val GAME_COST = 1000
    }
}
package lotto.service

import lotto.data.Lotto
import lotto.data.LottoNumber
import lotto.data.LottoRanking
import lotto.data.WinningLotto
import lotto.domain.LottoCalculator
import lotto.domain.LottoMachine
import lotto.domain.RandomLogicInterface
import lotto.domain.WinningDomain
import java.util.EnumMap

class LottoGame(private val randomLogic: RandomLogicInterface, private val gameCost: Int = DEFAULT_COST) {

    fun buyLotto(cash: Int): List<Lotto> {
        val times = LottoCalculator.getTimes(cash, gameCost)

        return createLotto(times)
    }

    private fun createLotto(times: Int): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()
        repeat(times) {
            val lottoNumberCombination = LottoNumber.createRandomLottoNumber(randomLogic)
            lottoList.add(LottoMachine.createSelectLotto(lottoNumberCombination))
        }
        return lottoList
    }

    fun getWinningStats(winningLotto: WinningLotto, purchaseLottoList: List<Lotto>): EnumMap<LottoRanking, Int> {
        return WinningDomain.checkWinningResult(winningLotto, purchaseLottoList)
    }

    companion object {
        private const val DEFAULT_COST = 1000
    }
}

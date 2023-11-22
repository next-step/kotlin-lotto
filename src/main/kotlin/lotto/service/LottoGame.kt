package lotto.service

import lotto.data.Lotto
import lotto.data.LottoNumber
import lotto.data.LottoRanking
import lotto.data.NumberCombination
import lotto.data.WinningLotto
import lotto.domain.LottoCalculator
import lotto.domain.LottoMachine
import lotto.domain.RandomLogicInterface
import lotto.domain.WinningDomain
import java.util.EnumMap

class LottoGame(private val randomLogic: RandomLogicInterface, private val gameCost: Int = DEFAULT_COST) {

    fun getGameTimes(cash: Int): Int {
        return LottoCalculator.getTimes(cash, gameCost)
    }

    fun buyLotto(gameTimes: Int, numberCombinationList: List<NumberCombination> = emptyList()): List<Lotto> {
        val autoTimes = LottoCalculator.getAutoTimes(gameTimes, numberCombinationList.size)
        val lottoList = mutableListOf<Lotto>()

        lottoList.addAll(numberCombinationList.map { createManualLotto(it) })
        lottoList.addAll(createLotto(autoTimes))

        return lottoList
    }

    fun getWinningStats(winningLotto: WinningLotto, purchaseLottoList: List<Lotto>): EnumMap<LottoRanking, Int> {
        return WinningDomain.checkWinningResult(winningLotto, purchaseLottoList)
    }

    private fun createLotto(times: Int): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()
        repeat(times) {
            val lottoNumberCombination = LottoNumber.createRandomLottoNumber(randomLogic)
            lottoList.add(LottoMachine.createSelectLotto(lottoNumberCombination))
        }
        return lottoList
    }

    private fun createManualLotto(numberCombination: NumberCombination): Lotto {
        val lottoNumberCombination = LottoNumber.createLottoNumbers(numberCombination)
        return LottoMachine.createSelectLotto(lottoNumberCombination)
    }

    companion object {
        private const val DEFAULT_COST = 1000
    }
}

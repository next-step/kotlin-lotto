package lotto.domain

import lotto.domain.number.LottoNumberGenerator
import lotto.domain.purchase.LottoBuyingPrice
import lotto.domain.result.LottoMatchResult
import lotto.domain.result.LottoPlayResult
import lotto.domain.result.LottoRank

class LottoMachine private constructor(
    val autoLottoCount: LottoCount,
    lottoNumberGenerator: LottoNumberGenerator,
    manualLottos: List<Lotto>,
) {

    private val _lottos: MutableList<Lotto> = mutableListOf()
    val manualLottoCount: LottoCount = LottoCount.from(manualLottos.size)

    val lottos: List<Lotto>
        get() = _lottos

    init {
        _lottos.addAll(manualLottos)
        generateAutoLottos(lottoNumberGenerator)
    }

    fun getLottoTotalPrice(): LottoPrice {
        val totalLottoCount = autoLottoCount.plus(manualLottoCount)
        return LottoPrice.getTotalPrice(totalLottoCount)
    }

    fun getResult(winningLotto: WinningLotto, buyingPrice: LottoBuyingPrice): LottoMatchResult {
        val matchCountByRank = getMatchCountByRank(winningLotto)
        val lottoResult = LottoPlayResult(matchCountByRank)
        val earningRate = lottoResult.calculateEarningRate(buyingPrice)
        return LottoMatchResult(lottoResult.matchCountByRank, earningRate)
    }

    private fun generateAutoLottos(lottoNumberGenerator: LottoNumberGenerator) {
        repeat(autoLottoCount.value) {
            val lotto = Lotto.createFromGenerator(lottoNumberGenerator)
            _lottos.add(lotto)
        }
    }

    private fun getMatchCountByRank(winningLotto: WinningLotto): Map<LottoRank, Int> =
        lottos.map { lotto -> createLottoRank(lotto, winningLotto) }
            .groupingBy { it }
            .fold(INIT_MATCH_COUNT) { count, _ -> count + 1 }

    private fun createLottoRank(
        lotto: Lotto,
        winningLotto: WinningLotto,
    ): LottoRank {
        val hasBonusBall = lotto.hasBonusBall(winningLotto.bonusNumber)
        val matchCount = lotto.calculateMatchCount(winningLotto, hasBonusBall)
        return LottoRank.from(matchCount, hasBonusBall)
    }

    companion object {
        private const val INIT_MATCH_COUNT = 0

        fun of(
            autoLottoCount: Int,
            lottoNumberGenerator: LottoNumberGenerator,
            manualLotto: List<Lotto>,
        ): LottoMachine {
            return LottoMachine(
                autoLottoCount = LottoCount.from(autoLottoCount),
                lottoNumberGenerator = lottoNumberGenerator,
                manualLottos = manualLotto
            )
        }
    }
}

package lotto.service

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoResults
import lotto.domain.Number
import lotto.domain.WinningLotto
import lotto.domain.purchase.Amount
import lotto.domain.purchase.LottoPurchaseCount
import lotto.view.dto.LottoRankDto
import lotto.view.dto.LottoResultsDto
import lotto.view.dto.WinningLottoDto
import lotto.view.dto.lotto.LottoDto
import lotto.view.dto.lotto.LottoPurchaseCountDto
import lotto.view.dto.lotto.LottosDto

class LottoService(
    private val lottoGenerator: LottoGenerator,
) {
    fun createPurchaseCount(
        pay: Int,
        manualLottoAmount: Int,
    ): LottoPurchaseCountDto {
        val purchaseCount = LottoPurchaseCount(pay, Amount(manualLottoAmount))
        return LottoPurchaseCountDto(purchaseCount.autoLottoAmount.value, purchaseCount.manualLottoAmount.value)
    }

    fun createLottos(
        purchaseCountDto: LottoPurchaseCountDto,
        manualLottosDto: LottosDto,
    ): LottosDto {
        val manualLottos = manualLottosDto.lottos.map { Lotto.from(it.numbers) }
        val autoLottos = Lotto.createAutoLottos(purchaseCountDto.autoLottoAmount, lottoGenerator)
        val totalLottos = manualLottos + autoLottos
        return LottosDto(totalLottos.map { LottoDto(it.getNumbersRawValues()) })
    }

    fun getResults(
        lottosDto: LottosDto,
        winningLottoDto: WinningLottoDto,
        bonusBall: Int,
    ): LottoResultsDto {
        val lottos = lottosDto.lottos.map { Lotto(it.numbers.map { value -> Number(value) }) }
        val winningLotto = WinningLotto(Lotto(winningLottoDto.numbers.map { Number(it) }), Number(bonusBall))
        val lottoRankCountMap = lottos.map { it.match(winningLotto) }.groupingBy { it }.eachCount()
        val lottoResults = LottoResults.from(lottoRankCountMap)
        val winResults = lottoResults.filterWinResults()

        return LottoResultsDto(
            winResults =
                winResults.map {
                    LottoRankDto(
                        matchCount = it.rank.matchCount,
                        reward = it.rank.reward,
                        winCount = it.count,
                        containBonus = it.rank.containBonus,
                    )
                },
            profitRate = lottoResults.calculateProfitRate(),
            isProfit = lottoResults.isProfit(),
            margin = LottoResults.MARGIN_VALUE,
        )
    }
}

package lotto.service

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoPurchaseCount
import lotto.domain.LottoResults
import lotto.domain.Number
import lotto.view.dto.LottoRankDto
import lotto.view.dto.LottoResultsDto
import lotto.view.dto.WinningLottoDto
import lotto.view.dto.lotto.LottoDto
import lotto.view.dto.lotto.LottosDto

class LottoService(
    private val lottoGenerator: LottoGenerator,
) {
    fun createLottos(payAmount: Int): LottosDto {
        val count = LottoPurchaseCount(payAmount)
        val lottos = Lotto.createLottos(count.amount, lottoGenerator)
        return LottosDto(lottos.map { LottoDto(it.getNumbersRawValues()) })
    }

    fun getResults(
        lottosDto: LottosDto,
        winningLottoDto: WinningLottoDto,
        bonusNumber: Int,
    ): LottoResultsDto {
        val lottos = lottosDto.lottos.map { Lotto(it.numbers.map { value -> Number(value) }) }
        val winningLotto = Lotto(winningLottoDto.numbers.map { Number(it) })
        val lottoRankCountMap = lottos.map { it.match(winningLotto, Number(bonusNumber)) }.groupingBy { it }.eachCount()
        val lottoResults = LottoResults.from(lottoRankCountMap)
        val winResults = lottoResults.filterWinResults()

        return LottoResultsDto(
            winResults = winResults.map { LottoRankDto(matchCount = it.rank.matchCount, reward = it.rank.reward, winCount = it.count) },
            profitRate = lottoResults.calculateProfitRate(),
            isProfit = lottoResults.isProfit(),
            margin = LottoResults.MARGIN_VALUE,
        )
    }
}

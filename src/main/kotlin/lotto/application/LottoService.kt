package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoProperties
import lotto.domain.LottoResult
import lotto.domain.LottoResultMap
import lotto.domain.ProfitRate

class LottoService(
    private val properties: LottoProperties = LottoProperties(),
) : LottoUseCase {

    fun payPriceAndGetCount(price: Int): Int {
        require(price > 0) { "지불하는 금액은 0보다 커야합니다" }
        return price / properties.lottoPrice
    }

    fun generate(count: Int): List<Lotto> {
        return generateSequence { Lotto() }
            .take(count)
            .toList()
    }

    override fun buy(price: Int): List<Lotto> {
        val count = payPriceAndGetCount(price)
        return generate(count)
    }

    override fun matchWinningLotto(command: MatchWinningLottoCommand): LottoResultMap {
        val result = mutableListOf<LottoResult>()
        for (userLotto in command.userLottos) {
            result.add(userLotto.match(command.winningLotto))
        }
        return LottoResultMap.of(result)
    }

    override fun calculateProfitRate(lottoResultMap: LottoResultMap): ProfitRate {
        val totalLottoPrice = lottoResultMap.getTotalCount() * properties.lottoPrice
        val totalWinningPrice = lottoResultMap.getWinningPrice()
        return ProfitRate(totalWinningPrice / totalLottoPrice.toDouble())
    }
}

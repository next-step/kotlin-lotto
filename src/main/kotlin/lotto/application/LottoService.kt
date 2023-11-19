package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoProperties
import lotto.domain.LottoResult

class LottoService(
    private val properties: LottoProperties = LottoProperties(),
) : LottoUseCase {

    fun payPriceAndGetCount(price: Int): Int{
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

    override fun matchWinningLotto(command: MatchWinningLottoCommand): List<LottoResult> {
        val result = mutableListOf<LottoResult>()
        for (userLotto in command.userLottos) {
            result.add(userLotto.match(command.winningLotto))
        }
        return result
    }

    override fun calculateProfitRate(lottos: List<LottoResult>): Double {
        val totalWinningPrice: Double = lottos.sumOf { it.price }.toDouble()
        return totalWinningPrice / (lottos.size * properties.lottoPrice)
    }
}
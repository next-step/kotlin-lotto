package lotto.application

import lotto.application.dto.LottoResult
import lotto.application.vo.Purchase
import lotto.domain.Lotto
import lotto.domain.LottoBundle
import lotto.domain.WinningLotto
import lotto.domain.vo.LottoNumber

private const val START_INDEX = 0
private const val END_INDEX = 6
private const val MIN_NUMBER = 1
private const val MAX_NUMBER = 45

class LottoMachine(
    private val purchase: Purchase
) {

    fun buyAuto(): LottoBundle =
        List(purchase.lottoPurchaseCount) {
            Lotto(LOTTO_NUMBERS.shuffled().subList(START_INDEX, END_INDEX).sorted().toSet())
        }.let(::LottoBundle)

    fun drawLottoBundle(
        lottoBundle: LottoBundle,
        winningLotto: WinningLotto
    ): LottoResult {
        val winningResults = winningLotto.match(lottoBundle)
        val winningRate = winningResults.map { it.amount }
            .reduce { acc, amount -> acc + amount }
            .value
            .div(purchase.amount.value.toDouble())
        return LottoResult(
            winningRate = winningRate,
            winningResults = winningResults.groupingBy { it }
                .eachCount()
        )
    }

    companion object {
        private val LOTTO_NUMBERS = (MIN_NUMBER..MAX_NUMBER).map(::LottoNumber)
    }
}

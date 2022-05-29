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
private const val DELIMITER = ","
class LottoMachine(
    private val purchase: Purchase
) {

    fun buy(manualLottoNumbers: List<String>): LottoBundle {
        require(purchase.purchaseCounts.manualLottoCount.count == manualLottoNumbers.size) {
            "수동로또 구입 갯수와 입력한 수동 로또 갯수가 일치 해야합니다."
        }
        return buildList {
            addAll(buyManual(manualLottoNumbers))
            addAll(buyAuto())
        }.let(::LottoBundle)
    }

    private fun buyManual(manualLottoNumbers: List<String>): List<Lotto> = manualLottoNumbers.map { lottoNumber ->
        lottoNumber.split(DELIMITER)
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("로또 번호는 숫자만 가능합니다.") }
            .map(::LottoNumber)
            .toSet()
    }.map(::Lotto)

    private fun buyAuto(): List<Lotto> =
        List(purchase.purchaseCounts.autoLottoCount.count) {
            Lotto(LOTTO_NUMBERS.shuffled().subList(START_INDEX, END_INDEX).sorted().toSet())
        }

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

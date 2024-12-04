package lotto.view

import lotto.domain.BoughtMoney
import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.ManualLottoAmount
import lotto.domain.Reward

class OutputView {
    fun printLottos(
        boughtMoney: BoughtMoney,
        manualLottoAmount: ManualLottoAmount,
        lottos: List<Lotto>,
    ) {
        println("수동으로 ${manualLottoAmount.value}장, 자동으로 ${boughtMoney.calculateAutoLottoAmount(manualLottoAmount)}장 구매했습니다.")
        lottos.forEach {
            val lottoNumbersString = it.numbers.joinToString(", ") {
                    lottoNumber -> lottoNumber.value.toString()
            }
            println("[$lottoNumbersString]")
        }
    }

    fun printResult(lottoResult: LottoResult) {
        println(
            """
            당첨 통계
            ---------
            """.trimIndent()
        )
        lottoResult.winningRewards
            .forEach { (reward, count) ->
                when (reward) {
                    Reward.SECOND -> println("${reward.matchingNumberCount}개 일치, 보너스볼 일치(${reward.money}원)- ${count}개")
                    else -> println("${reward.matchingNumberCount}개 일치 (${reward.money}원)- ${count}개")
                }
            }
        println("총 수익률은 ${lottoResult.calculateRateOfReturn()}입니다.")
    }
}
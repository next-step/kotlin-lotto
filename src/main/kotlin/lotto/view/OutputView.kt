package lotto.view

import lotto.domain.LottoResult
import lotto.domain.Lottos
import lotto.domain.Prize

class OutputView {
    fun showLottoCount(lottos: Lottos) {
        val size = lottos.lottos
            .size
        println("${size}개를 구매했습니다.")
    }

    fun showLotto(lottos: Lottos) {
        lottos.lottos
            .forEach {
                println(
                    "[${
                        it.lottoNumbers.map { lottoNumber -> lottoNumber.number }
                            .joinToString(", ")
                    }]")
            }
    }

    fun showResult(lottoResult: LottoResult, money: Int) {
        println("당첨 통계")
        println("---------")
        Prize.entries
            .filter { it != Prize.NONE }
            .reversed()
            .forEach { prize ->
                val title = if (prize == Prize.SECOND) {
                    "${prize.count}개 일치, 보너스 볼 일치 (${prize.money}원)"
                } else {
                    "${prize.count}개 일치 (${prize.money}원)"
                }
                println("$title - ${lottoResult[prize]}개")
            }

        println(String.format("총 수익률은 %.2f입니다.", lottoResult.getRateOfReturn(money)))
    }
}

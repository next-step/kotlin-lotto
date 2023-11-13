package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoRank

object OutputView {
    fun printRequestInputMoney() {
        println("구입금액을 입력해 주세요.")
    }

    fun printRequestInputWinningLotto() {
        println("지난 주 당첨 번호를 입력해 주세요.")
    }

    fun printRequestInputBonusNumber() {
        println("보너스 볼을 입력해 주세요.")
    }

    fun printBuyingResult(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")

        lottos.forEach {
            val numbers = it.numbers.map { lottoNumber ->
                lottoNumber.number
            }
            println(numbers.joinToString(", ", "[", "]"))
        }
    }

    fun printLottoRanks(lottoRanks: Map<LottoRank, Int>) {
        println("당첨 통계")
        println("---------")
        LottoRank.values().sortedByDescending { it }.forEach {
            if (it == LottoRank.MISS) return@forEach
            if (lottoRanks[it] == null) {
                println("${it.count}개 일치 ${it.prize}원 - 0개")
                return@forEach
            }
            println("${it.count}개 일치 ${it.prize}원 - ${lottoRanks[it]}개")
        }
    }

    fun printEarningRate(calculateEarningRate: Double) {
        println("총 수익률은 $calculateEarningRate%입니다.")
    }
}

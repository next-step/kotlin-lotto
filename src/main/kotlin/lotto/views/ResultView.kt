package lotto.views

import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.domain.Report

object ResultView {

    fun printLottos(manualLottos: List<Lotto> = emptyList(), autoLottos: List<Lotto>) {
        print("수동으로 ${manualLottos.size}장, 자동으로 ${autoLottos.size}장을 구매했습니다.")
        manualLottos.forEach {
            println(it)
        }
        autoLottos.forEach {
            println(it)
        }
    }

    fun printResult(report: Report) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (${Rank.FIFTH.krw.money}원)- ${report.fifthCount}개")
        println("4개 일치 (${Rank.FOURTH.krw.money}원)- ${report.fourthCount}개")
        println("5개 일치 (${Rank.THIRD.krw.money}원)- ${report.thirdCount}개")
        println("5개 일치, 보너스 볼 일치(${Rank.SECOND.krw.money}원)- ${report.secondCount}개")
        println("6개 일치 (${Rank.FIRST.krw.money}원)- ${report.firstCount}개")
        println("총 수익률은 ${report.getRateOfReturn()}입니다.")
    }

    fun printErrorMessage(exception: Exception) {
        println(exception.message)
    }
}

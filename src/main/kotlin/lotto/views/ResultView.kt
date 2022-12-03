package lotto.views

import lotto.domain.Lotto
import lotto.domain.Report

object ResultView {

    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach {
            println(it)
        }
    }

    fun printResult(report: Report) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (${report.fourthWin.krw.money}원)- ${report.fourthWin.count}개")
        println("4개 일치 (${report.thirdWin.krw.money}원)- ${report.thirdWin.count}개")
        println("5개 일치 (${report.secondWin.krw.money}원)- ${report.secondWin.count}개")
        println("6개 일치 (${report.firstWin.krw.money}원)- ${report.firstWin.count}개")
        println("총 수익률은 ${report.getRateOfReturn()}입니다.")
    }
}

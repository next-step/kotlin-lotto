package lotto.view

import lotto.domain.Rank
import lotto.domain.Tickets
import java.text.DecimalFormat

private const val COUNT_STRING = "개를 구매했습니다."

private const val RESULT_STRING = "\n당첨 통계\n---------"

private const val LOSS_STRING = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"

object ResultView {
    fun printLottoCounts(count: Int) {
        println("${count}$COUNT_STRING")
    }

    fun printLottoNums(tickets: Tickets) {
        tickets.tickets.forEach { println(it.numbers) }
    }

    fun printResult(score: List<Rank>, rate: Float) {
        println(RESULT_STRING)
        Rank.values()
            .filter { it != Rank.NONE }
            .sortedBy { it.reward }
            .forEach { rank ->
                print("${rank.count}개 일치")
                if (rank == Rank.SECOND) print(", 보너스 볼 일치")
                println("(${rank.reward}원) - ${score.count { score -> score == rank }}개")
            }

        print("총 수익률은 ${DecimalFormat("#.##").format(rate)}입니다.")
        if (rate < 1) {
            println(LOSS_STRING)
        }
    }
}

package lotto.view

import lotto.model.LottoTicket
import lotto.model.Rank
import lotto.model.GameResults

object Output {
    fun printLottoTicket(manualCount: Int, autoCount: Int, lottoTicket: LottoTicket) {
        println("수동 ${manualCount}개, 자동 ${autoCount}개를 구입했습니다.")
        println(lottoTicket.toString())
    }

    fun printResult(GameResults: GameResults) {
        println("당첨통계")
        Rank.values()
            .filter { it.ordinal < Rank.ELSE.ordinal }
            .forEach {
                println(convertString(it, GameResults))
            }
    }

    private fun convertString(rank: Rank, GameResults: GameResults): String {
        return if (rank.name == Rank.SECOND.name) {
            "${rank.match}개 일치, Bonus 일치 (${rank.price}) - ${GameResults.of(rank)}개"
        } else {
            "${rank.match}개 일치 (${rank.price}) - ${GameResults.of(rank)}개"
        }
    }
}

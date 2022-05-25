package lotto.view

import lotto.constants.Messages
import lotto.model.LottoResult
import lotto.model.LottoTicket

/**
 * 출력을 위한 클래스
 * Created by Jaesungchi on 2022.05.25..
 */
object OutputView {
    fun printTicket(tickets: List<LottoTicket>) {
        println("${tickets.size}${Messages.BUY_AMOUNT_LOTTO}")
        tickets.forEach {
            println(it.numbers.toString())
        }
    }

    fun printLottoResult(lottoResults: List<LottoResult>) {
        println(Messages.LOTTO_RESULT)
        println(Messages.CORRECT_THREE.format(lottoResults[0].count))
        println(Messages.CORRECT_FOUR.format(lottoResults[1].count))
        println(Messages.CORRECT_FIVE.format(lottoResults[2].count))
        println(Messages.CORRECT_SIX.format(lottoResults[3].count))
    }

    fun printYield(yields: Double) {
        println(Messages.PRINT_YIELD.format(yields))
    }
}

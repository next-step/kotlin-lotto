package lotto.model

import io.kotest.core.spec.style.BehaviorSpec
import org.junit.jupiter.api.Assertions.*

//class ProfitCalculatorTest : BehaviorSpec({
//    given(
//        "로또 가격이 1000원, " +
//                "번호 일치 결과가 1개 일치: 1개 / 5개 일치: 1개 / 6개 일치: 1개," +
//                "수령 당첨금이 3개 일치 시 5000원 4개 일치 시 50000원 5개 일치 시 1500000원 6개 일치 시 2000000000원 일때"
//    ) {
//        val ticketPrice = 1000
//        val matchResult = listOf(1, 3, 0, 1, 0, 0, 0)
//        val winningMoney = listOf(0, 0, 0, 5000, 50000, 1500000, 2000000000)
//        `when`("계산 했을 때") {
//            val profit = ProfitCalculator.calculate(ticketPrice, matchResult, winningMoney)
//            then("수익률은  계산된다") {
//                profit shouldBe 1.0
//            }
//        }
//    }
//})

package lotto.domain.lotto.benefit

import io.kotest.core.Tuple3
import io.kotest.core.Tuple4
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.doubles.shouldBeGreaterThan
import io.kotest.matchers.doubles.shouldBeLessThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import lotto.domain.lotto.price.LottoCost
import lotto.domain.lotto.price.LottoTicketPrice
import org.junit.jupiter.api.assertThrows

class LottoBenefitTest : FunSpec({

    context("LottoBenefit이 정상적으로 생성된다") {
        withData(
            nameFn = { "benefit=${it.a}, cost=${it.b}, price=${it.c}" },
            listOf(
                1000 to 20,
                2000 to 100,
                3000 to 50,
                4000 to 5,
                5000 to 16
            ).map {
                val price = it.first
                val count = it.second
                val cost = price * count
                val benefit = randomBenefit()

                Tuple4(benefit, cost, price, count)
            }
        ) {(benefit, cost, price, count) ->
            val lottoBenefit = LottoBenefit(benefit, LottoCost(cost, LottoTicketPrice(price)))

            val expectedProfit = benefit.toDouble() / cost

            lottoBenefit shouldNotBe null

            lottoBenefit.benefit shouldBe benefit
            lottoBenefit.lottoCost.ticketCost shouldBe cost
            lottoBenefit.lottoCost.ticketCount shouldBe count
            lottoBenefit.profit shouldBeGreaterThan expectedProfit - 0.01
            lottoBenefit.profit shouldBeLessThan  expectedProfit + 0.01
        }
    }

    context("benefit이 0보다 작으면, IllegalArgumentException") {
        withData(
            nameFn = { "benefit=${it}, cost=${it.b}, price=${it.c}" },
            (-1 downTo -10000 step 50).map {
                Tuple3(it, 4500, 1000)
            }
        ) {(benefit, cost, price) ->
            assertThrows<IllegalArgumentException> {
                LottoBenefit(benefit, LottoCost(cost, LottoTicketPrice(price)))
            }
        }
    }
})

fun randomBenefit(): Int {
    return LottoBenefitLevel.positiveBenefitLevelSet().random().benefitPerTicket
}

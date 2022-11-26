package lotto.domain.lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.doubles.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import lotto.domain.lotto.benefit.LottoBenefitPolicy
import lotto.domain.lotto.ticket.LottoTicket
import org.junit.jupiter.api.assertThrows

class LottoTest : FunSpec({
    context("비용을 입력받아서, 로또 생성이 가능하다") {
        withData(
            nameFn = { "Lotto($it)" },
            listOf(
                14000,
                15000,
                16000,
                17000,
                18000,
            )
        ) { cost ->
            val lotto = Lotto(cost)

            val expectedTicketCount = cost.div(lotto.lottoTicketPrice.price)
            lotto.lottoTicketList shouldHaveSize expectedTicketCount

            lotto.lottoTicketList.toSet() shouldHaveSize expectedTicketCount

            lotto.lottoTicketList.map { lottoTicket ->
                lottoTicket.lottoNumberList.map { lottoNumber ->
                    lottoNumber.number
                }
            }.toSet() shouldHaveSize expectedTicketCount

            lotto.lottoTicketList.forEach { lottoTicket ->
                lottoTicket.lottoNumberList.map { lottoNumber ->
                    lottoNumber.number
                }.toSet() shouldHaveSize LottoTicket.TOTAL_COUNT_LOTTO_NUMBER
            }
        }
    }

    context("비용, 가격을 입력받아서, 로또 생성이 가능하다.") {
        withData(
            nameFn = { "Lotto(${it.first},${it.second})" },
            listOf(
                14000 to 1000,
                14000 to 2000,
                14000 to 3000,
                14000 to 4000,
                14000 to 5000,
            )
        ) { (cost, price) ->
            val lotto = Lotto(cost, price)

            val expectedTicketCount = cost.div(price)
            lotto.lottoTicketList shouldHaveSize expectedTicketCount

            lotto.lottoTicketList.toSet() shouldHaveSize expectedTicketCount

            lotto.lottoTicketList.map { lottoTicket ->
                lottoTicket.lottoNumberList.map { lottoNumber ->
                    lottoNumber.number
                }
            }.toSet() shouldHaveSize expectedTicketCount

            lotto.lottoTicketList.forEach { lottoTicket ->
                lottoTicket.lottoNumberList.map { lottoNumber ->
                    lottoNumber.number
                }.toSet() shouldHaveSize LottoTicket.TOTAL_COUNT_LOTTO_NUMBER
            }
        }
    }

    context("비용 혹은 가격이 0보다 같거나 작으면, 로또 생성이 불가능하다") {
        withData(
            nameFn = { "${it.first}, ${it.second}" },
            listOf(
                14000 to 0,
                0 to 2000,
                14000 to -2000,
                -14000 to 4000,
                -14000 to -1000
            )
        ) { (cost, price) ->
            assertThrows<IllegalArgumentException> { Lotto(cost, price) }
        }
    }

    context("비용이 가격보다 작으면, 로또 생성이 불가능하다") {
        withData(
            nameFn = { "${it.first} < ${it.second}" },
            listOf(
                900 to 1000,
                1800 to 2000,
                2999 to 3000,
                3999 to 4000,
                10 to 5000,
            )
        ) { (cost, price) ->
            assertThrows<IllegalArgumentException> { Lotto(cost, price) }
        }
    }

    test("LottoBenefit이 정상적으로 생성된다") {
        val givenLottoCost = 1400000
        val givenLottoTicketPrice = 1000
        val givenLottoAnswer = LottoAnswer(listOf(1, 2, 3, 4, 5, 6))
        val lotto = Lotto(givenLottoCost, givenLottoTicketPrice)

        val lottoBenefit = lotto.benefit(givenLottoAnswer)

        lottoBenefit shouldNotBe null
        lottoBenefit.lottoCost.cost shouldBe givenLottoCost
        lottoBenefit.benefit shouldBeGreaterThanOrEqual 0
        lottoBenefit.profit shouldBeGreaterThanOrEqual 0.0
    }

    test("LottoResult가 정상적으로 생성된다") {
        val givenLottoCost = 1400000
        val givenLottoTicketPrice = 1000
        val givenLottoAnswer = LottoAnswer(listOf(1, 2, 3, 4, 5, 6))
        val lotto = Lotto(givenLottoCost, givenLottoTicketPrice)

        val lottoResult = lotto.result(givenLottoAnswer)

        lottoResult shouldNotBe null

        lottoResult.lottoBenefit shouldNotBe null
        lottoResult.lottoBenefit.lottoCost.cost shouldBe givenLottoCost
        lottoResult.lottoBenefit.benefit shouldBeGreaterThanOrEqual 0
        lottoResult.lottoBenefit.profit shouldBeGreaterThanOrEqual 0.0

        LottoBenefitPolicy.benefitPolicy.keys.forEach {
            lottoResult.lottoResultCountMap[it] shouldBeGreaterThanOrEqual 0
        }

        lottoResult.lottoResultCountMap.values.forEach { count ->
            count shouldBeGreaterThanOrEqual 0
        }

        lottoResult.lottoResultCountMap.values.sum() shouldBe lotto.lottoTicketList.size
    }
})

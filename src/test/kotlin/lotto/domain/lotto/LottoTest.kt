package lotto.domain.lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.doubles.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import lotto.domain.lotto.benefit.LottoBenefitLevel
import lotto.domain.lotto.ticket.LottoAnswerTicket
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
            lotto.lottoTicketContainer shouldHaveSize expectedTicketCount

            lotto.lottoTicketContainer.forEach {
                it shouldHaveSize LottoTicket.TOTAL_COUNT_LOTTO_NUMBER
            }
        }
    }

    context("비용과 수동 로또 티겟을 입력받아서, 로또 생성이 가능하다") {
        val givenLottoTicketPrice = 1000
        val maxLottoTicketCount = 20
        val givenLottoCost = givenLottoTicketPrice * maxLottoTicketCount

        withData(
            nameFn = { "Lotto($it)" },
            (0..maxLottoTicketCount).map { lottoTicketListHavingSizeOf(it) }
        ) { customLottoTicketList ->
            val lotto = Lotto(givenLottoCost, givenLottoTicketPrice, customLottoTicketList)

            val expectedTicketCount = givenLottoCost.div(givenLottoTicketPrice)
            lotto.lottoTicketContainer shouldHaveSize expectedTicketCount

            lotto.lottoTicketContainer.forEach {
                it shouldHaveSize LottoTicket.TOTAL_COUNT_LOTTO_NUMBER
            }

            lotto.lottoTicketContainer shouldContainAll customLottoTicketList
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
            lotto.lottoTicketContainer shouldHaveSize expectedTicketCount

            lotto.lottoTicketContainer.toSet() shouldHaveSize expectedTicketCount

            lotto.lottoTicketContainer.map { lottoTicket ->
                lottoTicket.map { lottoNumber ->
                    lottoNumber.number
                }
            }.toSet() shouldHaveSize expectedTicketCount

            lotto.lottoTicketContainer.forEach { lottoTicket ->
                lottoTicket.map { lottoNumber ->
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
        val givenLottoAnswerTicket = LottoAnswerTicket(LottoTicket(1, 2, 3, 4, 5, 6))
        val lotto = Lotto(givenLottoCost, givenLottoTicketPrice)

        val lottoBenefit = lotto.benefit(givenLottoAnswerTicket)

        lottoBenefit shouldNotBe null
        lottoBenefit.lottoCost.inputCost shouldBe givenLottoCost
        lottoBenefit.benefit shouldBeGreaterThanOrEqual 0
        lottoBenefit.profit shouldBeGreaterThanOrEqual 0.0
    }

    test("LottoResult가 정상적으로 생성된다") {
        val givenLottoCost = 1400000
        val givenLottoTicketPrice = 1000
        val givenLottoAnswerTicket = LottoAnswerTicket(LottoTicket(1, 2, 3, 4, 5, 6))
        val lotto = Lotto(givenLottoCost, givenLottoTicketPrice)

        val lottoResult = lotto.result(givenLottoAnswerTicket)

        lottoResult shouldNotBe null

        lottoResult.lottoBenefit shouldNotBe null
        lottoResult.lottoBenefit.lottoCost.inputCost shouldBe givenLottoCost
        lottoResult.lottoBenefit.benefit shouldBeGreaterThanOrEqual 0
        lottoResult.lottoBenefit.profit shouldBeGreaterThanOrEqual 0.0

        LottoBenefitLevel.values().forEach {
            lottoResult.lottoResultMap.winningCount(it) shouldBeGreaterThanOrEqual 0
        }
    }
})

fun lottoTicketListHavingSizeOf(count: Int): List<LottoTicket> {
    require(count >= 0) {
        "$count should be greater or equal than 0"
    }

    return (1..count)
        .map { LottoTicket.randomGenerate() }
        .toList()
}

package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.maps.shouldContainAll
import io.kotest.matchers.shouldBe

class LotteryTest : FunSpec({
    context("Lottery") {
        val lottos =
            listOf(
                Lotto.fromRawNumbers(listOf(1, 2, 3, 4, 5, 6)),
                Lotto.fromRawNumbers(listOf(1, 2, 3, 4, 5, 7)),
                Lotto.fromRawNumbers(listOf(1, 2, 3, 4, 7, 8)),
                Lotto.fromRawNumbers(listOf(40, 41, 42, 43, 44, 45)),
            )
        val winningLotto = Lotto.fromRawNumbers(listOf(1, 2, 3, 4, 5, 6))

        val lottery = Lottery(lottos, winningLotto)

        test("return all prizes produced by lottery") {
            val expected =
                mapOf(
                    Prize.FIRST to 1,
                    Prize.SECOND to 1,
                    Prize.THIRD to 1,
                    Prize.FOURTH to 0,
                    Prize.NONE to 1,
                )

            lottery.result shouldContainAll expected
        }
        test("return rate should be all price summed divided by amount inserted") {
            val expected =
                listOf(
                    Prize.FIRST,
                    Prize.SECOND,
                    Prize.THIRD,
                    Prize.NONE,
                ).sumOf { it.value }
                    .toBigDecimal()
                    .divide(4000.toBigDecimal())

            lottery.returnRate shouldBe expected
        }
    }
})

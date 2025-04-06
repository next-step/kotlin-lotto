package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.maps.shouldContainAll
import io.kotest.matchers.shouldBe

class LotteryTest : BehaviorSpec({
    given("four lottos and one winning lotto") {
        val lottos =
            listOf(
                Lotto(1, 2, 3, 4, 5, 6),
                Lotto(1, 2, 3, 4, 5, 7),
                Lotto(1, 2, 3, 4, 7, 8),
                Lotto(40, 41, 42, 43, 44, 45),
            )
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber.from(7)

        val lottery = Lottery(lottos, winningLotto, bonusNumber)

        `when`("the lottery is drawn") {
            then("it should return all prizes produced by the lottery") {
                val expected =
                    mapOf(
                        Prize.FIRST to 1,
                        Prize.SECOND to 1,
                        Prize.THIRD to 0,
                        Prize.FOURTH to 1,
                        Prize.FIFTH to 0,
                        Prize.NONE to 1,
                    )

                lottery.result shouldContainAll expected
            }

            then("it should calculate by dividing the sum of prizes by inserted amount") {
                val expected =
                    listOf(
                        Prize.FIRST,
                        Prize.SECOND,
                        Prize.FOURTH,
                        Prize.NONE,
                    ).sumOf { it.value }
                        .toBigDecimal()
                        .divide(4000.toBigDecimal())

                lottery.returnRate shouldBe expected
            }
        }
    }
})

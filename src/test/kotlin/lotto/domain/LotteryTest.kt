package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe

class LotteryTest : BehaviorSpec({
    given("four lottos and one winning lotto") {
        val lottos =
            Lottos(
                listOf(
                    Lotto(1, 2, 3, 4, 5, 6),
                    Lotto(1, 2, 3, 4, 5, 7),
                    Lotto(1, 2, 3, 4, 7, 8),
                    Lotto(40, 41, 42, 43, 44, 45),
                ),
            )
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber.from(7)

        val lottery = Lottery(lottos, winningLotto, bonusNumber)
        val expected =
            listOf(
                Prize.FIRST,
                Prize.SECOND,
                Prize.FOURTH,
                Prize.NONE,
            )

        `when`("the lottery is drawn") {
            then("it should return all prizes produced by the lottery") {
                val prizes =
                    lottery.result
                        .filter { it.value == 1 }
                        .map { it.key }

                prizes shouldContainAll expected
            }

            then("it should calculate by dividing the sum of prizes by inserted amount") {
                val expectedRate = expected.sumOf { it.value } / 4_000.toDouble()

                lottery.returnRate shouldBe expectedRate
            }
        }
    }
})

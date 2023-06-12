package lottery

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import lottery.LotteryNumberTest.Companion.LOTTERY_NUMBER_1
import lottery.LotteryNumberTest.Companion.LOTTERY_NUMBER_2
import lottery.LotteryNumberTest.Companion.LOTTERY_NUMBER_3
import lottery.LotteryNumberTest.Companion.LOTTERY_NUMBER_4
import lottery.LotteryNumberTest.Companion.LOTTERY_NUMBER_5
import lottery.LotteryNumberTest.Companion.LOTTERY_NUMBER_6
import lottery.LotteryNumberTest.Companion.LOTTERY_NUMBER_7

class LotteryTest : FunSpec({

    context("init") {
        test("로또 번호가 6개 입력되지 않는 경우 예외가 발생한다.") {
            forAll(
                row(listOf(
                        LOTTERY_NUMBER_1,
                        LOTTERY_NUMBER_2,
                        LOTTERY_NUMBER_3,
                        LOTTERY_NUMBER_4,
                        LOTTERY_NUMBER_5
                    )
                ),
                row(listOf(
                        LOTTERY_NUMBER_1,
                        LOTTERY_NUMBER_2,
                        LOTTERY_NUMBER_3,
                        LOTTERY_NUMBER_4,
                    LOTTERY_NUMBER_5,
                    LOTTERY_NUMBER_6,
                    LOTTERY_NUMBER_7
                )
                )
            ) { input ->
                val exception = shouldThrowExactly<IllegalArgumentException> { Lottery(values = input) }
                exception.message shouldBe "로또 번호는 6개만 입력하여야한다"
            }
        }

        test("로또 번호가 중복되어 입력되는 경우 예외가 발생한다.") {
            val input = listOf(
                LOTTERY_NUMBER_1,
                LOTTERY_NUMBER_2,
                LOTTERY_NUMBER_3,
                LOTTERY_NUMBER_4,
                LOTTERY_NUMBER_5,
                LOTTERY_NUMBER_5
            )

            val exception = shouldThrowExactly<IllegalArgumentException> { Lottery(values = input) }
            exception.message shouldBe "로또 번호는 중복되어 입력될 수 없다"
        }

        test("로또 번호를 6개 가지고 있다") {
            val input = listOf(
                LOTTERY_NUMBER_1,
                LOTTERY_NUMBER_2,
                LOTTERY_NUMBER_3,
                LOTTERY_NUMBER_4,
                LOTTERY_NUMBER_5,
                LOTTERY_NUMBER_6
            )
            val actual = Lottery(values = input)
            actual.values shouldHaveSize 6
        }
    }
})

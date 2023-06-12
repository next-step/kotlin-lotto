package lottery.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class LotteryNumberTest : FunSpec({

    context("init") {
        test("로또 번호가 1~45 이외의 수가 저장되려 하는 경우 예외가 발생한다.") {
            forAll(row(0), row(46)) { input ->
                val exception = shouldThrowExactly<IllegalArgumentException> { LotteryNumber(value = input) }
                exception.message shouldBe "로또 번호는 1~45의 수만 입력 가능하다."
            }
        }
    }
}) {
    companion object {
        val LOTTERY_NUMBER_1 = LotteryNumber(1)
        val LOTTERY_NUMBER_2 = LotteryNumber(2)
        val LOTTERY_NUMBER_3 = LotteryNumber(3)
        val LOTTERY_NUMBER_4 = LotteryNumber(4)
        val LOTTERY_NUMBER_5 = LotteryNumber(5)
        val LOTTERY_NUMBER_6 = LotteryNumber(6)
        val LOTTERY_NUMBER_7 = LotteryNumber(7)
        val LOTTERY_NUMBER_8 = LotteryNumber(8)
        val LOTTERY_NUMBER_9 = LotteryNumber(9)
    }
}

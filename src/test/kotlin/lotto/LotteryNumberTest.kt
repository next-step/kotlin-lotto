package lotto

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import lotto.domain.LotteryNumber

class LotteryNumberTest : BehaviorSpec({

    Given("로또 숫자가") {
        When("1이상 45이하이면") {
            val nums = listOf(1, 30, 45)
            nums.forAll { num ->
                Then("로또 숫자가 정상적으로 생성된다.") {
                    shouldNotThrow<IllegalArgumentException> {
                        LotteryNumber(num)
                    }
                }
            }
        }

        When("1미만 45초과이면") {
            val nums = listOf(-1, 0, 46)
            nums.forAll { num ->
                Then("IllegalArgumentException 예외가 발생한다.") {
                    shouldThrow<IllegalArgumentException> {
                        LotteryNumber(num)
                    }
                }
            }
        }
    }
})

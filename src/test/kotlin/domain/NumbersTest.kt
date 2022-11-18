package domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class NumbersTest : BehaviorSpec({
    given("아무 element 도 없는 숫자 리스트에서") {
        val numbers = Numbers()
        `when`("합계를 내면") {
            val sum = numbers.sum()
            then("0 을 반환한다") {
                sum shouldBe ZERO
            }
        }
    }

    given("하나의 element 가 있는 숫자 리스트에서") {
        val numbers = Numbers(listOf(TEN))
        `when`("합계를 내면") {
            val sum = numbers.sum()
            then("하나의 element 를 반환한다.") {
                sum shouldBe TEN
            }
        }
    }

    given("여러 element 가 있는 숫자 리스트에서") {
        val numbers = Numbers(multipleNumbers)
        `when`("합계를 내면") {
            val sum = numbers.sum()
            then("올바른 합을 반환한다.") {
                sum shouldBe multipleNumbers.sum()
            }
        }
    }
}) {
    companion object {
        private const val ZERO = 0
        private const val TEN = 10
        private val multipleNumbers = listOf(1, 2, 3, 4, 5)
    }
}

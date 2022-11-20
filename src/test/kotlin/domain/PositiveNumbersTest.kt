package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import java.lang.RuntimeException

class PositiveNumbersTest : BehaviorSpec({
    given("아무 element 도 없는 숫자 리스트에서") {
        val positiveNumbers = PositiveNumbers()
        `when`("합계를 내면") {
            val sum = positiveNumbers.sum()
            then("0 을 반환한다") {
                sum shouldBe ZERO
            }
        }
    }

    given("하나의 element 가 있는 숫자 리스트에서") {
        val numbers = PositiveNumbers(listOf(TEN))
        `when`("합계를 내면") {
            val sum = numbers.sum()
            then("하나의 element 를 반환한다.") {
                sum shouldBe TEN
            }
        }
    }

    given("여러 element 가 있는 숫자 리스트에서") {
        val numbers = PositiveNumbers(multipleNumbers)
        `when`("합계를 내면") {
            val sum = numbers.sum()
            then("올바른 합을 반환한다.") {
                sum shouldBe multipleNumbers.sum()
            }
        }
    }

    given("Numbers 객체에") {
        `when`("값을 할당할 때") {
            and("숫자가 아닌 문자열이라면") {
                invalidStringList.forAll {
                    then("IllegalArgumentException 을 반환한다.") {
                        val exception = shouldThrow<IllegalArgumentException> {
                            PositiveNumbers.from(it)
                        }
                        exception.message should startWith("유효하지 않은 숫자입니다.")
                    }
                }
            }

            and("음수가 있다면") {
                then("RuntimeException 을 반환한다.") {
                    val exception = shouldThrow<RuntimeException> {
                        PositiveNumbers.from(listOf("-2", "10", "-55", "24"))
                    }
                    exception.message should startWith("숫자는 음수일 수 없습니다.")
                }
            }
        }
    }
}) {
    companion object {
        private const val ZERO = 0
        private const val TEN = 10
        private val multipleNumbers = listOf(1, 2, 3, 4, 5)

        private val invalidStringList = listOf(
            listOf("d", "4d", "f", "^"),
            listOf("##", "sdff324$", "--", "윤"),
            listOf("코", "틀", "3", "짱")
        )
    }
}

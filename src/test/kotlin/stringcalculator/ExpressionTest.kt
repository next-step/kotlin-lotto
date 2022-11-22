package stringcalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class ExpressionTest: BehaviorSpec({
    given("기본 구분자로 구분된 문자열을 받아온다.") {
        val expressionString = "1,2:3"
        val expectedResult = Expression(listOf(1, 2, 3))
        `when`("문자열로 Expression을 생성하면") {
            val result = Expression.from(expressionString)
            then("구분자로 구분된 리스트를 갖는 Expression을 반환한다.") {
                result shouldBe expectedResult
            }
        }
    }

    given("기본 구분자와 커스텀 구분자로 구분된 문자열을 입력한다.") {
        val expressionString = "//;\n1,1;2:3"
        val expectedResult = Expression(listOf(1, 1, 2, 3))
        `when`("문자열로 Expression을 생성하면") {
            val result = Expression.from(expressionString)
            then( "구분자로 구분된 리스트를 갖는 Expression을 반환한다.") {
                result shouldBe expectedResult
            }
        }
    }

    given("음수가 포함된 문자열을 입력한다.") {
        val expressionString = "1,-1:0"
        `when`("문자열로 Expression을 생성하면") {
            then("IllegalArgumentException이 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    Expression.from(expressionString)
                }.message shouldBe "음수는 인자로 받을 수 없습니다."
            }
        }
    }
})

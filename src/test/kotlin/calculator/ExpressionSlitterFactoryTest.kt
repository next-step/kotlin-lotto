package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.types.shouldBeInstanceOf

class ExpressionSlitterFactoryTest : FunSpec({
    context("ExpressionSplitter 생성") {
        context("커스텀 구분자를 포함한 문자열을 전달하면") {
            test("CustomDelimiterSplitter 를 생성한다.") {
                // given
                val expression = Expression.from("//;\n1;2;3")
                // when
                val actual = ExpressionSlitterFactory.create(expression = expression)
                // then
                actual.shouldBeInstanceOf<CustomDelimiterSplitter>()
            }
        }

        context("커스텀 구분자를 포함하지 않는 문자열을 전달하면") {
            test("DefaultSplitter 를 생성한다.") {
                // given
                val expression = Expression.from("1,2,3")
                // when
                val actual = ExpressionSlitterFactory.create(expression = expression)
                // then
                actual.shouldBeInstanceOf<DefaultSplitter>()
            }
        }
    }
})

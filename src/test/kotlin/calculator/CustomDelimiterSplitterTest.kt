package calculator
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class CustomDelimiterSplitterTest : FunSpec({
    context("문자열 분리") {
        context("커스텀 구분자를 포함한 문자열을 전달하면") {
            test("커스텀 구분자를 기준으로 문자열을 분리할 수 있다.") {
                // given
                val expression = Expression.from("//;\n1;2;3")
                val sut = CustomDelimiterSplitter()
                // when
                val actual = sut.split(expression = expression)
                // then
                actual shouldContainExactly listOf("1", "2", "3")
            }
        }

        context("커스텀 구분자를 포함하지 않는 문자을 전달하면") {
            test("예외가 발생한다.") {
                // given
                val expression = Expression.from("1,2,3")
                val sut = CustomDelimiterSplitter()
                // when
                val exception = shouldThrow<IllegalArgumentException> { sut.split(expression = expression) }
                // then
                exception.message shouldBe "커스텀 구분자를 포함하고 있지 않습니다."
            }
        }
    }
})

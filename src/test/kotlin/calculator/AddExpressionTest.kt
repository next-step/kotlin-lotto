package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class AddExpressionTest {
    @Test
    fun `AddExpression은 생성 시 입력한 text를 Int List로 파싱한다`() {
        val addExpression = AddExpression("1,2,3")
        addExpression.numbers shouldBe Numbers(listOf(1, 2, 3))
    }

    @Test
    fun `잘못된 포맷의 text가 입력될 시 에러가 발생한다`() {
        shouldThrow<Exception> { AddExpression("error") }
    }
}
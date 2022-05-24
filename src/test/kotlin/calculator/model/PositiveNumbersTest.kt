package calculator.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("양수 컬렉션 테스트")
class PositiveNumbersTest {

    @Test
    fun `양수의 합을 정상적으로 계산`() {
        // given
        val numbers = PositiveNumbers.from(listOf("1", "2", "3"))

        // when, then
        assertEquals(numbers.sum(), 6)
    }
}

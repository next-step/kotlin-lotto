package util

import io.kotest.matchers.throwable.shouldHaveMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("List 유효성 공통 함수 기능 테스트")
internal class ListUtilsTest {

    @Test
    fun `숫자가 자연수인지 유효성 검사`() {
        val items = mutableListOf(1, 2, 3)

        assertThat(
            items.requireOrThrow { it > 0 }
        ).hasSize(items.size)
    }

    @Test
    fun `숫자가 자연수인지 검사 에러`() {
        val exceptionMessage = "자연수가 아닌 항목이 포함되어 있습니다"
        val items = mutableListOf(1, 2, -3)

        assertThrows<RuntimeException> {
            items.requireOrThrow(exceptionMessage) { it > 0 }
        }.shouldHaveMessage(exceptionMessage)
    }

    @Test
    fun `문자열 길이 유효성 검사`() {
        val items = mutableListOf("AB", "ZA", "ABC")

        assertThat(
            items.requireOrThrow { it.length >= 2 }
        ).hasSize(items.size)
    }

    @Test
    fun `문자열 길이 유효성 검사 에러`() {
        val exceptionMessage = "문자열의 길이가 2 미만일 수 없습니다"
        val items = mutableListOf("AB", "A", "ABC")

        assertThrows<RuntimeException> {
            items.requireOrThrow(exceptionMessage) { it.length >= 2 }
        }.shouldHaveMessage(exceptionMessage)
    }
}

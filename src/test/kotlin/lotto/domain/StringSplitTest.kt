package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringSplitTest {

    @Test
    fun `문자열에서 공백을 제거하고 쉼표기준으로 글자를 나눠서 숫자콜랙션을 반환한다`() {
        // Given
        val givenString = "1, 2, 3, 4, 5, 6"

        // When
        val actual = StringSplit.makeNumbersBySplit(givenString)

        // Then
        assertThat(actual).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }
}

package calculator.adder.value

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PositiveNumberTest {
    @Test
    fun `null은 양수가 아니다`() {
        // given

        // when

        // then
        assertThrows<IllegalArgumentException> { PositiveNumber(null) }
            .run { assertThat(this).hasMessageContaining("null 은 계산할 수 없습니다.") }
    }

    @Test
    fun `음수는 양수가 아니다`() {
        // given

        // when

        // then
        assertThrows<IllegalArgumentException> { PositiveNumber("-1") }
            .run { assertThat(this).hasMessageContaining("음수(-1)는 계산할 수 없습니다.") }
    }
}

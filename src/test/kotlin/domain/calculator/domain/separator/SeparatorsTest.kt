package domain.calculator.domain.separator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class SeparatorsTest {

    @Test
    fun `빈 컬렉션이 들어오면 예외를 발생한다`() {
        assertThatThrownBy { Separators.of(setOf()) }
            .isExactlyInstanceOf(RuntimeException::class.java)
            .hasMessage("Separators, 비어있는 컬렉션은 입력될 수 없습니다.")
    }
}

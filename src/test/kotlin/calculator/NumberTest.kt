package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class NumberTest {
    @Test
    fun `입력 값이 빈스트링인 경우 0을 갖는 Number을 반환`() {
        assertThat(Number("").positive).isEqualTo(0)
    }

    @Test
    fun `문자가 포함된 Input 값 RuntimeException 발생`() {
        assertThrows<RuntimeException> { Number("a") }
    }

    @Test
    fun `음수가 포함된 Input 값 RuntimeException 빌셍`() {
        assertThrows<RuntimeException> { Number("-1") }
    }
}

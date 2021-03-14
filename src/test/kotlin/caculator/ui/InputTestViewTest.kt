package caculator.ui

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource

internal class InputTestViewTest {
    @ParameterizedTest
    @NullSource
    fun `null 입력시 공백 반환`(input: String?) {
        assertThat(
            InputView(object : InputStrategy {
                override fun enter(): String? {
                    return input
                }
            }).value
        ).isEqualTo("")
    }
}

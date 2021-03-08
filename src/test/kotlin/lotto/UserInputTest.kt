package lotto

import org.junit.jupiter.api.Test

class UserInputTest {
    @Test
    fun `숫자를 입력받는다`() {
        assertThat(UserInput.Int("질문", "14000\n").answer()).isEqualTo(14_000)
    }
}

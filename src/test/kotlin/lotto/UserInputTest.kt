package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserInputTest {
    @Test
    fun `숫자를 입력받는다`() {
        assertThat(UserInput.Int("질문", "14000\n").answer()).isEqualTo(14_000)
    }

    @Test
    fun `쉼표로 구분된 숫자목록을 입력받는다`() {
        assertThat(UserInput.IntList("질문", "1,2,3,4\n").answer()).isEqualTo(listOf(1, 2, 3, 4))
    }
}

package lotto.view

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

    @Test
    fun `쉼표로 구분된 숫자목록의 그룹을 입력받는다`() {
        assertThat(UserInput.IntListGroup("질문", 3, "1,2,3,4\n5,6,7,8\n9,10,11,12").answer()).isEqualTo(
            listOf(
                listOf(1, 2, 3, 4),
                listOf(5, 6, 7, 8),
                listOf(9, 10, 11, 12)
            )
        )
    }
}

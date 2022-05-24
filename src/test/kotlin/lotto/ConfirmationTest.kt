package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConfirmationTest {

    @Test
    fun `로또 확인을 위해 지난 주 당첨 번호, Lotto 정보를 전달 받는다`() {
        Confirmation("1, 2, 3, 4, 5, 6", Lotto(listOf()))
    }

    @Test
    fun `당첨된 숫자의 갯수를 확인한다`() {
        assertThat(
            Confirmation("1, 2, 3, 4, 5, 6", Lotto(listOf(1, 2, 3, 10, 11, 12))).winningCount
        ).isEqualTo(3)
    }
}

package lotto.view

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputViewKtTest {

    @Test
    fun getNumber() {
        assertThat(getNumber("1")).isEqualTo(1)
    }

    @Test
    fun `로또 번호는 6개이다`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { validateSix(listOf(1, 2, 3, 4)) }
            .withMessage("로또 번호는 여섯개입니다.")
    }
}

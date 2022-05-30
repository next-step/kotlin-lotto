package lotto

import lotto.ui.InputUI
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputUITest {

    @Test
    fun `사용자의 금액을 입력하면, 금액을 리턴한다`() {
        System.setIn("14000".byteInputStream())
        assertThat(InputUI.receivePurchaseAmount()).isEqualTo(14000)
    }

    @Test
    fun `사용자가 금액이 아닌 값을 입력하면, NumberFormatException 예외가 발생한다`() {
        assertThrows<NumberFormatException> {
            System.setIn("money".byteInputStream())
            assertThat(InputUI.receivePurchaseAmount()).isEqualTo(14000)
        }
    }
}

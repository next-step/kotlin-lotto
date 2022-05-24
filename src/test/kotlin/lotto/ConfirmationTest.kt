package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ConfirmationTest {

    @Test
    fun `로또 확인을 위해 지난 주 당첨 번호를 입력받는다`() {
        Confirmation("1, 2, 3, 4, 5, 6")
    }
}

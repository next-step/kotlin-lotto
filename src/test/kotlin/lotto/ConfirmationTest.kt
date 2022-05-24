package lotto

import org.junit.jupiter.api.Test

internal class ConfirmationTest {

    @Test
    fun `로또 확인을 위해 지난 주 당첨 번호, Lotto 정보를 전달 받는다`() {
        Confirmation("1, 2, 3, 4, 5, 6", Lotto(listOf()))
    }
}

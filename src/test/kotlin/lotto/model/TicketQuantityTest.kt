package lotto.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class TicketQuantityTest {
    @Test
    fun `구입 금액 입력 값이 숫자가 아니면 예외가 발생한다`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            TicketQuantity("A")
        }
    }

    @Test
    fun `구입 금액이 최소 1000원 미만이면 예외가 발생한다`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            TicketQuantity("999")
        }
    }

    @Test
    fun `구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            TicketQuantity("1200")
        }
    }
}

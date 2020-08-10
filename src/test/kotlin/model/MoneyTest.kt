package model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class MoneyTest {
    @Test
    @DisplayName("구입금액을 입력 받는다")
    fun `inputMoney`() {
        val money = Money("1000")
        Assertions.assertThat(money).isNotNull
    }

    @Test
    @DisplayName("구입금액이 숫자가 아니면 exception 을 반환한다")
    fun `InvalidMoney`() {
        assertThrows<IllegalArgumentException> {
            Money("abcd")
        }
    }
}

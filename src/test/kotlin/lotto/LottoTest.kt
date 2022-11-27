package lotto

import lotto.model.LottoTicket
import lotto.model.Quantity
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class LottoTest {
    @Test
    fun `임의의 6개 숫자를 중복없이 생성한다`() {
        val testTicket = LottoTicket().make()
        assertEquals(LOTTO_NUMBER_SIZE, testTicket.toSet().size)
    }

    @Test
    fun `구입 금액 입력 값이 숫자가 아니면 예외가 발생한다`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            Quantity("A").quantity
        }
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
    }
}

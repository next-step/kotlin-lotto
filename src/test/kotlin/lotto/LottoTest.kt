package lotto

import lotto.model.LottoTicket
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LottoTest {
    @Test
    fun `임의의 6개 숫자를 중복없이 생성한다`() {
        val testTicket = LottoTicket().make()
        assertEquals(LOTTO_NUMBER_SIZE, testTicket.toSet().size)
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
    }
}

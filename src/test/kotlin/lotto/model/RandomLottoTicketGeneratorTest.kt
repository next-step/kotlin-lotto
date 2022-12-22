package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RandomLottoTicketGeneratorTest {
    @Test
    fun `임의의 6개 숫자를 중복없이 생성한다`() {
        val testTicket = RandomLottoTicketGenerator()
        assertEquals(LOTTO_NUMBER_SIZE, testTicket.lottoNumbers.toSet().size)
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
    }
}

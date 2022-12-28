package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class AutomaticLottoTicketGeneratorTest {
    @Test
    fun `정상적으로 자동 번호 로또가 발생하는 확인한다`() {
        assertDoesNotThrow {
            AutomaticLottoTicketGenerator().generate(1)
        }
    }

    @Test
    fun `수량만큼 자동 번호 로또를 발행한다`() {
        val testTicket = AutomaticLottoTicketGenerator().generate(2)
        testTicket.forEach {
            assertThat(it.values.size).isEqualTo(LOTTO_NUMBER_SIZE)
        }
        assertThat(testTicket.size).isEqualTo(2)
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
    }
}

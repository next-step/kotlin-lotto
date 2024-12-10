package lotto.domain

import io.kotest.matchers.booleans.shouldBeTrue
import lotto.controller.GeneratorRandomNumbers
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    fun `로또 티켓을 한장 생성한다`() {
        val ticket = LottoTicket(1, 2, 3, 4, 5, 6)
        ticket.equals(listOf(1, 2, 3, 4, 5, 6)).shouldBeTrue()
    }

    @Test
    fun `랜덤하게 로또 번호를 한개 생성한다`() {
        val ticket = GeneratorRandomNumbers.generateLottoTicker()
        println(ticket)
    }
}

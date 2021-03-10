package lotto.domain

import org.junit.jupiter.api.Test
import kotlin.random.Random

class LottoTicketTest {

    @Test
    fun `로또 1개 자동으로 만들기`() {
        val lotto = LottoTicket.generateAuto()
        lotto.value.forEach {
            print("${it.value} ")
        }
    }

    @Test
    fun `로또 1개 수동으로 만들기`() {
        val lotto = LottoTicket.generateManual(listOf(1, 2, 3, 4, 5, 6))
        lotto.value.forEach {
            print("${it.value} ")
        }
    }
}

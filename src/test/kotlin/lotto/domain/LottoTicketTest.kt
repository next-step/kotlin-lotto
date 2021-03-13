package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketTest {

    private val lottoNumbers = (1..45).map { number -> LottoNumber.from(number) }

    @Test
    fun `로또 1개 자동으로 만들기`() {
        val lotto = LottoTicket.generateAuto()
        assertThat(lottoNumbers).containsAll(lotto.value)
    }

    @Test
    fun `로또 1개 수동으로 만들기`() {
        val lotto = LottoTicket.generateManual(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto).isEqualTo(
            listOf(
                LottoNumber.from(1), LottoNumber.from(2),
                LottoNumber.from(3), LottoNumber.from(4),
                LottoNumber.from(5), LottoNumber.from(6)
            )
        )
    }
}

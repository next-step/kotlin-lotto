package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoTicketTest {

    @Test
    internal fun `로또티켓은 6개의 숫자로 이루어져 있다`() {
        val lottoTicket = LottoTicket.new()
        assertThat(lottoTicket.get().size).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    internal fun `로또 티켓의 숫자가 6개가 아닌 경우 IllegalArgumentException 에러 발생`(lottoNumCount: Int) {
        assertThrows<IllegalArgumentException> { makeRandomLottoTicket(lottoNumCount) }
    }

    @Test
    internal fun `로또 티켓을 get 함수로 가져오면 작은 수부터 순서대로 있다`() {
        val lottoTicket = LottoTicket.new()
        assertAll(
            {
                var before = 0
                lottoTicket.get().forEach {
                    assertTrue(it.get() > before)
                    before = it.get()
                }
            }
        )
    }

    private fun makeRandomLottoTicket(lottoNumCount: Int) =
        LottoTicket(List(lottoNumCount) { LottoNumber.random() }.toSet())
}

package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LastWinningLottoTest {

    private val lastLottoTicket = listOf(1, 2, 3, 4, 5, 6)
        .map(LottoNumber::of)
        .let(LottoTicket::of)

    private val bonusNumber = LottoNumber.of(10)

    @Test
    fun `지난주 당첨로또를 생성한다`() {
        LastWinningLotto(lastLottoTicket, bonusNumber)
    }

    @Test
    fun ` 2등 보너스 번호에 지난당첨 번호가 있으면 익셉션을 발생시킨다`() {
        assertThrows<IllegalArgumentException> { LastWinningLotto(lastLottoTicket, lastLottoTicket.numbers.first()) }
    }
}

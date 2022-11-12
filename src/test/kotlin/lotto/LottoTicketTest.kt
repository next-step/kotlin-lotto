package lotto

import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class LottoTicketTest : StringSpec({
    "LottoTicket의 LottoNumber의 개수가 6개가 아니면 IllegalArgumentException이 발생한다." {
        assertAll(
            { assertThrows<IllegalArgumentException> { LottoTicket(setOf()) } },
            { assertThrows<IllegalArgumentException> { LottoTicket.of(setOf(1, 2, 3, 4, 5, 6, 7)) } }
        )
    }

    "WinnerTicket.countMatchNumbers(LottoTicket)는 당첨번호와 몇 개가 일치하는지 반환한다." {
        //given
        val winnerTicket = WinnerTicket.of(setOf(1, 2, 3, 4, 5, 6))
        val lottoTicket = LottoTicket.of(setOf(1, 2, 3, 4, 5, 6))

        //when
        val matchCount = winnerTicket.countMatchNumbers(lottoTicket)

        //then
        assertThat(matchCount).isEqualTo(6)
    }
})
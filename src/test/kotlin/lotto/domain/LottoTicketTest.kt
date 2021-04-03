package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

internal class LottoTicketTest {
    @DisplayName("1 이상 45 이하의 숫자를 가진 로또 티켓 생성")
    @Test
    fun create() {
        val ticket = LottoTicket.create(ONE_TO_SIX)
        assertAll(
            { assertThat(ticket.numbers.size).isEqualTo(6) },
            { assertThat(ticket.numbers.all { it.number in 1..45 }).isTrue }
        )
    }

    @DisplayName("로또 번호 리스트를 받아 일치하는 결과 수 반환")
    @Test
    fun getMatchCount() {
        val numbers = createLotto(1, 2, 3, 43, 44, 45)
        val bonusNumber = LottoNumber(7)
        val ticket = LottoTicket.create(ONE_TO_SIX)

        assertAll(
            { assertThat(ticket.getMatchInfo(numbers, bonusNumber).matchCount).isEqualTo(3) },
            { assertThat(ticket.getMatchInfo(numbers, bonusNumber).hasBonus).isEqualTo(false) }
        )
    }

    @DisplayName("로또 티켓을 생성할 때 로또 숫자의 개수가 맞지 않을 경우 예외 발생")
    @Test
    fun validateSize() {
        assertThrows<IllegalArgumentException> {
            LottoTicket(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                    LottoNumber(7),
                )
            )
        }
    }
}

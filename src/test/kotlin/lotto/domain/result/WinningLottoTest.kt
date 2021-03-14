package lotto.domain.result

import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.createLotto
import lotto.domain.createLottoResult
import lotto.domain.strategy.OneToSixStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class WinningLottoTest {
    @DisplayName("6개의 숫자를 입력한 경우 당첨 로또 반환")
    @Test
    fun of() {
        val actual = WinningLotto.of("1, 2, 3, 4, 5, 6")

        assertThat(actual.numbers.containsAll(createLotto(1, 2, 3, 4, 5, 6))).isTrue
    }

    @DisplayName("로또 티켓들을 인자로 넣은 경우 LottoResult 반환")
    @Test
    fun match() {
        val tickets = listOf(LottoTicket.create(OneToSixStrategy()), LottoTicket.create(OneToSixStrategy()))
        val expected = createLottoResult()
        expected[LottoRank.FIRST] = 2

        val actual = WinningLotto.of("1, 2, 3, 4, 5, 6").match(LottoTickets(tickets))

        assertThat(actual.result).isEqualTo(expected)
    }
}

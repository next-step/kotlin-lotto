package lotto.domain.lotto

import lotto.domain.rank.Rank
import lotto.fixture.bonusNumber
import lotto.fixture.lotto
import lotto.fixture.winningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.lang.IllegalArgumentException

class LottoTicketTest {
    @Test
    fun `LottoTicket은 6자리가 아니면 Exception이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lotto(1, 2, 3, 4, 5, 6, 7)
        }
    }

    @ParameterizedTest
    @MethodSource("lottoMatches")
    fun `LottoTicket은 당첨번호와 일치하는 로또 번호 개수를 알고 있다`(lotto: LottoTicket, winningLotto: WinningLotto, bonusNumber: BonusNumber, expectedRank: Rank) {
        // given
        // when
        val matchResult = lotto.match(winningLotto, bonusNumber)
        // then
        assertThat(matchResult).isEqualTo(expectedRank)
    }

    companion object {
        @JvmStatic
        fun lottoMatches() = listOf(
            Arguments.of(lotto(1, 2, 3, 4, 5, 6), winningLotto(1, 2, 3, 4, 5, 6), bonusNumber(26), Rank.FIRST),
            Arguments.of(lotto(1, 2, 3, 4, 5, 26), winningLotto(1, 2, 3, 4, 5, 6), bonusNumber(26), Rank.SECOND),
            Arguments.of(lotto(1, 2, 3, 4, 5, 36), winningLotto(1, 2, 3, 4, 5, 6), bonusNumber(26), Rank.THIRD),
            Arguments.of(lotto(1, 2, 3, 4, 35, 36), winningLotto(1, 2, 3, 4, 5, 6), bonusNumber(26), Rank.FOURTH),
            Arguments.of(lotto(1, 2, 3, 34, 35, 36), winningLotto(1, 2, 3, 4, 5, 6), bonusNumber(26), Rank.FIFTH),
            Arguments.of(lotto(1, 2, 33, 34, 35, 36), winningLotto(1, 2, 3, 4, 5, 6), bonusNumber(26), Rank.MISS),
            Arguments.of(lotto(1, 32, 33, 34, 35, 36), winningLotto(1, 2, 3, 4, 5, 6), bonusNumber(26), Rank.MISS),
            Arguments.of(lotto(31, 32, 33, 34, 35, 36), winningLotto(1, 2, 3, 4, 5, 6), bonusNumber(26), Rank.MISS),
        )
    }
}

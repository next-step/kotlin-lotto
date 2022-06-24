package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LastWinningLottoTest {

    private val lastLottoTicket = listOf(1, 2, 3, 4, 5, 6)
        .map(::LottoNumber)
        .let(LottoTicket::of)

    private val bonusNumber = LottoNumber(10)

    @Test
    fun `지난주 당첨로또를 생성한다`() {
        assertDoesNotThrow { LastWinningLotto(lastLottoTicket, bonusNumber) }
    }

    @Test
    fun ` 2등 보너스 번호에 지난당첨 번호가 있으면 익셉션을 발생시킨다`() {
        assertThrows<IllegalArgumentException> { LastWinningLotto(lastLottoTicket, lastLottoTicket.numbers.first()) }
    }

    @ParameterizedTest
    @MethodSource("lottoAndExpectMatchingCount")
    fun `매칭되는 숫자를 반환한다`(target: LottoTicket, expected: Int) {
        val lastWinningLotto = LastWinningLotto(lastLottoTicket, bonusNumber)
        val matchCount = lastWinningLotto.matchCount(target)

        assertThat(matchCount).isEqualTo(expected)
    }

    @Test
    fun `보너스 숫자가 있는지 확인한다`() {
        val lastWinningLotto = LastWinningLotto(lastLottoTicket, bonusNumber)
        val ticketHasBonus = listOf(1, 2, 3, 4, 5, 10).map(::LottoNumber).let(LottoTicket::of)

        assertThat(lastWinningLotto.hasBonusNumber(ticketHasBonus)).isTrue
    }

    companion object {
        @JvmStatic
        fun lottoAndExpectMatchingCount(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber).let(LottoTicket::of), 6),
                Arguments.of(listOf(1, 2, 3, 4, 5, 45).map(::LottoNumber).let(LottoTicket::of), 5),
                Arguments.of(listOf(1, 2, 3, 4, 44, 45).map(::LottoNumber).let(LottoTicket::of), 4),
                Arguments.of(listOf(1, 2, 3, 43, 44, 45).map(::LottoNumber).let(LottoTicket::of), 3),
                Arguments.of(listOf(1, 2, 42, 43, 44, 45).map(::LottoNumber).let(LottoTicket::of), 2),
                Arguments.of(listOf(1, 41, 42, 43, 44, 45).map(::LottoNumber).let(LottoTicket::of), 1),
                Arguments.of(listOf(40, 41, 42, 43, 44, 45).map(::LottoNumber).let(LottoTicket::of), 0),
            )
        }
    }
}

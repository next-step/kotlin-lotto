package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class PositiveNumberTest {
    @ParameterizedTest(name = "`{0}`은 PositiveNumber로 변환 가능")
    @ValueSource(ints = [0, 1, 2, 100])
    internal fun `0이상인 값은 PositiveNumber로 변환 가능하다`(number: Int) {
        val actual = PositiveNumber(number)
        assertThat(actual.toInt()).isEqualTo(number)
    }

    @ParameterizedTest(name = "`{0}`을 PositiveNumber로 변환하면 IllegalArgumentException 발생")
    @ValueSource(ints = [-1, -2, -100])
    internal fun `음수를 PositiveNumber로 변환하면 IllegalArgumentException 예외 처리를 한다`(number: Int) {
        assertThrows<IllegalArgumentException> { PositiveNumber(number) }
    }

    @Test
    internal fun `Int처럼 두 수의 비교가 가능하다`() {
        val actual = PositiveNumber(3) < PositiveNumber(5)
        assertThat(actual).isTrue
    }

    @Test
    internal fun `Int처럼 두 수의 minus 계산이 가능하다`() {
        val actual = PositiveNumber(5) - PositiveNumber(3)
        assertThat(actual).isEqualTo(PositiveNumber(2))
    }

    @Test
    internal fun `action을 positiveNumber만큼 반복하여 수행한 뒤 리스트로 반환한다`() {
        val lottoTickets = PositiveNumber(3).times {
            LottoTicket.new()
        }

        assertThat(lottoTickets).hasSize(3)
        assertThat(lottoTickets.first()).isInstanceOf(LottoTicket::class.java)
    }
}

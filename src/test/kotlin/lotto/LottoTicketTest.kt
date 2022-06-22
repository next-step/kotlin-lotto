package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoTicketTest {

    @Test
    fun `로또번호 매칭된 갯수를 확인한다`() {
        val lottoTicket = listOf(1, 2, 3, 4, 5, 6)
            .map(::LottoNumber)
            .let(LottoTicket::of)

        val otherTicket = listOf(4, 5, 6, 7, 8, 9)
            .map(::LottoNumber)
            .let(LottoTicket::of)

        val matchCount = lottoTicket.matchCountWith(otherTicket)
        val expectedCount = 3

        Assertions.assertThat(matchCount).isEqualTo(expectedCount)
    }

    @ParameterizedTest
    @CsvSource("10, true", "45, false")
    fun `로또 티켓에 번호가포함돼 있는지 확인한다`(number: Int, contains: Boolean) {
        val ticket = listOf(1, 2, 3, 4, 5, 10)
            .map(::LottoNumber)
            .let(LottoTicket::of)

        Assertions.assertThat(LottoNumber(number) in ticket).isEqualTo(contains)
    }

    @ParameterizedTest
    @MethodSource("invalidSizeLottoNumbers")
    fun `로또 티켓의 번호 갯수가 6개인지 검증한다`(numbers: List<LottoNumber>) {
        assertThrows<IllegalArgumentException> { LottoTicket.of(numbers) }
    }

    @ParameterizedTest
    @MethodSource("duplicatedLottoNumbers")
    fun `로또에 중복된 번호가 있는지 확인한다`(numbers: List<LottoNumber>) {
        assertThrows<IllegalArgumentException> { LottoTicket.of(numbers) }
    }

    companion object {
        @JvmStatic
        fun invalidSizeLottoNumbers(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5).map(::LottoNumber)), // less than 6
                Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7).map(::LottoNumber)), // more than 6
            )
        }

        @JvmStatic
        fun duplicatedLottoNumbers(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 5).map(::LottoNumber)), // 5 numbers
                Arguments.of(listOf(1, 1, 1, 1, 1, 1).map(::LottoNumber)), // 1 numbers
            )
        }
    }
}

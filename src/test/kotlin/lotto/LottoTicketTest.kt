package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoTicketTest {

    @Test
    fun `로또번호 매칭된 갯수를 확인한다`() {
        val lottoTicket = LottoTicket.of(
            listOf(
                LottoNumber.of(1),
                LottoNumber.of(1),
                LottoNumber.of(1),
                LottoNumber.of(1),
                LottoNumber.of(1),
                LottoNumber.of(1)
            )
        )
        val otherTicket = LottoTicket.of(
            listOf(
                LottoNumber.of(1),
                LottoNumber.of(1),
                LottoNumber.of(1),
                LottoNumber.of(1),
                LottoNumber.of(1),
                LottoNumber.of(1)
            )
        )

        val matchCount = lottoTicket.matchCountWith(otherTicket)
        val expectedCount = 3

        Assertions.assertThat(matchCount).isEqualTo(expectedCount)
    }

    @ParameterizedTest
    @MethodSource("invalidRangeLottoNumbers")
    fun `로또 티켓의 번호가 1이상 45이하 숫자인지 검증한다`(numbers: Set<LottoNumber>) {
        assertThrows<IllegalArgumentException> { LottoTicket.of(numbers) }
    }

    @ParameterizedTest
    @MethodSource("invalidSizeLottoNumbers")
    fun `로또 티켓의 번호 갯수가 6개인지 검증한다`(numbers: Set<LottoNumber>) {
        assertThrows<IllegalArgumentException> { LottoTicket.of(numbers) }
    }

    @ParameterizedTest
    @MethodSource("duplicatedLottoNumbers")
    fun `로또에 중복된 번호가 있는지 확인한다`(numbers: Set<LottoNumber>) {
        assertThrows<IllegalArgumentException> { LottoTicket.of(numbers) }
    }

    companion object {
        @JvmStatic
        fun invalidRangeLottoNumbers(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 46)), // over 45
                Arguments.of(listOf(0, 2, 3, 4, 5, 40)), // zero
                Arguments.of(listOf(-1, 2, 3, 4, 5, 6)) // negative
            )
        }

        @JvmStatic
        fun invalidSizeLottoNumbers(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5)), // less than 6
                Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7)), // more than 6
            )
        }

        @JvmStatic
        fun duplicatedLottoNumbers(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 5)), // 5 numbers
                Arguments.of(listOf(1, 1, 1, 1, 1, 1)), // 1 numbers
            )
        }
    }
}

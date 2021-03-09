package lotto.domain.ticket

import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class WinningLottoTicketTest {
    companion object {
        @JvmStatic
        fun lottoTicketProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(aTicket(1, 2, 3, 4, 5, 6), WinningBoard.SIX),
                Arguments.of(aTicket(1, 2, 3, 4, 5, 45), WinningBoard.FIVE),
                Arguments.of(aTicket(1, 2, 3, 4, 44, 45), WinningBoard.FOUR),
                Arguments.of(aTicket(1, 2, 3, 42, 43, 45), WinningBoard.THREE),
                Arguments.of(aTicket(1, 2, 42, 43, 44, 45), WinningBoard.NONE),
                Arguments.of(aTicket(40, 41, 42, 43, 44, 45), WinningBoard.NONE)
            )
        }

        private fun aTicket(vararg numbers: Int): Set<LottoNumber> {
            return numbers.map { LottoNumber.of(it) }.toSet()
        }
    }

    @ParameterizedTest
    @MethodSource("lottoTicketProvider")
    fun `일치한 갯수에 해당하는 당첨 정책을 가져온다`(lottoNumbers: Set<LottoNumber>, expect: WinningBoard) {
        //given
        val winningLottoTicket = WinningLottoTicket(listOf(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(6)
        ))

        val lottoTicket = LottoTicket(lottoNumbers)

        //when
        val winningBoard = winningLottoTicket.compare(lottoTicket)

        //then
        assertThat(winningBoard).isEqualTo(expect)
    }
}

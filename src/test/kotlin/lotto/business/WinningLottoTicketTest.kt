package lotto.business

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningLottoTicketTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,5", "1,2,3,3,5,7", "1,2,3,4,5"])
    fun `당첨 번호가 중복이면 예외 발생한다`(numbers: String) {
        // given
        val lottoNumbers = numbers.split(",").map { LottoNumber(it.toInt()) }.toSet()
        val bonusNumber = LottoNumber(7)

        // when, then
        Assertions.assertThatThrownBy { WinningLottoTicket(LottoTicket(lottoNumbers), bonusNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("서로 다른 6개 로또 번호 이여야 합니다.")
    }

    @Test
    fun `당첨 결과를 계산한다`() {
        // given
        val lottoNumbers = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
        val bonusNumber = LottoNumber(7)
        val winningLottoTicket = WinningLottoTicket(LottoTicket(lottoNumbers), bonusNumber)
        val lottoTickets = listOf(
            LottoTicket(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
            ),
            LottoTicket(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(7)
                )
            ),
            LottoTicket(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(8),
                    LottoNumber(9)
                )
            )
        )

        // when
        val prizeResults = winningLottoTicket.compilePrizeResults(lottoTickets)

        // then
        Assertions.assertThat(prizeResults.prizeCountMap).isEqualTo(
            mapOf(
                LotteryPrize.FIRST to 1,
                LotteryPrize.SECOND to 1,
                LotteryPrize.THIRD to 0,
                LotteryPrize.FOURTH to 1,
                LotteryPrize.FIFTH to 0,
                LotteryPrize.MISS to 0
            )
        )
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복이면 예외 발생한다`() {
        // given
        val lottoNumbers = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
        val bonusNumber = LottoNumber(6)

        // when, then
        Assertions.assertThatThrownBy { WinningLottoTicket(LottoTicket(lottoNumbers), bonusNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.")
    }
}

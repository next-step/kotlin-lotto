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

        // when, then
        Assertions.assertThatThrownBy { WinningLottoTicket(lottoNumbers) }
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
        val winningLottoTicket = WinningLottoTicket(lottoNumbers)
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
                LotteryPrize.SIX_MATCH to 1,
                LotteryPrize.FIVE_MATCH to 1,
                LotteryPrize.FOUR_MATCH to 1,
                LotteryPrize.THREE_MATCH to 0,
                LotteryPrize.NONE to 0
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
        val winningLottoTicket = WinningLottoTicket(lottoNumbers)
        val bonusNumber = LottoNumber(6)

        // when, then
        Assertions.assertThatThrownBy { winningLottoTicket.validateBonusNumber(bonusNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.")
    }
}

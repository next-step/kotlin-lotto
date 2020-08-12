package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class LuckyLottoNumbersTest {

    @Test
    fun `보너스번호가 당첨번호에 중복되면 Exception`() {
        // given
        val luckyTicket = LottoTicket(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber.of(1)

        // then
        assertThatThrownBy { LuckyLottoNumbers(luckyTicket, bonusNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("보너스 번호 ($bonusNumber)는 당첨번호($luckyTicket)와 중복될 수 없습니다.")
    }

    @Test
    fun `행운 번호와 티켓들을 비교해서 결과가 제대로 나오는지 확인`() {
        // given
        val luckyLottoNumbers = LuckyLottoNumbers(
            luckyNumbers = *intArrayOf(1, 2, 3, 4, 5, 6),
            bonusNumber = 7
        )
        val lottoTickets = LottoTickets(
            listOf(
                LottoTicket(1, 2, 3, 4, 5, 6),
                LottoTicket(1, 2, 3, 4, 5, 6),
                LottoTicket(1, 2, 3, 4, 5, 6),
                LottoTicket(1, 2, 3, 4, 5, 6)
            )
        )

        // when
        val lottoResults = luckyLottoNumbers.getLottoResultsWith(lottoTickets)

        // then
        assertAll(
            { assertThat(lottoResults.countOf(LottoResult.FIRST)).isEqualTo(4) },
            {
                assertThat(lottoResults.getTotalPrize())
                    .isEqualTo(LottoMoney(LottoResult.FIRST.prize * 4))
            }
        )
    }
}

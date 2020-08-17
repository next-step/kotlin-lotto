package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoTicketTest {

    @Test
    fun `로또 1장은 1000원이다`() {
        val price = LottoTicket.PRICE
        assertThat(price).isEqualTo(1000)
    }

    @Test
    fun `로또 1장은 로또 번호 6개로 이루어져 있다`() {
        val numbers = LottoTicket().getLottoNumbers()
        assertThat(numbers.size).isEqualTo(6)
    }

    @Test
    fun `로또 티켓과 당첨번호가 주어질 때 일치 갯수를 알 수 있다`() {
        val lottoNumbers = setOf(1, 2, 3, 4, 5, 6).map { LottoNumber.get(it) }.toSet()
        val winningNumbers = setOf(1, 2, 3, 4, 5, 7).map { LottoNumber.get(it) }.toSet()
        val matchCount = LottoTicket(lottoNumbers).matchCount(winningNumbers)

        assertThat(matchCount).isEqualTo(5)
    }

    @ParameterizedTest
    @MethodSource("generateMatchingTestData")
    fun `구입한 로또 번호와 당첨 번호, 보너스 번호가 주어지면 매칭 결과를 알려준다`(
        lottoTicket: LottoTicket,
        winningNumbers: Set<LottoNumber>,
        bonusNumber: LottoNumber,
        PrizeResult: PrizeResult
    ) {
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        val matched = lottoTicket.match(winningLotto)

        assertThat(matched).isEqualTo(PrizeResult)
    }

    companion object {
        @JvmStatic
        fun generateMatchingTestData(): List<Arguments> {
            return listOf(
                Arguments.of(
                    LottoTicket(setOf(1, 2, 3, 4, 5, 6).map { LottoNumber.get(it) }.toSet()),
                    setOf(1, 2, 3, 8, 9, 10).map { LottoNumber.get(it) }.toSet(),
                    LottoNumber.get(44),
                    PrizeResult.THREE_MATCH
                ),
                Arguments.of(
                    LottoTicket(setOf(1, 2, 3, 4, 5, 6).map { LottoNumber.get(it) }.toSet()),
                    setOf(1, 2, 3, 4, 5, 7).map { LottoNumber.get(it) }.toSet(),
                    LottoNumber.get(6),
                    PrizeResult.BONUS_MATCH
                )
            )
        }
    }
}

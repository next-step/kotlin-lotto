package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketTest {

    private val lottoNumbers = (1..45).map { number -> LottoNumber.from(number) }
    private val lottoGames = LottoGame(Money(3000))

    @Test
    fun `자동으로 로또 생성 시 모두 범위 내 숫자인지 확인`() {
        val lottoes = lottoGames.purchaseAutoLottoes().toList()

        for (lotto in lottoes) {
            assertThat(lottoNumbers).containsAll(lotto.value)
        }
    }

    @Test
    fun `로또 1개 수동으로 만들기`() {
        val lotto = LottoTicket.generateManual(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.value).containsExactly(
            LottoNumber.from(1), LottoNumber.from(2),
            LottoNumber.from(3), LottoNumber.from(4),
            LottoNumber.from(5), LottoNumber.from(6)
        )
    }
}

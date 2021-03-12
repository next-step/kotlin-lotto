package lotto.data

import lotto.enums.LotteryMatchType
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoNumbersTest {

    @Test
    fun `LottoNumber가 다른 LottoNumber와 몇 개 매칭되는지 확인한다`() {
        val lottoNumbers1 = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lottoNumbers2 = WinningNumbers(listOf(3, 4, 5, 6, 7, 8), 45)
        val lottoNumbers3 = WinningNumbers(listOf(6, 7, 8, 9, 10, 11), 45)
        val lottoNumbers4 = WinningNumbers(listOf(2, 3, 4, 5, 6, 7), 1)

        assertThat(lottoNumbers1.findWinningType(lottoNumbers2)).isEqualTo(LotteryMatchType.Four)
        assertThat(lottoNumbers1.findWinningType(lottoNumbers3)).isEqualTo(LotteryMatchType.NonProfit)
        assertThat(lottoNumbers1.findWinningType(lottoNumbers4)).isEqualTo(LotteryMatchType.FiveWithBonus)
    }

    @Test
    fun `로또 번호의 개수인 6개보다 많이 가지고 있다`() {
        assertThatThrownBy { LottoNumbers(listOf(1, 2, 3, 4, 5, 6, 7)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `로또 번호의 개수인 6개보다 적게 가지고 있다`() {
        assertThatThrownBy { LottoNumbers(listOf(1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}

package lotto.data

import lotto.enums.LotteryMatchType
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoNumbersTest {

    @Test
    fun `LottoNumber가 다른 LottoNumber와 몇 개 매칭되는지 확인한다`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        val lottoNumbers2 = LottoNumbers(listOf(3, 4, 5, 6, 7, 8))
        val lottoNumbers3 = LottoNumbers(listOf(6, 7, 8, 9, 10, 11))
        val lottoNumbers4 = LottoNumbers(listOf(2, 3, 4, 5, 6, 7))

        assertThat(winningNumbers.findWinningType(lottoNumbers2)).isEqualTo(LotteryMatchType.Four)
        assertThat(winningNumbers.findWinningType(lottoNumbers3)).isEqualTo(LotteryMatchType.NonProfit)
        assertThat(winningNumbers.findWinningType(lottoNumbers4)).isEqualTo(LotteryMatchType.FiveWithBonus)
    }

    @Test
    fun `로또 번호의 개수인 6개보다 많이 가지고 있으면 안된다`() {
        assertThatThrownBy { LottoNumbers(listOf(1, 2, 3, 4, 5, 6, 7)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `로또 번호의 개수인 6개보다 적게 가지고 있으면 안된다`() {
        assertThatThrownBy { LottoNumbers(listOf(1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `로또 번호가 중복되는 숫자가 있으면 안된다`() {
        assertThatThrownBy { LottoNumbers(listOf(1, 2, 2, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `contain 메서드가 특정 로또번호를 가지고 있는지 여부를 리턴한다`() {
        val lottoNumbers = LottoNumbers(listOf(3, 4, 5, 6, 7, 8))
        assertThat(lottoNumbers.contains(LottoNumber.from(3))).isTrue()
        assertThat(lottoNumbers.contains(LottoNumber.from(4))).isTrue()
        assertThat(lottoNumbers.contains(LottoNumber.from(5))).isTrue()
        assertThat(lottoNumbers.contains(LottoNumber.from(6))).isTrue()
        assertThat(lottoNumbers.contains(LottoNumber.from(7))).isTrue()
        assertThat(lottoNumbers.contains(LottoNumber.from(8))).isTrue()
        assertThat(lottoNumbers.contains(LottoNumber.from(9))).isFalse()
    }
}

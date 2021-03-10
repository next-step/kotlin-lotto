package lotto.data

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoNumbersTest {

    @Test
    fun `LottoNumber가 다른 LottoNumber와 몇 개 매칭되는지 확인한다`() {
        val lottoNumbers1 = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lottoNumbers2 = LottoNumbers(listOf(3, 4, 5, 6, 7, 8))
        val lottoNumbers3 = LottoNumbers(listOf(6, 7, 8, 9, 10, 11))

        assertThat(lottoNumbers1.findMatchCount(lottoNumbers2)).isEqualTo(4)
        assertThat(lottoNumbers1.findMatchCount(lottoNumbers3)).isEqualTo(1)
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

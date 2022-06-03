package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    fun `로또 번호는 6개의 숫자로 구성되어 있다`() {
        assertThat(LottoNumber().numbers.size).isEqualTo(6)
    }

    @Test
    fun `로또 번호 생성기의 각 숫자는 1 이상 45 이하이다`() {
        assertThat(LottoNumber().numbers).allMatch { number -> number in 1..45 }
    }

    @Test
    fun `로또 번호는 정렬되어 있다`() {
        assertThat(LottoNumber(listOf(6, 5, 1, 3, 2, 4)).numbers).isEqualTo(setOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `보너스 볼을 추가할 수 있다`() {
        val lottoNumber = LottoNumber(listOf(6, 5, 1, 3, 2, 4))
        lottoNumber.contains(10)
        assertThat(lottoNumber.bonusNumber).isEqualTo(10)
    }

    @Test
    fun `로또 번호는 보너스 볼을 포함하는지 알 수 있다`() {
        val lottoNumber = LottoNumber(listOf(6, 5, 1, 3, 2, 4))
        lottoNumber.contains(15)
        assertThat(lottoNumber.hasBonusNumber(15)).isEqualTo(true)
    }
}

package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `1 ~ 45 숫자 중 랜덤으로 여섯개의 숫자 뽑기`() {
        val numbers: List<Int> = Lotto.getNumbers()
        assertThat(numbers.size).isEqualTo(COUNT_OF_NUMBERS)
    }

    @Test
    fun `뽑은 숫자가 중복이 없는지 확인`() {
        val numbers: List<Int> = Lotto.getNumbers()
        assertThat(numbers.toSet().size).isEqualTo(numbers.size)
    }

    @Test
    fun `로또 당첨여부 확인`() {
        val prizeNumbers = listOf(1, 7, 13, 24, 40, 41)
        val lottoNumbers = listOf(1, 7, 13, 14, 15, 16)
        assertThat(Lotto.checkResult(lottoNumbers, prizeNumbers)).isEqualTo(3)
    }
}

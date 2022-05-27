package lotto.numbers

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomNumbersGeneratorTest {
    @Test
    fun `총 6개의 랜덤 숫자로 구성되어 있다`() {
        val lottoNumbers = RandomNumbersGenerator.generate()
        assertThat(lottoNumbers).hasSize(6)
    }

    @Test
    fun `생성된 숫자는 1과 45 사이의 번호로 이루어져 있다`() {
        val lottoNumbers = RandomNumbersGenerator.generate()
        assertThat(lottoNumbers).allMatch { it in (1..45) }
    }
}

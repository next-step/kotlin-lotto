package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomLottoNumberGeneratorTest {
    @Test
    fun `6개의 숫자 목록을 생성한다`() {
        val numbers = RandomLottoNumberGenerator.generate()

        assertThat(numbers).hasSize(6)
    }
}

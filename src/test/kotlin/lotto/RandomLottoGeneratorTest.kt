package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RandomLottoGeneratorTest {

    @Test
    fun `로또를 생성할 수 있다`() {
        val randomLottoGenerator = RandomLottoGenerator()
        val result = randomLottoGenerator.generate()
        assertThat(result).isNotNull
    }
}

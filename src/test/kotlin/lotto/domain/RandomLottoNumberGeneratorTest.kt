package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomLottoNumberGeneratorTest {

    @Test
    fun generate() {
        val lottoNumber = RandomLottoNumberGenerator().generate()
        assertThat(lottoNumber.size).isEqualTo(6)
    }
}

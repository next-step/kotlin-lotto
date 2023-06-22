package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberGeneratorTest {

    @Test
    fun generate() {
        val lottoNumber = LottoNumberGenerator.generate()
        assertThat(lottoNumber.size).isEqualTo(6)
    }
}

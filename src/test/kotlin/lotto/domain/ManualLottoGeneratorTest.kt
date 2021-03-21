package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ManualLottoGeneratorTest {

    @Test
    fun `수동 로또를 생성한다`() {
        val lottoNumbers = (1..6).map(::LottoNumber)
        val generator = ManualLottoGenerator(lottoNumbers)
        val expected = Lotto(lottoNumbers)

        val result = generator.generate()

        assertThat(result).isEqualTo(expected)
    }
}

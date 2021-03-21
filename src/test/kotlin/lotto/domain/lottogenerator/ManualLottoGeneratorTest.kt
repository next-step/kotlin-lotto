package lotto.domain.lottogenerator

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ManualLottoGeneratorTest {

    @Test
    fun `lotto 생성 테스트`() {
        val elements = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(elements.map { LottoNumber.of(it) }.toSet())
        val generator = ManualLottoGenerator(elements)

        val generatedLotto = generator.generate()

        assertThat(generatedLotto).isEqualTo(lotto)
    }
}

package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoNumberGeneratorTest {
    @Test
    fun generateLottoNumbers() {
        val lottoCount = 6
        val possibleNumbers = (1..lottoCount).map { LottoNumber(it) }
        val numberGenerator: NumberGenerator = ManualNumberGenerator()
        val resultLotto = numberGenerator.generateLottoFromNumbers(possibleNumbers)

        assertThat(resultLotto.numbers.count()).isEqualTo(lottoCount)
        assertThat(resultLotto.numbers.toList()).isEqualTo(possibleNumbers)
    }
}

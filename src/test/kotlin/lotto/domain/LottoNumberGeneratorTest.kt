package lotto.domain

import lotto.generator.NumbersGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberGeneratorTest {
    @Test
    fun `로또 번호 생성기는 45개의 숫자열을 생성한다`() {
        assertThat(NumbersGenerator.create().size).isEqualTo(45)
    }

    @Test
    fun `로또 번호 생성기의 각 숫자는 1 이상 45 이하이다`() {
        assertThat(NumbersGenerator.create()).allMatch { number -> number in 1..45 }
    }
}

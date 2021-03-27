package lotto.domain.generator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AutoLottoGeneratorTest {
    @Test
    internal fun `자동 로또 생성`() {
        val lotto = AutoLottoGenerator().generate()
        assertThat(lotto.numbers.size).isEqualTo(6)
    }
}

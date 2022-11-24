package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    @Test
    fun `로또 생성기의 Range 는 1부터 45의 범위를 가진다`() {
        assertThat(LottoGenerator().range.first).isEqualTo(1)
        assertThat(LottoGenerator().range.last).isEqualTo(45)
    }
}

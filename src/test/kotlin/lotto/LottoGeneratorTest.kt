package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    @Test
    internal fun `번호 생성하기`() {
        val autoNumber = LottoGenerator.autoGenerate()
        assertThat(autoNumber.count()).isEqualTo(6)
    }
}



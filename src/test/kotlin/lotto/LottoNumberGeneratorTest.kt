package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberGeneratorTest {
    @Test
    fun `번호 생성하기`() {
        val autoNumber = LottoNumberGenerator.autoGenerate()
        assertThat(autoNumber.numbers.count()).isEqualTo(6)
    }
}



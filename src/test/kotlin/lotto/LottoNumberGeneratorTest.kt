package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoNumberGeneratorTest {

    @Test
    fun `로또 번호 생성기는 1~45 사이에 중복없는 번호 6개를 발급`() {
        val actual = LottoNumberGenerator.generate()
        val isInvalidRangeNumber = actual.any { it < 1 || it > 45 }

        actual.size shouldBe 6
        isInvalidRangeNumber shouldBe false
    }
}

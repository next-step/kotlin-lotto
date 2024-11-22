package lotto.domain

import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class RandomLottoLineGeneratorTest {
    @Test
    fun `6개의 숫자가 생성된다`() {
        val sut = RandomLottoLineGenerator()

        val line = sut.generate()

        line.numbers.size shouldBe 6
    }

    @Test
    fun `범위 내의 숫자들이 생성된다`() {
        val sut = RandomLottoLineGenerator()

        val line = sut.generate()

        line.numbers.shouldForAll { it.value in LottoNumber.MIN_VALUE..LottoNumber.MAX_VALUE }
    }
}

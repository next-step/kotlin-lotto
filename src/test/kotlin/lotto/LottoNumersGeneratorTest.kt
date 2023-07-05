package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoNumersGeneratorTest {
    @Test
    fun `랜덤 로또 번호를 생성한다`() {
        val generator = object : RandomGenerator() {
            override fun generate(): LottoNumbers {
                return LottoNumbers.from(listOf(1, 2, 3, 4, 5, 6))
            }
        }
        val lottoNumbers = generator.generate()

        lottoNumbers.numbers.map { it.number } shouldBe setOf(1, 2, 3, 4, 5, 6)
    }
}
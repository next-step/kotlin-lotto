package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    @Test
    fun `내가 원하는 로또번호를 만들 수 있다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val generator = object : LottoGenerator {
            override fun generate(): Lotto = Lotto(numbers = numbers)
        }

        // when
        val lotto = generator.generate()
        val result = lotto.numbers.count { it in numbers }

        // then
        assertThat(result).isEqualTo(6)
    }

}

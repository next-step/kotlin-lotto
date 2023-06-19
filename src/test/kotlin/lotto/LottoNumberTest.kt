package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    fun `발급된 로또 번호가 오름차순으로 정렬이 되어있어야한다`() {
        val numbers = listOf(10, 2, 31, 4, 5, 26)
        val lottoNumber = LottoNumber.from(numbers)
        lottoNumber.numbers shouldBe numbers.sorted()
    }

    @Test
    fun `6개가 아닌 숫자를 주면 IllegalArgumentException throw`() {
        val numbers = listOf(1, 2, 3, 4, 5)
        shouldThrow<IllegalArgumentException> {
            LottoNumber.from(numbers)
        }
    }

    @Test
    fun `1부터 45가 아닌 숫자를 주면 IllegalArgumentException throw`() {
        val numbers = listOf(1, 2, 3, 4, 5, 46)
        shouldThrow<IllegalArgumentException> {
            LottoNumber.from(numbers)
        }
    }

    @Test
    fun `중복된 숫자가 주면 IllegalArgumentException throw`() {
        val numbers = listOf(1, 2, 3, 4, 5, 5)
        shouldThrow<IllegalArgumentException> {
            LottoNumber.from(numbers)
        }
    }
}

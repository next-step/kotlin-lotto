package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    fun `발급된 로또 번호는 6개이다`() {
        val lottoNumber = LottoNumber.buildAuto()
        lottoNumber.value.size shouldBe 6
    }

    @Test
    fun `6개가 아닌 숫자를 주면 IllegalArgumentException throw`() {
        val numbers = listOf(1, 2, 3, 4, 5)
        shouldThrow<IllegalArgumentException> {
            LottoNumber.from(numbers)
        }
    }

    @Test
    fun `발급된 로또번호의 범위는 1부터 45이다`() {
        val lottoNumber = LottoNumber.buildAuto()
        lottoNumber.value.all { it in 1..45 } shouldBe true
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

package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    fun `1부터 45가 아닌 숫자를 주면 IllegalArgumentException throw`() {
        val numbers = listOf(1, 2, 3, 4, 5, 46)
        val bonusNumber = 6
        shouldThrow<IllegalArgumentException> {
            LottoNumber.from(numbers, bonusNumber)
        }
    }

    @Test
    fun `기본 숫자와 중복된 보너스 숫자를 주면 IllegalArgumentException throw`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 1
        shouldThrow<IllegalArgumentException> {
            LottoNumber.from(numbers, bonusNumber)
        }
    }

    @Test
    fun `2등을 위한 보너스 숫자를 받는다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        LottoNumber.from(numbers, bonusNumber).bonusNumber shouldBe bonusNumber
    }
}

package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [0, -10, 46, 100])
    fun `로또 번호는 1보다 작거나 45보다 클수 없다`(number: Int) {
        shouldThrow<IllegalArgumentException> {
            LottoNumber(number)
        }.also {
            it.message shouldBe "로또 번호는 1보다 적거나 45보다 클 수 없습니다"
        }
    }
}

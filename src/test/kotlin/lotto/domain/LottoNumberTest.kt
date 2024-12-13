package lotto.domain

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

    @ParameterizedTest
    @ValueSource(ints = [0, -10, 46, 100])
    fun `로또 번호는 1부터 45사의의 숫자가 아니면 예외가 발생한다`(number: Int) {
        shouldThrow<IllegalArgumentException> {
            LottoNumber.from(number)
        }.also {
            it.message shouldBe "유효하지 않은 번호입니다"
        }
    }
}

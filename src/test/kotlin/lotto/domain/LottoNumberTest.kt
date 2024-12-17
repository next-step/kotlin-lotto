package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.Test

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [0, -10, 46, 100])
    fun `로또 번호는 1부터 45사이의 숫자가 아니면 예외가 발생한다`(number: Int) {
        shouldThrow<IllegalArgumentException> {
            LottoNumber.from(number)
        }.also {
            it.message shouldBe "로또 번호는 1보다 적거나 45보다 클 수 없습니다"
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-10", "46", "100"])
    fun `로또 번호는 1부터 45사이의 숫자 문자열이 아니면 예외가 발생한다`(number: String) {
        shouldThrow<IllegalArgumentException> {
            LottoNumber.from(number)
        }.also {
            it.message shouldBe "로또 번호는 1보다 적거나 45보다 클 수 없습니다"
        }
    }

    @Test
    fun `숫자 생성자 로또 번호와 문자열 생성자 로또 번호는 같다`() {
        LottoNumber.from("1") shouldBeEqual LottoNumber.from(1)
    }

    @ParameterizedTest
    @ValueSource(strings = ["A", "*", "ㄱ", "숫자"])
    fun `로또 번호는 숫자가 아닌 문자열을 전달하면 예외가 발생한다`(number: String) {
        shouldThrow<IllegalArgumentException> {
            LottoNumber.from(number)
        }.also {
            it.message shouldBe "유효하지 않은 번호입니다"
        }
    }
}

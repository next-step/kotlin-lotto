package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 45])
    fun `로또 번호는 1 에서 45 사이의 숫자만 가능하다`(number: Int) {
        val lottoNumber = LottoNumber.from(number)

        lottoNumber.number shouldBe number
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    fun `1~45 범위가 아닌 숫자는 예외가 발생한다`(number: Int) {
        shouldThrow<IllegalArgumentException> { LottoNumber.from(number) }
            .shouldHaveMessage(LottoNumber.LOTTO_NUMBER_OUT_OF_RANGE_MESSAGE)
    }
}

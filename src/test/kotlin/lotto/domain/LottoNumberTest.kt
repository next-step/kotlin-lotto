package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import lotto.domain.LottoNumber.Companion.INVALID_LOTTO_NUMBER_MESSAGE
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 46, -5])
    fun `로또 번호는 1부터 45사이 값이 아니면 에러가 발생한다`(number: Int) {
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_LOTTO_NUMBER_MESSAGE) {
            LottoNumber.of(number)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 12, 23, 4, 35, 45])
    fun `로또 번호는 value class로 관리된다`(number: Int) {
        val lottoNumberInstance1 = LottoNumber.of(number)
        val lottoNumberInstance2 = LottoNumber.of(number)
        lottoNumberInstance1 shouldBeEqualToComparingFields lottoNumberInstance2
    }
}

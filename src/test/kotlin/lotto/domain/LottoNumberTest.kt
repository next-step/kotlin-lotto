package lotto.domain

import io.kotest.matchers.types.shouldBeSameInstanceAs
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    internal fun `로또 번호가 1과 45사이의 값을 가지지 않으면 예외가 발생한다`(value: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber.from(value) }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 10, 45])
    internal fun `두 LottoNumber 객체가 번호가 같으면 동일한 객체다`(value: Int) {
        val lottoNumberA = LottoNumber.from(value)
        val lottoNumberB = LottoNumber.from(value)
        lottoNumberA shouldBeSameInstanceAs lottoNumberB
    }
}

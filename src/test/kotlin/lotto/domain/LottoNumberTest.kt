package lotto.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `로또 숫자 범위 밖일 경우 예외를 던진다`(value: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber.from(value) }
    }
}

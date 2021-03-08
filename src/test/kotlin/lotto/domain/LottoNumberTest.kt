package lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {

    @ParameterizedTest(name = "{0}일 경우")
    @ValueSource(ints = [1, 5, 10, 30, 45])
    fun `로또 넘버는 1~45 사이의 값을 가진다 정상 생성`(value: Int) {
        assertDoesNotThrow { LottoNumber.of(value) }
    }

    @ParameterizedTest(name = "{0}일 경우")
    @ValueSource(ints = [0, 46])
    fun `로또 넘버는 1~45 사이의 값을 가진다 예외 처리`(value: Int) {
        assertThrows<IndexOutOfBoundsException> { LottoNumber.of(value) }
    }
}

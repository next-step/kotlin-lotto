package lotto.domain

import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `로또 번호는 1~45사이 숫자`(value: Int) {
        assertThrows<IllegalArgumentException> {
            LottoNumber(value)
        }.shouldHaveMessage("로또 번호는 1 ~ 45 숫자입니다.")
    }
}

package lottogame.domain.lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 30, 45])
    fun `숫자를 받아 로또 번호를 생성한다`(value: Int) {
        shouldNotThrowAny { LottoNumber(value) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `1부터 45 사이의 숫자가 아닌 경우 예외가 발생한다`(value: Int) {
        shouldThrow<IllegalArgumentException> { LottoNumber(value) }
    }
}

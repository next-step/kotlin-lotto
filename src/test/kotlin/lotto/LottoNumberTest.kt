package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @Test
    fun `숫자를 받아 로또 번호를 생성한다`() {
        val lottoNumber = LottoNumber(1)

        lottoNumber shouldNotBe null
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `1부터 45 사이의 숫자가 아닌 경우 예외가 발생한다`(value: Int) {
        shouldThrow<IllegalArgumentException> { LottoNumber(value) }
    }
}

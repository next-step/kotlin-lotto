package lotto.domain.model

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    fun `LottoNumber 생성시 1 미만, 45 초과인 숫자를 넣으면 예외 발생`() {
        assertThrows(IllegalArgumentException::class.java) {
            LottoNumber.from(0)
        }

        assertThrows(IllegalArgumentException::class.java) {
            LottoNumber.from(46)
        }
    }
}

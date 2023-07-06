package lotto

import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

class LottoNumberTest {

    @Test
    fun `숫자를 받아 로또 번호를 생성한다`() {
        val lottoNumber = LottoNumber(1)

        lottoNumber shouldNotBe null
    }
}

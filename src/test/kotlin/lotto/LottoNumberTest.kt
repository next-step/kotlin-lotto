package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoNumberTest {

    @Test
    fun `로또 번호를 생성한다`() {
        val number = LottoNumber(1)
        number.getNumber() shouldBe 1
    }
}

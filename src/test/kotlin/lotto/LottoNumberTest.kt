package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoNumberTest {

    @Test
    fun `로또 번호를 생성한다`() {
        val number = LottoNumber(1)
        number.getNumber() shouldBe 1
    }

    @Test
    fun `로또 번호는 45를 넘을 수 없다`() {
        shouldThrow<IllegalArgumentException> { LottoNumber(46) }
    }
}

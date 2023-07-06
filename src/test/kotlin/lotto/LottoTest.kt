package lotto

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `로또 번호가 5개인 경우 예외가 발생한다`() {
        val numbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5)
        )

        shouldThrow<IllegalArgumentException> { Lotto(numbers) }
    }

    @Test
    fun `로또 번호가 7개인 경우 예외가 발생한다`() {
        val numbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
            LottoNumber(7),
        )

        shouldThrow<IllegalArgumentException> { Lotto(numbers) }
    }
}

package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
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

    @Test
    fun `숫자 목록을 받아 로또를 생성한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        shouldNotThrowAny { Lotto.from(numbers) }
    }

    @Test
    fun `번호가 중복된 경우 예외가 발생한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 5)

        shouldThrow<IllegalArgumentException> { Lotto.from(numbers) }
    }

    @Test
    fun `로또를 비교해서 일치하는 숫자의 개수를 반환한다`() {
        val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6))

        val result = lotto.match(winningLotto)

        result shouldBe 6
    }
}

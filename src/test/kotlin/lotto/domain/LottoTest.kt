package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `로또 번호가 5개인 경우 예외가 발생한다`() {
        val numbers = listOf(1, 2, 3, 4, 5)

        shouldThrow<IllegalArgumentException> { Lotto.of(numbers, LottoType.MANUAL) }
    }

    @Test
    fun `로또 번호가 7개인 경우 예외가 발생한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)

        shouldThrow<IllegalArgumentException> { Lotto.of(numbers, LottoType.MANUAL) }
    }

    @Test
    fun `숫자 목록을 받아 로또를 생성한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        shouldNotThrowAny { Lotto.of(numbers, LottoType.MANUAL) }
    }

    @Test
    fun `번호가 중복된 경우 예외가 발생한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 5)

        shouldThrow<IllegalArgumentException> { Lotto.of(numbers, LottoType.MANUAL) }
    }

    @Test
    fun `로또를 비교해서 일치하는 숫자의 개수를 반환한다`() {
        val lotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6), LottoType.MANUAL)
        val winningLotto = WinningLotto.from(listOf(1, 2, 3, 4, 5, 6), 7)

        val result = winningLotto.match(lotto)

        result shouldBe Rank.FIRST
    }

    @Test
    fun `일치하는 숫자가 3개 미만이면 null을 반환한다`() {
        val lotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6), LottoType.MANUAL)
        val winningLotto = WinningLotto.from(listOf(1, 2, 7, 8, 9, 10), 11)

        val result = winningLotto.match(lotto)

        result shouldBe null
    }
}

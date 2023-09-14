package lottogame.domain.lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import lottogame.domain.rank.Rank
import org.junit.jupiter.api.Test

class LottoNumbersTest {

    @Test
    fun `로또 번호가 5개인 경우 예외가 발생한다`() {
        val numbers = listOf(1, 2, 3, 4, 5)

        shouldThrow<IllegalArgumentException> { LottoNumbers.of(numbers) }
    }

    @Test
    fun `로또 번호가 7개인 경우 예외가 발생한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)

        shouldThrow<IllegalArgumentException> { LottoNumbers.of(numbers) }
    }

    @Test
    fun `숫자 목록을 받아 로또를 생성한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        shouldNotThrowAny { LottoNumbers.of(numbers) }
    }

    @Test
    fun `번호가 중복된 경우 예외가 발생한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 5)

        shouldThrow<IllegalArgumentException> { LottoNumbers.of(numbers) }
    }

    @Test
    fun `로또를 비교해서 일치하는 숫자의 개수를 반환한다`() {
        val lottoNumbers = LottoNumbers.of(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto.from(listOf(1, 2, 3, 4, 5, 6), 7)

        val result = winningLotto.match(lottoNumbers)

        result shouldBe Rank.FIRST
    }

    @Test
    fun `일치하는 숫자가 3개 미만이면 null을 반환한다`() {
        val lottoNumbers = LottoNumbers.of(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto.from(listOf(1, 2, 7, 8, 9, 10), 11)

        val result = winningLotto.match(lottoNumbers)

        result shouldBe null
    }
}

package autolotto

import autolotto.vo.AutoLotto
import autolotto.vo.Lotto
import autolotto.vo.WinningLotto
import autolotto.winningpoint.WinningRank
import io.kotest.matchers.ints.beInRange
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 1장은 6개의 숫자다`() {
        // Given
        val lotto = Lotto()

        // When
        val numbers = lotto.numbers

        // Then
        numbers.size shouldBe 6
    }

    @Test
    fun `로또 1장의 숫자는 1~45의 숫자다`() {
        // Given
        val lotto = Lotto()

        // When
        val numbers = lotto.numbers

        // Then
        numbers.forEach {
            it shouldBe beInRange(IntRange(1, 45))
        }
    }

    @Test
    fun `로또 1장의 숫자는 중복되지 않는다`() {
        // Given
        val lotto = Lotto()

        // When
        val numbers = lotto.numbers

        // Then
        numbers.distinct().size shouldBe 6
    }

    @Test
    fun `로또 1장의 숫자는 오름차순으로 정렬되어있다`() {
        // Given
        val lotto = Lotto()

        // When
        val numbers = lotto.numbers

        // Then
        numbers shouldBe numbers.sorted()
    }

    @Test
    fun `당첨번호와 일치하는 숫자의 갯수를 반환한다`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto("1, 2, 3, 4, 5, 7")

        // When
        val (matchCount, _) = lotto.checkWinning(winningLotto.numbers)

        // Then
        matchCount shouldBe 5
    }

    @Test
    fun `당첨번호와 일치하는 숫자로 rank를 반환한다`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto("1, 2, 3, 4, 5, 7")

        // When
        val (matchCount, _) = lotto.checkWinning(winningLotto.numbers)

        // Then
        WinningRank.of(matchCount) shouldBe WinningRank.SECOND
    }

    @Test
    fun `당첨번호와 일치하는 숫자로 수익률을 계산한다`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 3, 30, 31, 32))
        val autoLotto = AutoLotto(1000L, listOf(lotto))
        val winningLotto = WinningLotto("1, 2, 3, 4, 5, 6")

        // When
        val (matchCount, winningRank) = lotto.checkWinning(winningLotto.numbers)
        val totalPrice = autoLotto.calculateTotalWinningPrice(winningLotto.numbers)
        val profit = autoLotto.getProfitRate(totalPrice.toDouble())

        // Then
        assertThat(matchCount).isEqualTo(3)
        assertThat(winningRank).isEqualTo(WinningRank.FOURTH)
        profit shouldBe 5
    }

    @Test
    fun `14000원을 구매하고 4등이 1개인 경우 수익률은 0,35이다`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 3, 30, 31, 32))
        val autoLotto = AutoLotto(14000L, listOf(lotto))
        val winningLotto = WinningLotto("1, 2, 3, 4, 5, 6")

        // When
        val (matchCount, winningRank) = lotto.checkWinning(winningLotto.numbers)
        val totalPrice = autoLotto.calculateTotalWinningPrice(winningLotto.numbers)
        val profit = autoLotto.getProfitRate(totalPrice.toDouble())

        // Then
        assertThat(matchCount).isEqualTo(3)
        assertThat(winningRank).isEqualTo(WinningRank.FOURTH)
        profit shouldBe 0.35
    }
}

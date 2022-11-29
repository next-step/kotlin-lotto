package lotto.domain

import calculator.Tokenizer
import io.kotest.matchers.shouldBe
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoTest {

    @DisplayName("주어진 숫자로 로또가 생성된다")
    @Test
    fun createLotto() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(list)

        assertThat(lotto.numbers).asList().isEqualTo(list)
    }

    @DisplayName("로또 숫자는 6개이다")
    @Test
    fun numberSize() {
        val lotto = Lotto()
        val listSize = lotto.numbers.size

        assertThat(listSize).isEqualTo(6)
    }

    @DisplayName("로또 숫자들은 오름차순으로 정렬된다")
    @Test
    fun orderASC() {
        val lotto = Lotto()
        val first = lotto.numbers[0]
        val second = lotto.numbers[1]

        assertThat(first).isLessThan(second)
    }

    @DisplayName("당첨 된 숫자 개수를 확인한다")
    @ParameterizedTest
    @ValueSource(
        strings = ["8, 21, 23, 41, 42, 43", "3, 5, 11, 16, 32, 38"]
    )
    fun win(input: String) {
        val lotto = Lotto()
        val numbers: List<Int> = Tokenizer.tokenize(input).map { it.toInt() }

        val matchingCount = LottoMatcher.countMatchNumber(numbers, lotto.numbers)
        val reward = WinningChecker.win(winningNumberStrings = input, lottoNumbers = lotto.numbers)

        reward.matchingCount shouldBe matchingCount
    }
}

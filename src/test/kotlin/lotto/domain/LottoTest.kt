package lotto.domain

import calculator.Tokenizer
import io.kotest.matchers.shouldBe
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoTest {

    @DisplayName("로또 숫자는 랜덤하게 생성된다")
    @Test
    fun randomNumber() {
        val firstLotto = Lotto()
        val secondLotto = Lotto()

        val firstSum = firstLotto.list.sum()
        val secondSum = secondLotto.list.sum()

        assertThat(firstSum).isNotEqualTo(secondSum)
    }

    @DisplayName("로또 숫자는 6개이다")
    @Test
    fun numberSize() {
        val lotto = Lotto()
        val listSize = lotto.list.size

        assertThat(listSize).isEqualTo(6)
    }

    @DisplayName("로또 숫자들은 오름차순으로 정렬된다")
    @Test
    fun orderASC() {
        val lotto = Lotto()
        val first = lotto.list[0]
        val second = lotto.list[1]

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

        val expectedResult = LottoMatcher.match(numbers, lotto.list)
        lotto.win(input)

        lotto.matchingCount shouldBe expectedResult
    }
}

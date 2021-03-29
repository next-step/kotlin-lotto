package domain.statistics

import domain.money.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class WinningCategoryTest {
    @Test
    fun `당첨항목은 '3개 일치', '4개 일치', '5개 일치', '5개 & 보너스 볼 일치', '6개 일치'가 있다`() {
        assertThat(WinningCategory.values().map { it.name })
            .containsExactly(
                "THREE_CORRECT",
                "FOUR_CORRECT",
                "FIVE_CORRECT",
                "FIVE_WITH_BONUS_CORRECT",
                "SIX_CORRECT"
            )
    }

    @ParameterizedTest
    @CsvSource(
        "THREE_CORRECT, 3",
        "FOUR_CORRECT, 4",
        "FIVE_CORRECT, 5",
        "FIVE_WITH_BONUS_CORRECT, 5",
        "SIX_CORRECT, 6"
    )
    fun `각 당첨항목마다 일치하는 개수를 가지고 있다`(category: WinningCategory, numberOfMatched: Int) {
        assertThat(category.numberOfMatched).isEqualTo(numberOfMatched)
    }

    @ParameterizedTest
    @CsvSource(
        "THREE_CORRECT, 5000",
        "FOUR_CORRECT, 50000",
        "FIVE_CORRECT, 1500000",
        "FIVE_WITH_BONUS_CORRECT, 30000000",
        "SIX_CORRECT, 2000000000"
    )
    fun `당첨항목마다 당첨금은 아래와 같다`(category: WinningCategory, prize: Long) {
        assertThat(category.prize).isEqualTo(Money(prize))
    }

    @ParameterizedTest(name = "{0}개가 매칭되면 {1}를 반환해야 한다")
    @CsvSource(
        "0, null",
        "1, null",
        "2, null",
        "3, THREE_CORRECT",
        "4, FOUR_CORRECT",
        "5, FIVE_CORRECT",
        "6, SIX_CORRECT",
        nullValues = ["null"]
    )
    fun matchNumberOfTest(numberOfMatched: Int, expectedCategory: WinningCategory?) {
        // when
        val actual = WinningCategory.matchNumberOf(numberOfMatched)

        // then
        assertThat(actual).isEqualTo(expectedCategory)
    }
}

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoCardTest {

    @Test
    fun `6개의 로또 번호가 있는 카드를 원하는 갯수만큼 추출한다`() {
        val cnt = 15
        val lottoCards = LottoCards()
        lottoCards.generateRandomLottoCard(cnt)

        assertThat(lottoCards.cards.size, Matchers.`is`(cnt))
        assertThat(
            lottoCards.cards.filter {
                (ReflectionUtil.getField(it, "_numbers") as List<*>).size ==
                    ReflectionUtil.getField(it, "LOTTO_NUMBER_CNT")
            }.size,
            `is`(cnt)
        )
    }

    @Test
    fun `정상적으로 당첨 통계 로직을 수행한다`() {
        val lottoCards = LottoCards()
        listOf(
            LottoCard(listOf(1, 2, 3, 4, 5, 6)), LottoCard(listOf(11, 12, 13, 14, 15, 16)),
            LottoCard(listOf(1, 2, 3, 14, 15, 16)), LottoCard(listOf(1, 2, 3, 4, 5, 7)),
            LottoCard(listOf(1, 2, 3, 4, 5, 9))
        ).forEach { lottoCards.addLottoCard(it) }

        val beforeWeekLottoCard = LottoCard(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber(7)
        val statistic = lottoCards.getStatistic(beforeWeekLottoCard, bonusNumber)

        assertThat(statistic.filter { it.key == Winning.FIRST }.size, Matchers.`is`(1))
        assertThat(statistic.filter { it.key == Winning.SECOND }.size, Matchers.`is`(1))
        assertThat(statistic.filter { it.key == Winning.THIRD }.size, Matchers.`is`(1))
        assertThat(statistic.filter { it.key == Winning.FIFTH }.size, Matchers.`is`(1))
        assertThat(statistic.size, Matchers.`is`(4))
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1,2,3,4,5,6,7"])
    fun `로또 번호를 6개 입력하지 않으면 예외가 발생한다`(numbers: String) {
        assertThrows<IllegalArgumentException> {
            LottoCard(parseNumbers(numbers))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1,2,-3,74,95,100", "1,2,3,4,5,66"])
    fun `입력된 숫자가 로또 번호 범위에 포함되지 않으면 예외가 발생한다`(numbers: String) {
        assertThrows<IllegalArgumentException> {
            LottoCard(parseNumbers(numbers))
        }
    }

    private fun parseNumbers(numberLine: String): List<Int> {
        return numberLine.split(",").map { it.parseInt() }
    }
}

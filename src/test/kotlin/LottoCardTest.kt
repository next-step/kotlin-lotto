import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test

class LottoCardTest {

    @Test
    fun `6개의 로또 번호가 있는 카드를 원하는 갯수만큼 추출한다`() {
        val cnt = 15
        val lottoCards = LottoCards(cnt).cards

        assertThat(lottoCards.size, Matchers.`is`(cnt))
        assertThat(
            lottoCards.filter {
                (ReflectionUtil.getField(it, "numbers") as List<*>).size ==
                    ReflectionUtil.getField(it, "LOTTO_NUMBER_CNT")
            }.size,
            `is`(cnt)
        )
    }

    @Test
    fun `정상적으로 당첨 통계 로직을 수행한다`() {
        val lottoCards = LottoCards(0)
        val lottoCardsData = listOf(
            LottoCard(listOf(1, 2, 3, 4, 5, 6)), LottoCard(listOf(11, 12, 13, 14, 15, 16)),
            LottoCard(listOf(1, 2, 3, 14, 15, 16))
        )

        lottoCards.cards = lottoCardsData

        val beforeWeekLottoCard = LottoCard(listOf(1, 2, 3, 4, 5, 6))
        val statistic = lottoCards.getStatistic(beforeWeekLottoCard)

        assertThat(statistic.filter { it.key == Winning.FIRST }.size, Matchers.`is`(1))
        assertThat(statistic.filter { it.key == Winning.FOURTH }.size, Matchers.`is`(1))
        assertThat(statistic.size, Matchers.`is`(2))
    }
}

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
}

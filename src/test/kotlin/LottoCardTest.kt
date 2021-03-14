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
    fun `저번주 로또번호를 입력하지 않거나 빈 값을 넣으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoCard(null)
        }

        assertThrows<IllegalArgumentException> {
            LottoCard("")
        }

        assertThrows<IllegalArgumentException> {
            LottoCard("    ")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1, 2, 3, 4, 5, 6, 7"])
    fun `로또 번호를 6개 입력하지 않으면 예외가 발생한다`(numbers: String) {
        assertThrows<IllegalArgumentException> {
            LottoCard(numbers)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1,2,-3,74,95,100", "1, 2, 3, 4, 5, 66"])
    fun `입력된 숫자가 로또 번호 범위에 포함되지 않으면 예외가 발생한다`(numbers: String) {
        assertThrows<IllegalArgumentException> {
            LottoCard(numbers)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a,b,c,d,e,f", "1, 2, 3, 4, 5, error"])
    fun `숫자가 아닌 값이 문자가 등록되면 예외가 발생한다`(numbers: String) {
        assertThrows<IllegalArgumentException> {
            LottoCard(numbers)
        }
    }
}

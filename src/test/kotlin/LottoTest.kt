import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    private val lotto = Lotto()

    @Test
    fun `구입금액 문자열을 int로 파싱한다`() {
        assertThat(lotto.validatePrice("15000"), `is`(15000))
    }

    @Test
    fun `구입금액을 입력하지 않거나 빈 값을 넣으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lotto.validatePrice(null)
        }

        assertThrows<IllegalArgumentException> {
            lotto.validatePrice("")
        }

        assertThrows<IllegalArgumentException> {
            lotto.validatePrice("    ")
        }
    }

    @Test
    fun `구입금액을 정확히 입력하지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lotto.validatePrice("15600원")
        }

        assertThrows<IllegalArgumentException> {
            lotto.validatePrice("만원")
        }
    }

    @Test
    fun `구입 금액은 반드시 1000원보다 커야한다`() {
        assertThrows<IllegalArgumentException> {
            lotto.validatePrice("-2000")
        }

        assertThrows<IllegalArgumentException> {
            lotto.validatePrice("0")
        }

        assertThrows<IllegalArgumentException> {
            lotto.validatePrice("500")
        }
    }

}

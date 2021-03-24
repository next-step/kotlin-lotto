import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

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

    @ParameterizedTest
    @MethodSource("buyLotto")
    fun `금액에 맞는 로또를 구매한다`(price: Int, resultCnt: Int) {
        assertThat(lotto.canBuyCount(price), `is`(resultCnt))
    }

    @Test
    fun `수익률을 정상적으로 계산한다`() {
        val map = mapOf(Winning.SECOND to 2, Winning.THIRD to 1)
        val yieldRate = lotto.getYieldRate(map, 50000)
        assertThat(yieldRate, `is`(1230.0))
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `저번주 로또번호를 입력하지 않거나 빈 값을 넣으면 예외가 발생한다`(numberLine: String?) {
        assertThrows<IllegalArgumentException> {
            lotto.parseLottoCard(numberLine)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a,b,c,d,e,f", "1, 2, 3, 4, 5, error"])
    fun `숫자가 아닌 값이 문자가 등록되면 예외가 발생한다`(numbers: String) {
        assertThrows<IllegalArgumentException> {
            lotto.parseLottoCard(numbers)
        }
    }

    @Test
    fun `수동으로 구매하는 로또의 수는 총 구매 로또 수보다 적어야한다`() {
        assertThat(lotto.validatePassiveCnt("3", 10), `is`(3))
    }

    @Test
    fun `수동으로 구매하는 로또의 수가 총 구매 로또 수보다 크면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            lotto.validatePassiveCnt("100", 10)
        }
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `수동 로또번호 갯수를 입력하지 않거나 빈 값을 넣으면 예외가 발생한다`(passiveCnt: String?) {
        assertThrows<IllegalArgumentException> {
            lotto.validatePassiveCnt(passiveCnt, 10)
        }
    }

    companion object {
        @JvmStatic
        fun buyLotto(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(15000, 15),
                Arguments.of(7200, 7),
                Arguments.of(22222, 22)
            )
        }
    }
}

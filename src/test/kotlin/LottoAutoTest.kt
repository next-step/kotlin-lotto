import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions.assertThatThrownBy
import java.lang.IllegalArgumentException


@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in 1..45) {
            throw IllegalArgumentException("number not in 1..45")
        }
    }
}

class LottoAutoTest : StringSpec({
    "each lotto ticket number not in 1..45 should throw IllegalArgumentException" {
        assertThatThrownBy {
            LottoNumber(0)
        }.isInstanceOf(IllegalArgumentException::class.java)

        assertThatThrownBy {
            LottoNumber(50)
        }.isInstanceOf(IllegalArgumentException::class.java)

        assertThatThrownBy {
            LottoNumber(-4)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    "lotto ticket should having exact 6 numbers should throw IllegalArgumentException" {

    }

    "lotto ticket is 1,000 KRW/EA" {

    }

    "lotto ticket with same numbers should throw RuntimeException" {

    }

    "should buy as many lotto tickets as possible with budget" {

    }

    "winning numbers with same number should throw IllegalArgumentException" {

    }

    "winning statistics should show correct win state" {

    }

    "winning statistics should show correct ROI" {

    }
})

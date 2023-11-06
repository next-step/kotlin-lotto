import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions.assertThatThrownBy
import java.lang.IllegalArgumentException


@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in 1..45) {
            throw IllegalArgumentException("Invalid number: number not in 1..45")
        }
    }
}


data class LottoNumbers(private val lottoNumberList: List<LottoNumber>) {
    init {
        require(lottoNumberList.size == 6) {
            throw IllegalArgumentException("Invalid size: lotto numbers should have exact 6 numbers: $lottoNumberList")
        }
        require(lottoNumberList.toSet().size == 6) {
            throw IllegalArgumentException("Duplicated number: lotto numbers should not have duplicated number: $lottoNumberList")
        }
    }
}

class LottoAutoTest : StringSpec({
    "each lotto ticket number not in 1..45 should throw IllegalArgumentException" {
        assertThatThrownBy {
            LottoNumber(0)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid number")

        assertThatThrownBy {
            LottoNumber(50)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid number")

        assertThatThrownBy {
            LottoNumber(-4)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid number")
    }

    "lotto ticket should having exact 6 numbers should throw IllegalArgumentException" {
        assertThatThrownBy {
            LottoNumbers(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                    LottoNumber(7),
                )
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid size")

        assertThatThrownBy {
            LottoNumbers(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                )
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid size")
    }

    "lotto ticket with same numbers should throw RuntimeException" {
        assertThatThrownBy {
            LottoNumbers(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(5),
                )
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Duplicated number")

        assertThatThrownBy {
            LottoNumbers(
                listOf(
                    LottoNumber(1),
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                )
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Duplicated number")
    }

    "lotto ticket is 1,000 KRW/EA" {

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

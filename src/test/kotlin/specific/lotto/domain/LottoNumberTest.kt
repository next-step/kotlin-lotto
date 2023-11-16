package specific.lotto.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoNumberTest {

    @ParameterizedTest
    @CsvSource(
        "0|2|3|4|5|6",
        "1|2|3|4|5|46"
    )
    fun `로또 번호(당첨 번호)는 1~45 중 하나이다, else throw IllegalArgumentException`(values: String) {
        assertThrows<IllegalArgumentException> {
            LottoNumber(values.split("|").map { it.toInt() })
        }
    }

    @ParameterizedTest
    @CsvSource(
        "1|2|3|4|5",
        "1|2|3|4|5|6|7"
    )
    fun `로또 번호(당첨 번호)들은 총 6개다, else throw IllegalArgumentException`(values: String) {
        assertThrows<IllegalArgumentException> {
            LottoNumber(values.split("|").map { it.toInt() })
        }
    }

    @ParameterizedTest
    @CsvSource(
        "2|2|3|4|5|6",
        "1|2|3|4|4|4"
    )
    fun `로또 번호(당첨 번호)들은 중복되면 안된다, else throw IllegalArgumentException`(values: String) {
        assertThrows<IllegalArgumentException> {
            LottoNumber(values.split("|").map { it.toInt() })
        }
    }

    @ParameterizedTest
    @CsvSource(
        "2|1|3|4|5|6",
        "6|5|4|3|2|1"
    )
    fun `로또 번호(당첨 번호)들은 오름차순 정렬되어 있어야 한다, else throw IllegalArgumentException`(values: String) {
        assertThrows<IllegalArgumentException> {
            LottoNumber(values.split("|").map { it.toInt() })
        }
    }
}

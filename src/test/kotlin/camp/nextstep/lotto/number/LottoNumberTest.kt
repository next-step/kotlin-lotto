package camp.nextstep.lotto.number

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {

    @DisplayName("로또 번호는 1에서 45 사이의 정수이다.")
    @ParameterizedTest
    @ValueSource(
        strings = [
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
            "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
            "41", "42", "43", "44", "45"
        ]
    )
    fun lottoNumberRangeTest(validLottoNumber: Int) {
        val lottoNumber = LottoNumber.of(validLottoNumber)
        assertThat(lottoNumber.value).isEqualTo(validLottoNumber)
    }

    @DisplayName("로또 번호는 1보다 작거나 45보다 클 수 없다.")
    @ParameterizedTest
    @ValueSource(
        strings = [
            "-1", "-10",
            "0",
            "46", "47", "100"
        ]
    )
    fun invalidLottoNumberRangeTest(invalidLottoNumber: Int) {
        assertThrows<IllegalArgumentException> {
            LottoNumber.of(invalidLottoNumber)
        }
    }
}

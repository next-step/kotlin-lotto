package camp.nextstep.lotto.number

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoNumbersTest {

    @DisplayName("로또 추첨 번호는 6개이다.")
    @Test
    fun lottoNumbersTest() {
        assertEquals(6, LottoNumbers.LOTTO_NUMBERS)
    }

    @DisplayName("각각의 로또 추첨 번호는 1이상 45 이하이다.")
    @Test
    fun lottoNumberRangeTest() {
        assertEquals(1..45, LottoNumber.LOTTO_NUMBER_RANGE)
    }
}

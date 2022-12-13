package lotto.model

import lotto.service.LottoGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoTest {
    @Test
    internal fun `로또 숫자들은 6개로 구성된다`() {
        val lotto = Lotto.of(1, 2, 3, 4, 5, 6)
        assertThat(lotto.size).isEqualTo(6)
    }

    @Test
    internal fun `로또 숫자들이 6개가 아니면 생성되지 않는다`() {
        assertThrows<IllegalArgumentException> { Lotto.of(1, 2, 3, 4, 5) }
        assertThrows<IllegalArgumentException> { Lotto.of(1, 2, 3, 4, 5, 6, 7) }
    }

    @Test
    internal fun `로또 숫자들은 중복이 될 수 없다`() {
        assertThrows<IllegalArgumentException> { Lotto.of(1, 1, 3, 4, 5, 6) }
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "1,2,3,4,5,6 : 1,2,3,4,5,6 : 6",
            "1,2,3,4,5,6 : 2,3,4,5,6,7 : 5",
            "1,2,3,4,5,6 : 3,4,5,6,7,8 : 4",
            "1,2,3,4,5,6 : 4,5,6,7,8,9 : 3",
            "1,2,3,4,5,6 : 5,6,7,8,9,10 : 2",
            "1,2,3,4,5,6 : 6,7,8,9,10,11 : 1",
            "1,2,3,4,5,6 : 7,8,9,10,11,12 : 0",
        ],
        delimiter = ':'
    )
    internal fun `일치하는 번호 갯수`(input1: String, input2: String, expected: Int) {
        val lotto1 = LottoGenerator.fromString(input1)
        val lotto2 = LottoGenerator.fromString(input2)
        val matchCount = lotto1.matchCountWith(lotto2)

        assertThat(matchCount).isEqualTo(expected)
    }
}

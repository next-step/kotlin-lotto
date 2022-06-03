package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumbersTest {

    @Test
    fun `발급되는 로또는 1~45의 로또 숫자가 6개가 아니면 IllegalArgument 에러가 발생한다`() {
        assertThrows<IllegalArgumentException> { LottoNumbers(createSixLottoNumber(listOf(2, 10, 15, 22, 27, 36, 9))) }
    }

    private fun createSixLottoNumber(numbers: List<Int>): List<LottoNumber> {
        return numbers.map { LottoNumber.from(it) }
            .toList()
    }
}

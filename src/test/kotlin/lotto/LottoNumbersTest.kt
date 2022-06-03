package lotto

import lotto.Fixtures.createSixLottoNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumbersTest {

    @Test
    fun `발급되는 로또는 1~45의 로또 숫자가 6개가 아니면 IllegalArgument 에러가 발생한다`() {
        assertThrows<IllegalArgumentException> { LottoNumbers(createSixLottoNumber(listOf(2, 10, 15, 22, 27, 36, 9))) }
    }

    @Test
    fun `로또 번호 6자리가 중복되면 IllegalArgument 에러가 발생한다`() {
        assertThrows<IllegalArgumentException> { LottoNumbers(createSixLottoNumber(listOf(2, 10, 3, 11, 5, 5))) }
    }
}

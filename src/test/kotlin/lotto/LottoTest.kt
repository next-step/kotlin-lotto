package lotto

import lotto.domain.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class LottoTest {
    private val lotto = Lotto()

    @Test
    fun `생성된 로또 번호가 유효한 값인지 체크`() {
        assertDoesNotThrow { lotto.validateNums(lotto.nums) }
    }
}

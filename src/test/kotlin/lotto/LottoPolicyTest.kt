package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoPolicyTest {

    @Test
    fun `보너스 번호는 1 이상 45 이하 숫자이다`() {
        val invalidBonusNumber1 = 0
        val invalidBonusNumber2 = 46
        assertThrows<IllegalArgumentException> { LottoPolicy.validateBonusNumber(invalidBonusNumber1) }
        assertThrows<IllegalArgumentException> { LottoPolicy.validateBonusNumber(invalidBonusNumber2) }
    }
}

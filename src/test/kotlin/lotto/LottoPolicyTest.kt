package lotto

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoPolicyTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `보너스 번호는 1 이상 45 이하 숫자이다`(invalidNumber: Int) {
        assertThrows<IllegalArgumentException> { LottoPolicy.validateBonusNumber(invalidNumber) }
    }
}

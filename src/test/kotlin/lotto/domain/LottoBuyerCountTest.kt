package lotto.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoBuyerCountTest {
    @ParameterizedTest
    @ValueSource(ints = [5, 20, 100])
    fun `1) 구입금액보다 수동으로 구매하는 로또 구매 개수가 큰 경우 예외 발생`(manualLottoCount: Int) {
        assertThrows<IllegalArgumentException> {
            LottoBuyerCount(1000, manualLottoCount)
        }
    }
}
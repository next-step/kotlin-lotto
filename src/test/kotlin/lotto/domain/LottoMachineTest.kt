package lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoMachineTest {
    @ParameterizedTest
    @ValueSource(ints = [
        500, 10, 0, 50, 100, 99, 999
    ])
    fun `1000원 이하로 구매를 시도하면 예외가 발생한다`(price: Int) {
        assertThrows<IllegalArgumentException> {
            LottoMachine.buy(price)
        }
    }
}
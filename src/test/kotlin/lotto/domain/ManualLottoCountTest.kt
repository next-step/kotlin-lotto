package lotto.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class ManualLottoCountTest {
    @ParameterizedTest
    @CsvSource(
        "15000, 16",
        "14000, 15",
        "1000, 2",
        "10000, 30"
    )
    fun `구입금액 초과하는 수동 티켓 수 입력시 예외 발생`(price: Int, count: Int) {
        assertThrows<IllegalArgumentException> {
            ManualLottoCount(LottoPrice(price), LottoCount.from(count))
        }
    }
}

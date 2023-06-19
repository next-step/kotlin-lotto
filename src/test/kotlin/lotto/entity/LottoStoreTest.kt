package lotto.entity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoStoreTest {
    @DisplayName("로또는 로또에 설정된 로또 가격으로 계산되어서 발행되야합니다.")
    @ParameterizedTest
    @ValueSource(longs = [14000, 3500, 5600, 7800, 3298057, 384790])
    fun `price test`(price: Long) {
        assertEquals((price / Lotto.LOTTO_PRICE).toInt(), LottoStore.ticketing(price).size)
    }
}

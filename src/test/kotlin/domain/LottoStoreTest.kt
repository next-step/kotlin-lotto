package domain

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

internal class LottoStoreTest {
    @Test
    fun `로또판매기는 로또 가격으로 생성된다`() {
        assertDoesNotThrow { LottoStore(price = Money(1000)) }
    }
}

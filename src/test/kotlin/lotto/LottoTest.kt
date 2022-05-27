package lotto

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 1장의 가격은 1000원이다`() {
        val price = Lotto().price

        Assertions.assertEquals(1000, price)
    }
}

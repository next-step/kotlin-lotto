package lotto

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WinningPriceEnumKtTest {

    @Test
    fun `일치하는 숫자가 없으면 에러를 출력한다`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            getPrice(9)
        }
    }
}

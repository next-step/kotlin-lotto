package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoNumsTest {

    @Test
    fun `로또 번호는 6개다`() {
        assertThrows<IllegalArgumentException>("the number of nums must be 6") {
            LottoNums(
                listOf(
                    LottoNum(1),
                    LottoNum(2),
                    LottoNum(3),
                    LottoNum(4),
                    LottoNum(5)
                )
            )
        }
    }

    @Test
    fun `로또 번호는 겹치지 않는다`() {
        assertThrows<IllegalArgumentException>("all of nums must be unique") {
            LottoNums(
                listOf(
                    LottoNum(1),
                    LottoNum(1),
                    LottoNum(1),
                    LottoNum(1),
                    LottoNum(1),
                    LottoNum(1)
                )
            )
        }
    }
}

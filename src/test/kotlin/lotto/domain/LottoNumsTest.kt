package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoNumsTest {

    @Test
    fun `로또 번호는 6개다`() {
        assertThrows<IllegalArgumentException>("the number of nums must be 6") {
            LottoNums(
                listOf(
                    LottoNum.of(1),
                    LottoNum.of(2),
                    LottoNum.of(3),
                    LottoNum.of(4),
                    LottoNum.of(5)
                )
            )
        }
    }

    @Test
    fun `로또 번호는 겹치지 않는다`() {
        assertThrows<IllegalArgumentException>("all of nums must be unique") {
            LottoNums(
                listOf(
                    LottoNum.of(1),
                    LottoNum.of(1),
                    LottoNum.of(1),
                    LottoNum.of(1),
                    LottoNum.of(1),
                    LottoNum.of(1)
                )
            )
        }
    }
}

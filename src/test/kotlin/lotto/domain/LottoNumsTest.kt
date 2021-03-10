package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoNumsTest {

    @Test
    fun `로또 번호는 6개다`() {
        assertThrows<IllegalArgumentException>("the number of nums must be 6") {
            Lotto(
                listOf(
                    LottoNum.from(1),
                    LottoNum.from(2),
                    LottoNum.from(3),
                    LottoNum.from(4),
                    LottoNum.from(5)
                )
            )
        }
    }

    @Test
    fun `로또 번호는 겹치지 않는다`() {
        assertThrows<IllegalArgumentException>("all of nums must be unique") {
            Lotto(
                listOf(
                    LottoNum.from(1),
                    LottoNum.from(1),
                    LottoNum.from(1),
                    LottoNum.from(1),
                    LottoNum.from(1),
                    LottoNum.from(1)
                )
            )
        }
    }
}

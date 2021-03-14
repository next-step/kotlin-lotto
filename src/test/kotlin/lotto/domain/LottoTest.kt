package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoTest {

    @Test
    fun `로또의 당첨된 번호를 구한다`() {
        val lotto = createLotto(listOf(1, 2, 3, 4, 5, 6))
        val result = lotto.findMatchNums(createLotto(listOf(9, 8, 7, 3, 2, 1)))
        val expect = listOf(LottoNum.from(3), LottoNum.from(2), LottoNum.from(1))
        assertThat(result).containsExactlyInAnyOrderElementsOf(expect)
    }

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

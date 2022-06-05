package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoBoxTest {

    @Test
    fun `로또박스에서 값을 꺼내온다`() {
        val lottoBox = LottoBox()

        val lottoNum = lottoBox.getLottoNum(3)
        assertThat(lottoNum.num).isEqualTo(3)
    }

    @Test
    fun `로또 숫자를 중복으로 꺼낼 경우 에러`() {
        val lottoBox = LottoBox()

        lottoBox.getLottoNum(3)
        assertThrows<IllegalArgumentException> {
            lottoBox.getLottoNum(3)
        }
    }
}

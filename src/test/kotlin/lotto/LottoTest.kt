package lotto

import lotto.domain.Lotto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun `1) 로또를 구매하는 경우에 6개의 번호가 생성된다`() {
        Lotto.random()
        Assertions.assertThat(Lotto.random().lottoNumber.size).isEqualTo(6)
    }

    @Test
    fun `2) 구매한 로또가 5개로 이루어진 경우 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> { Lotto(listOf(5, 10, 15, 20, 25)) }
    }

    @Test
    fun `3) 구매한 로또가 중복된 번호가 있는 경우 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> { Lotto(listOf(5, 10, 15, 20, 25, 25)) }
    }

    @Test
    fun `4) 구매한 로또가 1 ~ 45 사이에 있지 않는 경우 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> { Lotto(listOf(5, 10, 15, 20, 25, 46)) }
    }

    @Test
    fun `5) 로또를 구매한 번호와 당첨 번호가 일치하는 경우 개수를 반환한다`() {
        val count = Lotto(listOf(5, 10, 15, 20, 25, 30)).getCountWithWinningLottoNumber(listOf(1, 2, 3, 4, 10, 15))
        Assertions.assertThat(count).isEqualTo(2)
    }
}

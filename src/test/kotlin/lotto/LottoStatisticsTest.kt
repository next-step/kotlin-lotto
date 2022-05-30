package lotto

import lotto.domain.Lotto
import lotto.domain.LottoMatch
import lotto.domain.LottoStatistics
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoStatisticsTest {

    @Test
    fun `1) 당첨번호를 5개, 7개를 입력한 경우 예외 발생`() {
        val lottoNumber = listOf(
            Lotto(listOf(3, 20, 4, 15, 44, 45))
        )
        assertThrows<IllegalArgumentException> { LottoStatistics(1000, lottoNumber, listOf(3, 20, 4, 15, 24)) }
        assertThrows<IllegalArgumentException> { LottoStatistics(1000, lottoNumber, listOf(3, 20, 4, 15, 24, 44, 45)) }
    }

    @Test
    fun `2) 수익률 계산하기(1,000원으로 5등 당첨인 경우 5,000원을 보상받기 때문에 5배`() {
        val lottoNumber = listOf(
            Lotto(listOf(3, 20, 4, 15, 11, 31))
        )
        Assertions.assertThat(LottoStatistics(1000, lottoNumber, listOf(3, 20, 4, 5, 2, 34)).earningRate).isEqualTo(5.0)
    }

    @Test
    fun `3) 카운트별 일치하는 로또 개수 계산하기`() {
        val lottoNumber = listOf(
            Lotto(listOf(3, 20, 1, 15, 11, 31))
        )
        Assertions.assertThat(LottoStatistics(1000, lottoNumber, listOf(3, 20, 1, 5, 2, 34)).resultMap[LottoMatch.THREE]).isEqualTo(1)
    }
}

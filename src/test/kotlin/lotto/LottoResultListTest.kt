package lotto

import lotto.domain.LottoRank
import lotto.domain.LottoResultList
import lotto.domain.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultListTest {
    @Test
    fun `로또 결과 리스트는 순위별 당첨 개수를 뽑아준다`() {
        val lottoResultList = LottoResultList(
            listOf(
                LottoRank.NONE,
                LottoRank.FOURTH,
                LottoRank.FOURTH,
                LottoRank.FOURTH,
                LottoRank.THIRD,
                LottoRank.SECOND,
                LottoRank.SECOND,
                LottoRank.FIRST,
                LottoRank.NONE
            )
        )

        assertThat(lottoResultList.count(LottoRank.FIRST)).isEqualTo(1)
        assertThat(lottoResultList.count(LottoRank.SECOND)).isEqualTo(2)
        assertThat(lottoResultList.count(LottoRank.THIRD)).isEqualTo(1)
        assertThat(lottoResultList.count(LottoRank.FOURTH)).isEqualTo(3)
    }

    @Test
    fun `로또 결과 리스트는 알맞은 수익률을 계산한다`() {
        val lottoResultListNone = LottoResultList(listOf(LottoRank.NONE))
        assertThat(lottoResultListNone.getProfitRate(Money(1000))).isEqualTo(0f)

        val lottoResultListFifth = LottoResultList(listOf(LottoRank.FIFTH))
        assertThat(lottoResultListFifth.getProfitRate(Money(1000))).isEqualTo(5f)

        val lottoResultListFourth = LottoResultList(listOf(LottoRank.FOURTH))
        assertThat(lottoResultListFourth.getProfitRate(Money(1000))).isEqualTo(50f)

        val lottoResultListThird = LottoResultList(listOf(LottoRank.THIRD))
        assertThat(lottoResultListThird.getProfitRate(Money(1000))).isEqualTo(1_500f)

        val lottoResultListSecond = LottoResultList(listOf(LottoRank.SECOND))
        assertThat(lottoResultListSecond.getProfitRate(Money(1000))).isEqualTo(30_000f)

        val lottoResultListFirst = LottoResultList(listOf(LottoRank.FIRST))
        assertThat(lottoResultListFirst.getProfitRate(Money(1000))).isEqualTo(2_000_000f)
    }
}

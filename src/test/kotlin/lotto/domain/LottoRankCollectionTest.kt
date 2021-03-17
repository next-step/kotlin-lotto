package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankCollectionTest {
    @Test
    fun `LottoRankCollection에는 6,5,4,3개 일치한 값의 갯수를 가지고 있어야 한다`() {
        val lottos: MutableMap<Rank, Int> = hashMapOf()
        lottos.put(Rank.FIRST, 1)
        lottos.put(Rank.THIRD, 3)
        lottos.put(Rank.FOURTH, 5)
        lottos.put(Rank.FIFTH, 10)

        val lottoRankCollection: LottoRankCollection = LottoRankCollection(lottos)

        assertThat(lottoRankCollection.sumAmount)
            .isEqualTo(
                Rank.FIRST.amount * 1 + Rank.THIRD.amount * 3 + Rank.FOURTH.amount * 5 + Rank.FIFTH.amount * 10
            )
    }
}

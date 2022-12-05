package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class LottoListTest {

    private val lottoGenerator: LottoGenerator = LottoManualGenerator()

    @Test
    fun `로또 리스트와 당첨 리스트를 비교하여 LottoLank리스트를 리턴한다`() {
        val previousWinningLotto =
            listOf(1, 2, 3, 4, 5, 6)
                .map { LottoNumber(it) }.toMutableSet()
                .let { Lotto(it) }

        val bonusLottoNumber = LottoNumber(7)
        val winningLotto = WinningLotto(previousWinningLotto, bonusLottoNumber)

        val lotto1 = Lotto(listOf(1, 2, 3, 7, 8, 29).map { LottoNumber(it) }.toMutableSet())
        val lotto2 = Lotto(listOf(1, 2, 3, 15, 21, 28).map { LottoNumber(it) }.toMutableSet())
        val lottoList = LottoList(listOf(lotto1, lotto2))

        val resultLottoRankList = lottoList.compare(winningLotto)
        resultLottoRankList.forEach { lottoRank ->
            assertThat(lottoRank).isEqualTo(LottoRank.FIFTH_PLACE)
        }
    }

    @Test
    fun `로또 리스트에서 로또 수량`() {
        val lottoCount = 4L
        val lottoList = LottoListGenerator.generateLottoList(lottoCount, lottoGenerator)

        val lottoCountResult = lottoList.count().toLong()

        assertThat(lottoCountResult).isEqualTo(lottoCount)
    }

    @Test
    fun `addLottoList()는 로또 리스트와 다른 로또 리스트를 추가하도록 한다`() {
        val lotto1 = LottoCustomGenerator.generateLotto("1,2,3,4,5,6")
        val lottoList1 = listOf(lotto1)

        val lotto2 = LottoCustomGenerator.generateLotto("2,3,4,5,6,7")
        val lottoList2 = listOf(lotto2)

        val addLottoList = LottoList(listOf(lotto1, lotto2))

        val resultLottoList = LottoList(lottoList1).addLottoList(LottoList(lottoList2))

        assertAll(
            "lottoList",
            { assertThat(resultLottoList.count()).isEqualTo(addLottoList.count()) },
            { assertThat(resultLottoList).isEqualTo(addLottoList) }
        )
    }
}

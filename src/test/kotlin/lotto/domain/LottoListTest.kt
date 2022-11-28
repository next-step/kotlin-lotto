package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoListTest {

    private val lottoGenerator: LottoGenerator = LottoManualGenerator()

    @Test
    fun compare() {
        val lottoNumbers = "1,2,3,4,5,6"
        val winningLotto = LottoCustomGenerator.generateLotto(lottoNumbers)
        val lottoNumber = 7
        val bonusLottoNumber = LottoNumber(lottoNumber)

        val lottoCount = 4L
        val lottoList = LottoListGenerator.generateLottoList(lottoCount, lottoGenerator)

        val lottoRankList = lottoList.compare(winningLotto, bonusLottoNumber)

        assertThat(lottoRankList.count().toLong()).isEqualTo(lottoCount)
        lottoRankList.forEach { lottoRank ->
            assertThat(lottoRank).isEqualTo(LottoRank.FIRST_PLACE)
        }
    }

    @Test
    fun `compare return MISS`() {
        val lottoNumbers = "4,5,9,10,11,12"
        val winningLotto = LottoCustomGenerator.generateLotto(lottoNumbers)
        val lottoNumber = 6
        val bonusLottoNumber = LottoNumber(lottoNumber)

        val lottoCount = 4L
        val lottoList = LottoListGenerator.generateLottoList(lottoCount, lottoGenerator)

        val lottoRankList = lottoList.compare(winningLotto, bonusLottoNumber)

        lottoRankList.forEach { lottoRank ->
            assertThat(lottoRank).isEqualTo(LottoRank.MISS)
        }
    }

    @Test
    fun count() {
        val lottoCount = 4L
        val lottoList = LottoListGenerator.generateLottoList(lottoCount, lottoGenerator)

        val lottoCountResult = lottoList.count().toLong()

        assertThat(lottoCountResult).isEqualTo(lottoCount)
    }

    @Test
    fun addLottoList() {
        val lotto1 = LottoCustomGenerator.generateLotto("1,2,3,4,5,6")
        val lottoList1 = listOf(lotto1)

        val lotto2 = LottoCustomGenerator.generateLotto("2,3,4,5,6,7")
        val lottoList2 = listOf(lotto2)

        val addLottoList = LottoList(listOf(lotto1, lotto2))

        val resultLottoList = LottoList(lottoList1).addLottoList(LottoList(lottoList2))

        assertThat(resultLottoList.count()).isEqualTo(addLottoList.count())
        assertThat(resultLottoList).isEqualTo(addLottoList)
    }
}

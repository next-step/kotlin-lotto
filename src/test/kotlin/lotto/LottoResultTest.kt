package lotto

import lotto.Fixtures.createSixLottoNumber
import lotto.model.Lotto
import lotto.model.LottoNumbers
import lotto.model.LottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `"같은 번호가 6개 일치하면 1등 로또가 당첨 된다`() {
        val lotto = Lotto(LottoNumbers(createSixLottoNumber(listOf(1, 2, 3, 4, 5, 6))))
        val winLottoNumbers = LottoNumbers(createSixLottoNumber(listOf(1, 2, 3, 4, 5, 6)))
        val result = LottoResult.of(listOf(lotto), winLottoNumbers)

        assertThat(result.lottoRankList.count { it?.matches == 6 }).isEqualTo(1)
    }

    @Test
    fun `같은 번호가 5개 일치하면 2등 로또가 당첨 된다`() {
        val lotto = Lotto(LottoNumbers(createSixLottoNumber(listOf(1, 2, 3, 4, 5, 6))))
        val winLottoNumbers = LottoNumbers(createSixLottoNumber(listOf(1, 2, 3, 4, 5, 10)))
        val result = LottoResult.of(listOf(lotto), winLottoNumbers)

        assertThat(result.lottoRankList.count { it?.matches == 5 }).isEqualTo(1)
    }
}

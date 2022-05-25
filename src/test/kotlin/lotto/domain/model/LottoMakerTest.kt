package lotto.domain.model

import lotto.domain.LottoMaker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class LottoMakerTest {
    private val lottoRange = LottoMaker.START_LOTTO_NUMBER..LottoMaker.END_LOTTO_NUMBER

    @RepeatedTest(100)
    fun `LottoMaker는 1부터 45 사이의 숫자로 이루어진 로또 번호들을 만든다`() {
        val lottoNumbers = LottoMaker.make()

        assertThat(lottoRange).containsAll(lottoNumbers)
    }

    @Test
    fun `LottoMaker가 만들어내는 로또는 6개의 숫자로 이루어진다`() {
        val lottoNumbers = LottoMaker.make()

        assertThat(lottoNumbers.size).isEqualTo(LottoMaker.LOTTO_NUMBER_COUNT)
    }
}

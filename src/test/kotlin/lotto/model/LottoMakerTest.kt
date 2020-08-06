package lotto.model

import lotto.model.LottoMaker.Companion.LOTTO_NUMBER_END
import lotto.model.LottoMaker.Companion.LOTTO_NUMBER_TOTAL_COUNT
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoMakerTest {
    private lateinit var maker: LottoMaker

    @BeforeEach
    fun beforeTest() {
        maker = LottoMaker()
    }

    @DisplayName(value = "생성한 로또가 조건과 일치하는지 확인한다.")
    @Test
    fun validLottoCheck() {
        val lotto = maker.make()

        assertThat(lotto.lottoNumbers.distinct().size).isSameAs(LOTTO_NUMBER_TOTAL_COUNT)
        assertThat(lotto.lottoNumbers).allSatisfy {
            assertThat(LottoNo.to(it)).isGreaterThan(0)
            assertThat(LottoNo.to(it)).isLessThanOrEqualTo(LOTTO_NUMBER_END)
        }
    }
}

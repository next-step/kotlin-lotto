package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoListGeneratorTest {
    @Test
    fun `generateLottoList는 LottoNumber를 6개를 가지고 있는 Lotto를 lottoCount만큼 생성한다`() {
        val lottoCount = 7L
        val lottoGenerator: LottoGenerator = LottoManualGenerator()
        val resultLottoList = LottoListGenerator.generateLottoList(lottoCount, lottoGenerator)

        assertThat(resultLottoList.count()).isEqualTo(lottoCount)
        resultLottoList.lottoList.forEach { lotto ->
            assertThat(lotto.numbers.count()).isEqualTo(6)
        }
    }
}

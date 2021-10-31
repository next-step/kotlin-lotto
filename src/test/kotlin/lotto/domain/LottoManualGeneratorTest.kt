package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoManualGeneratorTest {

    @Test
    fun `수동으로 입력받은 번호를 로또로 생성한다`() {
        val budget = Budget.valueOf(1000)
        val manualCount = 1
        val textLottos = listOf("1,2,3,4,5,6")

        val purchaseInformation = PurchaseInformation(budget, manualCount, textLottos)
        val lottoManualGenerator = LottoManualGenerator(purchaseInformation)

        assertThat(lottoManualGenerator.generateLottos()).hasSize(1)
    }
}

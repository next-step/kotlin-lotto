@file:Suppress("NonAsciiCharacters")

package lotto.service

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoIssueServiceTest {
    @Test
    fun `로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급한다`() {
        val purchaseAmount = 14000L

        val actual = LottoIssueService.issue(purchaseAmount)

        assertThat(actual).hasSize((purchaseAmount / Lotto.PRICE).toInt())
    }
}

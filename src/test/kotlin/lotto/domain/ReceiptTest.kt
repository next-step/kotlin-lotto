package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ReceiptTest {

    @CsvSource(
        value = [
            "10_000, 10",
            "14_000, 14",
            "100, 0",
            "1100, 1",
        ]
    )
    @ParameterizedTest
    fun `로또 구입금액으로 로또구매 개수를 리턴한다`(payment: Int, lottoCount: Int) {
        val receipt = Receipt(payment)
        assertThat(receipt.lottoCount).isEqualTo(lottoCount)
    }
}

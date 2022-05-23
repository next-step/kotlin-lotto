package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoStoreTest {

    @ParameterizedTest
    @CsvSource(value = ["15000:15", "14800:14", "23111:23"], delimiter = ':')
    fun `구매 갯수 확인`(input: Long, count: Long) {
        val ableToPurchaseCount = LottoStore(input).getAbleToPurchaseCount()
        assertThat(ableToPurchaseCount).isEqualTo(count)
    }
}


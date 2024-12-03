package lotto.core

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoPurchaseCountTest {
    @ParameterizedTest
    @CsvSource(
        "2, 1, 1",
        "4, 3, 1",
    )
    fun `자동 로또 구매 개수`(
        totalCount: Int,
        manualCount: Int,
        autoCount: Int,
    ) {
        LottoPurchaseCount(totalCount, manualCount).autoLottoCount() shouldBe autoCount
    }

    @ParameterizedTest
    @CsvSource(
        "1, 2",
       "-1, 1",
        "1, -1",
    )
    fun `로또 구매를 테스트한다`(
        totalCount: Int,
        manualCount: Int,
    ) {
        shouldThrow<IllegalArgumentException> {
            LottoPurchaseCount(totalCount, manualCount)
        }
    }
}

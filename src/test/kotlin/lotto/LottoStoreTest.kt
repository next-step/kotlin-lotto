package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import lotto.domain.LottoStore
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoStoreTest {

    private lateinit var lottoStore: LottoStore

    @BeforeEach
    fun setup() {
        lottoStore = LottoStore()
    }

    @ParameterizedTest
    @CsvSource(
        "100",
        "1001",
        "5050",
        "10101",
    )
    fun `로또 판매점은 로또 구입 금액이 1000원 미만 또는 1000원 단위가 아닐 경우 IllegalArgumentException 을 발생`(purchaseAmount: Int) {
        shouldThrow<IllegalArgumentException> {
            lottoStore.purchase(purchaseAmount)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "1000, 1",
        "2000, 2",
        "5000, 5",
        "25000, 25",
    )
    fun `로또 판매점은 (구매 금액 나누기 1000) 만큼 로또를 발급`(purchaseAmount: Int, expected: Int) {
        val lotteryTickets = lottoStore.purchase(purchaseAmount)

        lotteryTickets.size shouldBe expected
    }
}

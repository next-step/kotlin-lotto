package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.LotteryTicketsOrderRequest
import lotto.domain.LottoNumbers
import lotto.domain.LottoStore
import lotto.domain.PurchaseLotteryTicketResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

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
        val request = LotteryTicketsOrderRequest(purchaseAmount = purchaseAmount)

        when (val purchaseLotteryTicketResult = lottoStore.purchase(request)) {
            is PurchaseLotteryTicketResult.FAIL -> {
                assertThat(purchaseLotteryTicketResult.exception is IllegalArgumentException).isTrue
            }
            else -> fail { "check test..." }
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
        val request = LotteryTicketsOrderRequest(purchaseAmount = purchaseAmount)

        when (val purchaseLotteryTicketResult = lottoStore.purchase(request)) {
            is PurchaseLotteryTicketResult.SUCCESS -> {
                purchaseLotteryTicketResult.lotteryTickets.size shouldBe expected
            }
            else -> fail { "check test..." }
        }
    }

    @Test
    fun `로또 판매점은 구매 금액보다 수동 구매할 로또 구매 금액이 크다면 IllegalArgumentException 을 발생`() {
        val purchaseAmount = 1000
        val manualLottoNumbers = listOf(
            LottoTestHelper.makeLottoNumbers((1..6).toList()),
            LottoTestHelper.makeLottoNumbers((1..6).toList()),
        )
        val request = LotteryTicketsOrderRequest(purchaseAmount = purchaseAmount, manualLottoNumbers = manualLottoNumbers)

        when (val purchaseLotteryTicketResult = lottoStore.purchase(request)) {
            is PurchaseLotteryTicketResult.FAIL -> {
                assertThat(purchaseLotteryTicketResult.exception is IllegalArgumentException).isTrue
            }
            else -> fail { "check test..." }
        }
    }

    @ParameterizedTest
    @MethodSource("getAutoLotteryTicketsExclusiveManualLotteryTicketsTestData")
    fun `로또 판매점은 구매 금액에서 수동 구매한 로또를 제외한 만큼 자동으로 로또를 발급`(
        purchaseAmount: Int,
        manualLottoNumbers: List<LottoNumbers>,
        expectedAutoLotteryTicketCount: Int
    ) {
        val request = LotteryTicketsOrderRequest(purchaseAmount = purchaseAmount, manualLottoNumbers = manualLottoNumbers)

        when (val purchaseLotteryTicketResult = lottoStore.purchase(request)) {
            is PurchaseLotteryTicketResult.SUCCESS -> {
                purchaseLotteryTicketResult.autoLotteryTicketQuantity shouldBe expectedAutoLotteryTicketCount
            }
            else -> fail { "check test..." }
        }
    }

    companion object {
        @JvmStatic
        fun getAutoLotteryTicketsExclusiveManualLotteryTicketsTestData(): List<Arguments> =
            listOf(
                Arguments.of(
                    3000,
                    listOf(
                        LottoTestHelper.makeLottoNumbers((1..6).toList()),
                        LottoTestHelper.makeLottoNumbers((1..6).toList()),
                    ),
                    1
                ),
                Arguments.of(
                    2000,
                    listOf(
                        LottoTestHelper.makeLottoNumbers((1..6).toList()),
                        LottoTestHelper.makeLottoNumbers((1..6).toList()),
                    ),
                    0
                ),
                Arguments.of(
                    5000,
                    emptyList<LottoNumbers>(),
                    5
                ),
            )
    }
}

package lotto

import lotto.model.*
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoAutoAutoTest {
    private lateinit var lottoAutoController: LottoAutoController

    @BeforeEach
    fun setUp() {
        lottoAutoController = LottoAutoController()
    }

    @DisplayName("구입 금액은 양수여야 한다.")
    @ParameterizedTest(name = "{index} => input: ''{0}''")
    @CsvSource(
        "1000, 1",
        "2000, 2",
        "5000, 5",
        "10000, 10",
    )
    fun checkPurchaseAmount1(
        input: String,
        expectedCount: Int,
    ) {
        val lottos = lottoAutoController.buyLottos(input)
        assertThat(lottos.getLottos().size).isEqualTo(expectedCount)
    }

    @DisplayName("구입 금액이 0이거나 음수면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} => input: ''{0}''")
    @ValueSource(strings = ["0", "-1000"])
    fun checkPurchaseAmount2(input: String) {
        assertThatThrownBy { lottoAutoController.buyLottos(input) }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessage("금액은 양수입니다.")
    }

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} => input: ''{0}''")
    @ValueSource(strings = ["abc", "-1dd"])
    fun checkPurchaseAmount3(input: String) {
        assertThatThrownBy { lottoAutoController.buyLottos(input) }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessage("숫자로 입력하지 않았습니다.")
    }

    @DisplayName(value = "구매 개수는 1000원 단위로 계산한다.")
    @ParameterizedTest(name = "{index} => input: ''{0}'' expected: ''{1}''")
    @CsvSource(
        "1600, 1",
        "29100, 29",
        "11111, 11",
    )
    fun countPurchasedLotto(
        input: String,
        expected: Int,
    ) {
        val lottos = lottoAutoController.buyLottos(input)
        assertThat(lottos.getLottos().size).isEqualTo(expected)
    }

    @DisplayName(value = "로또 번호는 각기 다른 숫자로 이루어진 6개의 숫자가 오름차순으로 정렬되어야 한다.")
    @Test
    fun generateLottoNumbers() {
        val lotto = lottoAutoController.buyLottos("1000").getLottos().first()

        assertThat(lotto.getNumbers().size).isEqualTo(6)
        assertThat(lotto.getNumbers().map { it.num }).isSorted
    }

    @DisplayName("지난 주 당첨 번호는 6개의 숫자로 이루어져 있지 않다면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} => winningNumbersInput=''{0}'', purchasedLottoCount=''{1}''")
    @ValueSource(
        strings = [
            "1,2,3,4,5,6,7",
            "10,20,30,40,50,60,1,2,3",
            "7,14,21,28,35",
        ],
    )
    fun validWinningNumbers(winningNumbersInput: String) {
        assertThatThrownBy {
            lottoAutoController.matchLottoNumbers(
                winningNumbersInput,
                Lottos.fromCountInAuto(1),
            )
        }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessage("중복되지 않는 로또 번호 6개를 입력해주세요")
    }

    @Test
    @DisplayName("당첨금 계산은 일치하는 번호가 3개일 때부터다.")
    fun testMatchLottoNumbers() {
        val input = listOf(1, 2, 3, 4, 5, 6)
        val lottos =
            Lottos.from(
                listOf(
                    // 3개 일치
                    Lotto.from(listOf(1, 2, 3, 7, 8, 9)),
                    // 3개 일치
                    Lotto.from(listOf(4, 5, 6, 10, 11, 12)),
                    // 2개 일치
                    Lotto.from(listOf(1, 2, 7, 8, 9, 10)),
                    // 0개 일치
                    Lotto.from(listOf(13, 14, 15, 16, 17, 18)),
                ),
            )

        val matchResult = lottos.countMatchingLottoNumbers(Lotto.from(input))

        assertEquals(2, matchResult.findMatchCount(LottoPrize.THREE), "3개 일치하는 로또는 2개여야 합니다.")
    }

    @Test
    @DisplayName("수익률은 소수점 둘째 자리까지만 계산한다.")
    fun calculateRate() {
        val purchaseAmount = 3000 // 구매 금액
        val prizeAmount =
            listOf(LottoMatchResult(LottoPrize.THREE, 1), LottoMatchResult(LottoPrize.FOUR, 1), LottoMatchResult(LottoPrize.FIVE, 1))

        val returnRate = LottoMatchResults.from(prizeAmount).calculateReturnRate(purchaseAmount)

        assertEquals(68.33, returnRate, "수익률은 소수점 둘째 자리까지 계산되어야 합니다.")
    }
}

package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoAutoAutoTest {
    private lateinit var lottoAuto: LottoAuto

    @BeforeEach
    fun setUp() {
        lottoAuto = LottoAuto()
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
        val (purchaseAmount, purchasedLottoCount) = lottoAuto.purchaseLottos(input)
        assertThat(purchaseAmount).isGreaterThan(0)
        assertThat(purchasedLottoCount).isEqualTo(expectedCount)
    }

    @DisplayName("구입 금액이 0이거나 음수면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} => input: ''{0}''")
    @ValueSource(strings = ["0", "-1000"])
    fun checkPurchaseAmount2(input: String) {
        assertThatThrownBy { lottoAuto.purchaseLottos(input) }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessage("금액은 양수입니다.")
    }

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} => input: ''{0}''")
    @ValueSource(strings = ["abc", "-1dd"])
    fun checkPurchaseAmount3(input: String) {
        assertThatThrownBy { lottoAuto.purchaseLottos(input) }
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
        val (purchaseAmount, purchasedLottoCount) = lottoAuto.purchaseLottos(input)
        assertThat(purchasedLottoCount).isEqualTo(expected)
    }

    @DisplayName(value = "로또 번호는 각기 다른 숫자로 이루어진 6개의 숫자가 오름차순으로 정렬되어야 한다.")
    @Test
    fun generateLottoNumbers() {
        val lotto = lottoAuto.createLottos(1).first()

        assertThat(lotto.size).isEqualTo(6)
        assertThat(lotto).isSorted
    }

    @DisplayName("지난 주 당첨 번호는 6개의 숫자로 이루어져 있지 않다면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} => winningNumbersInput=''{0}'', purchasedLottoCount=''{1}''")
    @CsvSource(
        "1,2,3,4,5,6,7;1",
        "10,20,30,40,50,60,1,2,3;1",
        "7,14,21,28,35;1",
        delimiter = ';',
    )
    fun validWinningNumbers(
        winningNumbersInput: String,
        purchasedLottoCount: Int,
    ) {
        assertThatThrownBy { lottoAuto.matchLottoNumbers(winningNumbersInput, purchasedLottoCount) }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessage("당첨 번호는 6개의 숫자로 이루어져야 합니다.")
    }

    @DisplayName(value = "당첨금 계산은 일치하는 번호가 세 개일 때부터다.")
    @ParameterizedTest(name = "{index} => winningNumbersInput=''{0}'', purchasedLottoCount=''{1}''")
    @CsvSource(
        "1,2,7,8,9,10;1",
        delimiter = ';',
    )
    fun calculatePrizeMoney(
        winningNumbersInput: String,
        purchasedLottoCount: Int,
    ) {
        // Todo
//        assertThat(lottoAuto.matchLottoNumbers(winningNumbersInput, purchasedLottoCount))
    }

    @DisplayName(value = "제일 많이 일치하는 경우를 한 번만 계산한다. (6개 일치할 경우 5개는 카운팅하지 않는다.")
    fun verifyLottoNumbers() {
        // Todo
    }

    @DisplayName(value = "수익률은 소수점 둘째 자리까지만 계산한다.")
    fun calculateRate() {
        // Todo
    }
}

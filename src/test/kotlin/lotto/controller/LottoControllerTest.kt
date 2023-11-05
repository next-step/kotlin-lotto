package lotto.controller

import lotto.controller.LottoController.Companion.LOTTO_NUMBER_COUNT
import lotto.model.LottoInfo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class LottoControllerTest {

    @ParameterizedTest
    @ValueSource(strings = ["140", "-100", "abcde"])
    fun `로또 구매 금액 검증`(inputPurchaseAmount: String) {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            LottoController(inputPurchaseAmount).getValidatePurchaseAmount()
        }
    }

    @Test
    fun `생성한 로또 번호 검증`() {
        val lottoController = LottoController("14000")
        val generatedNumbers = lottoController.getRandomGeneratedNumbers()
        assertThat(generatedNumbers.toSet().size == LOTTO_NUMBER_COUNT)
    }

    @Test
    fun `구매한 금액만큼의 로또 개수`() {
        assertThat(LottoController("14000").getPaidLottoCount()).isEqualTo(14)
        assertThat(LottoController("1000").getPaidLottoCount()).isEqualTo(1)
    }

    @ParameterizedTest
    @MethodSource
    fun `일치한 번호 개수`(generatedLottoInfo: LottoInfo, latestWinLottoInfo: LottoInfo, expectedCorrections: Int) {
        assertThat(LottoController("1000").countCorrectNumberCount(generatedLottoInfo, latestWinLottoInfo)).isSameAs(
            expectedCorrections
        )
    }

    companion object {
        @JvmStatic
        fun `일치한 번호 개수`() = listOf(
            Arguments.of(LottoInfo(listOf(1, 2, 3, 4, 5, 6)), LottoInfo(listOf(1, 2, 3, 4, 5, 6)), 6),
            Arguments.of(LottoInfo(listOf(1, 2, 3, 4, 5, 6)), LottoInfo(listOf(1, 2, 3, 4, 5, 10)), 5),
            Arguments.of(LottoInfo(listOf(1, 2, 3, 4, 5, 6)), LottoInfo(listOf(1, 2, 3, 4, 50, 60)), 4),
            Arguments.of(LottoInfo(listOf(1, 2, 3, 4, 5, 6)), LottoInfo(listOf(10, 20, 30, 40, 50, 60)), 0),
        )
    }
}

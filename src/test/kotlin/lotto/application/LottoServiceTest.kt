package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoServiceTest {

    lateinit var lottoService: LottoService

    @BeforeEach
    fun setUp() {
        lottoService = LottoService()
    }

    @DisplayName("금액을 입력하면 구매할 수 있는 로또의 개수를 반환한다")
    @ParameterizedTest
    @CsvSource(
        value = [
            "1000:1",
            "10000:10",
            "1500:1",
            "500:0",
        ],
        delimiter = ':'
    )
    fun lottoCountShouldBeReturnByPaidPrice(price: Int, expected: Int) {
        // given

        // when
        val actual = lottoService.payPriceAndGetCount(price)

        // then
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("지불한 금액이 0원 이하일 경우 예외를 발생시킨다")
    @Test
    fun exceptionShouldBeThrowWhenPaidPriceIsLessThanZero() {
        // given
        val price = -1000

        // when & then
        Assertions.assertThatThrownBy { lottoService.payPriceAndGetCount(price) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("지불하는 금액은 0보다 커야합니다")
    }

    @DisplayName("로또를 구매한 갯수만큼 로또를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = [1, 10])
    fun generateTest(lottoCount: Int) {
        // given

        // when
        val lotto = lottoService.generate(lottoCount)

        // then
        Assertions.assertThat(lotto).hasSize(lottoCount)
    }

    @DisplayName("지불한 금액에 따라 로또를 반환한다")
    @Test
    fun buyTest() {
        // given
        val price = 10_000

        // when
        val lotto = lottoService.buy(price)

        // then
        Assertions.assertThat(lotto).hasSize(10)
    }

    @DisplayName("당첨번호와 구매한 로또를 비교하여 결과를 반환한다")
    @Test
    fun matchWinningLotto() {
        // given
        val userLottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
            Lotto(listOf(1, 2, 3, 4, 5, 7).map { LottoNumber(it) }),
            Lotto(listOf(1, 2, 3, 4, 7, 8).map { LottoNumber(it) }),
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val command = MatchWinningLottoCommand(userLottos, winningLotto)

        // when
        val result = lottoService.matchWinningLotto(command)

        // then
        Assertions.assertThat(result).hasSize(3)
        Assertions.assertThat(result).contains(
            LottoResult.MATCH_6_NUMBERS,
            LottoResult.MATCH_5_NUMBERS,
            LottoResult.MATCH_4_NUMBERS,
        )
    }

    @DisplayName("수익률을 계산한다")
    @Test
    fun calculateProfitRate() {
        // given
        val result = listOf(
            LottoResult.MATCH_3_NUMBERS,
            LottoResult.NONE,
            LottoResult.NONE,
            LottoResult.NONE,
            LottoResult.NONE,
            LottoResult.NONE,
            LottoResult.NONE,
            LottoResult.NONE,
            LottoResult.NONE,
            LottoResult.NONE,
        )

        // when
        val profitRate = lottoService.calculateProfitRate(result)

        // then
        Assertions.assertThat(profitRate).isEqualTo(0.5)
    }
}
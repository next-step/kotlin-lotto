package lotto.domain

import lotto.model.LottoNumber
import lotto.model.LottoNumbers
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoTicketTest {

    @ParameterizedTest
    @ValueSource(ints = [300, 400, 700, 800])
    fun `천원 미만 금액을 입력하면 예외가 발생한다`(purchaseAmount: Int) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { LottoTicket(purchaseAmount = purchaseAmount) }
            .withMessage("로또를 구매하려면 최소 1000원 이상의 금액이 필요합니다.")
    }

    @ParameterizedTest
    @ValueSource(ints = [1000, 1500, 2000, 3000, 4000])
    fun `천원 이상 금액을 입력하면 티켓이 생성된다`(purchaseAmount: Int) {
        val lottoTicket = LottoTicket(purchaseAmount = purchaseAmount)
        assertThat(lottoTicket).isNotNull
    }

    @Test
    fun `수동으로 구매할 로또 수가 구매 금액을 초과하면 예외가 발생한다`() {
        val purchaseAmount = 1000
        val manualLottoNumbers = listOf(
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)),
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber))
        )
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { LottoTicket(purchaseAmount = purchaseAmount, _manualLottoNumbers = manualLottoNumbers) }
            .withMessage("수동으로 구매할 로또 수가 구매 금액을 초과할 수 없습니다.")
    }

    @Test
    fun `수동으로 구매할 로또 수가 구매 금액을 초과하지 않으면 티켓이 생성된다`() {
        val purchaseAmount = 2000
        val manualLottoNumbers = listOf(
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)),
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber))
        )
        val lottoTicket = LottoTicket(purchaseAmount = purchaseAmount, _manualLottoNumbers = manualLottoNumbers)
        assertThat(lottoTicket).isNotNull
    }

    @Test
    fun `구매 금액만 입력된 로또 티켓은 자동 로또 번호 수량만 확인할 수 있다`() {
        val purchaseAmount = 4000
        val lottoTicket = LottoTicket(purchaseAmount)
        assertThat(lottoTicket.autoLottoNumbersSize).isEqualTo(4)
        assertThat(lottoTicket.manualLottoNumbersSize).isEqualTo(0)
    }

    @Test
    fun `입력한 수동 로또 번호 개수가 자동 생성 개수보다 적은 로또 티켓은 자동 로또 번호 수량이 수동 로또 번호 수량보다 많다`() {
        val purchaseAmount = 4000
        val manualLottoNumbers = listOf(LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)))
        val lottoTicket = LottoTicket(purchaseAmount, manualLottoNumbers)
        assertThat(lottoTicket.autoLottoNumbersSize).isEqualTo(3)
        assertThat(lottoTicket.manualLottoNumbersSize).isEqualTo(1)
    }

    @Test
    fun `입력한 수동 로또 번호 개수와 자동 생성 금액이 동일한 로또 티켓은 자동 로또 번호 수량과 수동 로또 번호 수량이 일치한다`() {
        val purchaseAmount = 4000
        val manualLottoNumbers = listOf(
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)),
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)),
        )
        val lottoTicket = LottoTicket(purchaseAmount, manualLottoNumbers)
        assertThat(lottoTicket.autoLottoNumbersSize).isEqualTo(2)
        assertThat(lottoTicket.manualLottoNumbersSize).isEqualTo(2)
    }

    @Test
    fun `입력한 수동 로또 번호 개수가 자동 생성 개수보다 많은 로또 티켓은 수동 로또 번호 수량이 자동 로또 번호 수량보다 많다`() {
        val purchaseAmount = 4000
        val manualLottoNumbers = listOf(
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)),
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)),
            LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)),
        )
        val lottoTicket = LottoTicket(purchaseAmount, manualLottoNumbers)
        assertThat(lottoTicket.autoLottoNumbersSize).isEqualTo(1)
        assertThat(lottoTicket.manualLottoNumbersSize).isEqualTo(3)
    }
}

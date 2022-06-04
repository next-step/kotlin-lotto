package lotto.domin

import lotto.dto.InputLottoMachineRequestDto
import lotto.util.LottoNumberGenerator

class LottoMachine(
    dto: InputLottoMachineRequestDto,
    lottoNumberGenerator: LottoNumberGenerator,
) {

    private val inputPayment: Int = dto.payment
    private val lotto: Lotto = Lotto(inputPayment, lottoNumberGenerator)

    val inputManualLottoCount: Int = dto.manualLotto.size
    val issuanceLottoCount: Int = lotto.issuanceCount()

    init {
        require(inputPayment >= Lotto.LOTTO_PRICE) { INVALID_PAYMENT }
        require(inputPayment.rem(Lotto.LOTTO_PRICE) == 0) { CANNOT_ISSUANCE_LOTTO }
        require(issuanceLottoCount > inputManualLottoCount) { EXCEED_PAYMENT }
    }

    val lottoRecord: List<LottoNumberSet> = dto.manualLotto + randomLottoNumber()

    private fun randomLottoNumber() = List(issuanceLottoCount - inputManualLottoCount) {
        LottoNumberSet(lotto.issuance())
    }

    companion object {
        const val INVALID_PAYMENT = "지불 금액이 1000원 이상이여야한다."
        const val CANNOT_ISSUANCE_LOTTO = "지불 금액이 맞지 않아 로또로 바꿔드릴 수 없습니다."
        const val EXCEED_PAYMENT = "수동 구매 로또 수가 지불 금액을 초과하였습니다."
    }
}

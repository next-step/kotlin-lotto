package lotto.domin

import lotto.dto.InputPaymentRequestDto
import lotto.util.LottoNumberGenerator

class LottoMachine(
    dto: InputPaymentRequestDto,
    lottoNumberGenerator: LottoNumberGenerator,
) {
    private val inputPayment: Int = dto.payment
    private val lotto: Lotto = Lotto(inputPayment, lottoNumberGenerator)

    private val _lottoRecord: MutableList<LottoNumberSet> = mutableListOf()
    val lottoRecord: List<LottoNumberSet> get() = _lottoRecord

    private var _issuanceLottoCount: Int = 0
    val issuanceLottoCount: Int get() = _issuanceLottoCount

    init {
        require(inputPayment >= Lotto.LOTTO_PRICE) { INVALID_PAYMENT }
        val remPayment = inputPayment.rem(Lotto.LOTTO_PRICE)
        require(remPayment == 0) { CANNOT_ISSUANCE_LOTTO }
    }

    fun sellLotto() {
        _issuanceLottoCount = lotto.issuanceCount()
        repeat(_issuanceLottoCount) {
            this._lottoRecord.add(
                LottoNumberSet(lotto.issuance())
            )
        }
    }

    companion object {
        const val INVALID_PAYMENT = "지불 금액이 1000원 이상이여야한다."
        const val CANNOT_ISSUANCE_LOTTO = "지불 금액이 맞지 않아 로또로 바꿔드릴 수 없습니다."
    }
}

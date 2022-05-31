package lotto.domin

import lotto.dto.InputLottoMachineRequestDto
import lotto.util.LottoNumberGenerator

class LottoMachine(
    dto: InputLottoMachineRequestDto,
    lottoNumberGenerator: LottoNumberGenerator,
) {
    private val inputPayment: Int = dto.payment
    private val inputManualLottoCount: Int = dto.manualLottoCount
    private val lotto: Lotto = Lotto(inputPayment, lottoNumberGenerator)

    private val _lottoRecord: MutableList<LottoNumberSet> = mutableListOf()
    val lottoRecord: List<LottoNumberSet> get() = _lottoRecord.toList()

    var issuanceLottoCount: Int = 0
        private set

    init {
        require(inputPayment >= Lotto.LOTTO_PRICE) { INVALID_PAYMENT }
        require(inputPayment.rem(Lotto.LOTTO_PRICE) == 0) { CANNOT_ISSUANCE_LOTTO }
    }

    fun sellLotto() {
        issuanceLottoCount = lotto.issuanceCount()

        repeat(issuanceLottoCount) {
            _lottoRecord.add(
                LottoNumberSet(lotto.issuance())
            )
        }
    }

    companion object {
        const val INVALID_PAYMENT = "지불 금액이 1000원 이상이여야한다."
        const val CANNOT_ISSUANCE_LOTTO = "지불 금액이 맞지 않아 로또로 바꿔드릴 수 없습니다."
    }
}

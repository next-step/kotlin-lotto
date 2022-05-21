package lotto

class LottoMachine(
    dto: InputPaymentRequestDto,
    private val lottoNumberGenerator: LottoNumberGenerator,
) {
    private val inputPayment: Int = dto.payment

    init {
        require(inputPayment >= Lotto.LOTTO_PRICE) { INVALID_PAYMENT }
        val remPayment = inputPayment.rem(Lotto.LOTTO_PRICE)
        require(remPayment == 0) { CANNOT_ISSUANCE_LOTTO }
    }

    private val lotto: Lotto = Lotto(inputPayment, lottoNumberGenerator)

    private val _lottoRecord: MutableList<LottoGenerator> = mutableListOf()
    val lottoRecord: List<LottoGenerator> get() = _lottoRecord

    fun sellLotto() {
        val issuanceLottoCount = lotto.issuanceCount()
        repeat(issuanceLottoCount) {
            this._lottoRecord.add(
                LottoGenerator(lotto.issuance())
            )
        }
    }

    companion object {
        const val INVALID_PAYMENT = "지불 금액이 1000원 이상이여야한다."
        const val CANNOT_ISSUANCE_LOTTO = "지불 금액이 맞지 않아 로또로 바꿔드릴 수 없습니다."
    }
}

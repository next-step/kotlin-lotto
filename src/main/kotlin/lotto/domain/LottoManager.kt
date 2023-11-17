package lotto.domain

class LottoManager(val purchased: Int, private val manualCount: Int) {
    private val lottoCount: Int
    lateinit var prizes: List<Prize>
        private set
    lateinit var lottos: Lottos
        private set

    init {
        validatePurchasedMoney()
        lottoCount = purchased / LOTTO_PRICE

        validateManualCount()
    }

    private fun validatePurchasedMoney() {
        require(purchased > 0) { "구입 금액은 양의 정수여야 합니다." }
        require(purchased % LOTTO_PRICE == 0) { "구입 금액은 1000원 단위여야 합니다." }
    }

    private fun validateManualCount() {
        require(manualCount >= 0) { "수동 구매 수는 0 이상의 정수여야 합니다." }
        require(manualCount <= lottoCount) { "구매 가능 로또 수를 넘었습니다." }
    }

    fun setLottos(manuals: List<Lotto> = emptyList()) {
        val auto = Lottos.generateLottoList(lottoCount - manualCount)
        lottos = Lottos(auto + manuals)
    }

    fun validateBonusNumber(winningLotto: Lotto, bonus: LottoNumber) {
        require(!winningLotto.numbers.contains(bonus)) { "보너스 번호는 당첨 번호와 중복될 수 없습니다." }
    }

    fun aggregate(winningLotto: Lotto, bonusNumber: LottoNumber) {
        check(this::lottos.isInitialized) { "발급된 로또가 없습니다" }

        prizes = lottos.getResult(winningLotto, bonusNumber)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}

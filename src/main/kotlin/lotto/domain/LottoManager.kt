package lotto.domain

class LottoManager(val purchased: Int, private val manualCount: Int) {
    private val lottoCount: Int
    private lateinit var winningLotto: Lotto
    private var bonusNumber: LottoNumber? = null
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
        lottos = Lottos.createWithMaunals(lottoCount, manuals)
    }

    fun setWinningLotto(lotto: Lotto) {
        winningLotto = lotto
    }

    fun setBonusNumber(input: LottoNumber) {
        validateBonusNumber(input)
        bonusNumber = input
    }

    private fun validateBonusNumber(num: LottoNumber) {
        require(!winningLotto.numbers.contains(num)) { "보너스 번호는 당첨 번호와 중복될 수 없습니다." }
    }

    fun aggregate() {
        check(this::lottos.isInitialized) { "발급된 로또가 없습니다" }
        check(this::winningLotto.isInitialized) { "당첨번호가 설정되지 않았습니다" }
        check(bonusNumber != null) { "보너스 번호가 설정되지 않았습니다" }

        prizes = lottos.getResult(winningLotto, bonusNumber!!)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}

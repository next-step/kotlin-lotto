package lotto.domain

class LottoManager(val purchased: Int) {
    private lateinit var winningNumbers: Lotto
    private var bonusNumber: Int = -1
    lateinit var prizes: List<Prize>
        private set
    lateinit var lottos: Lottos
        private set

    init {
        validatePurchasedMoney(purchased)
    }

    private fun validatePurchasedMoney(input: Int) {
        require(input > 0) { "구입 금액은 양의 정수여야 합니다." }
        require(input % LOTTO_PRICE == 0) { "구입 금액은 1000원 단위여야 합니다." }
    }

    fun generateLottos() {
        lottos = Lottos(purchased / LOTTO_PRICE)
    }

    fun setWinningNumbers(numbers: Lotto) {
        winningNumbers = numbers
    }

    fun setBonusNumber(input: Int) {
        validateBonusNumber(input)
        bonusNumber = input
    }

    private fun validateBonusNumber(num: Int) {
        require(num in 1..45) { "보너스 번호는 1~45 사이의 숫자여야 합니다." }
        require(num !in winningNumbers.numbers) { "보너스 번호는 당첨 번호와 중복될 수 없습니다." }
    }

    fun aggregate() {
        check(this::lottos.isInitialized) { "발급된 로또가 없습니다" }
        check(this::winningNumbers.isInitialized) { "당첨번호가 설정되지 않았습니다" }
        check(bonusNumber > 0) { "보너스 번호가 설정되지 않았습니다" }

        prizes = Prize.getResult(lottos, winningNumbers, bonusNumber)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}

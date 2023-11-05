package lotto

import lotto.util.Prize

class LottoManager(val purchased: Int) {
    val lottoAmount = purchased / LOTTO_PRICE
    private lateinit var winningNumbers: Lotto
    lateinit var lottos: Lottos
        private set

    init {
        validateInput(purchased)
    }

    private fun validateInput(input: Int) {
        require(input > 0) { "구입 금액은 양의 정수여야 합니다." }
        require(input % LOTTO_PRICE == 0) { "구입 금액은 1000원 단위여야 합니다." }
    }

    fun generateLottos() {
        lottos = Lottos(lottoAmount)
    }

    fun setWinningNumbers(numbers: Lotto) {
        winningNumbers = numbers
    }

    fun getResult(): List<Prize> {
        check(this::lottos.isInitialized && this::winningNumbers.isInitialized) {
            "로또 발급 및 당첨 번호 입력이 선행되어야 합니다"
        }

        return Prize.getResult(lottos, winningNumbers)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}

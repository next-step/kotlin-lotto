package lotto

import lotto.util.Prize

class LottoManager(val purchased: Int) {
    private val lottoList: MutableList<Lotto> = mutableListOf()
    private lateinit var winningNumbers: Lotto

    init {
        validateInput(purchased)
    }

    private fun validateInput(input: Int) {
        require(input > 0) { "구입 금액은 양의 정수여야 합니다." }
        require(input % LOTTO_PRICE == 0) { "구입 금액은 1000원 단위여야 합니다." }
    }

    fun generateLotto() {
        lottoList.clear()

        repeat(this.purchased / LOTTO_PRICE) {
            lottoList.add(Lotto())
        }
    }

    fun getLottoList(): List<Lotto> {
        return lottoList
    }

    fun setWinningNumbers(numbers: Lotto) {
        winningNumbers = numbers
    }

    fun getResult(): List<Prize> {
        check(lottoList.isNotEmpty() && winningNumbers.isNotEmpty()) { "로또 발급 및 당첨 번호 입력이 선행되어야 합니다" }

        return Prize.getResult(lottoList, winningNumbers)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}

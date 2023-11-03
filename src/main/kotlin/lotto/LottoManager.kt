package lotto

import lotto.util.Prize
import lotto.util.StringHandler

class LottoManager(val purchased: Int) {
    private val lottoList: MutableList<List<Int>> = mutableListOf()
    private val winningNumbers: MutableList<Int> = mutableListOf()

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
            lottoList.add(
                (MIN_NUMBER..MAX_NUMBER).shuffled().take(NUMBER_NUM).sorted()
            )
        }
    }

    fun getLottoList(): List<List<Int>> {
        return lottoList
    }

    fun setWinningNumbers(numbers: String) {
        val numbers = StringHandler().tokenizeWinningNumbers(numbers)
        require(numbers.size == NUMBER_NUM) { "당첨 번호는 ${NUMBER_NUM}개의 숫자여야 합니다." }

        winningNumbers.addAll(numbers)
    }

    fun getResult(): List<Prize> {
        check(lottoList.isNotEmpty() && winningNumbers.isNotEmpty()) { "로또 발급 및 당첨 번호 입력이 선행되어야 합니다" }

        return Prize.getResult(lottoList, winningNumbers)
    }

    companion object {
        const val LOTTO_PRICE = 1000
        const val NUMBER_NUM = 6
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }
}

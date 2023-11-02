package lotto

import lotto.util.StringHandler

class LottoManager(purchased: String) {
    val purchased: Int
    private val lottoList: MutableList<List<Int>> = mutableListOf()
    private val winningNumbers: MutableList<Int> = mutableListOf()

    init {
        validateInput(purchased)
        this.purchased = purchased.toInt()

        repeat(this.purchased / LOTTO_PRICE) {
            lottoList.add(generateLotto())
        }
    }

    private fun validateInput(input: String) {
        StringHandler().checkNonNumExists(input)
        require(input.toInt() > 0) { "구입 금액은 양의 정수여야 합니다." }
        require(input.toInt() % LOTTO_PRICE == 0) { "구입 금액은 1000원 단위여야 합니다." }
    }

    private fun generateLotto(): List<Int> {
        return (MIN_NUMBER..MAX_NUMBER).shuffled().take(NUMBER_NUM).sorted()
    }

    fun getLottoList(): List<List<Int>> {
        return lottoList
    }

    fun setWinningNumbers(numbers: String) {
        val numbers = StringHandler().tokenizeWinningNumbers(numbers)
        require(numbers.size == NUMBER_NUM) { "당첨 번호는 ${NUMBER_NUM}개의 숫자여야 합니다." }

        winningNumbers.addAll(numbers)
    }

    companion object {
        const val LOTTO_PRICE = 1000
        const val NUMBER_NUM = 6
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }
}

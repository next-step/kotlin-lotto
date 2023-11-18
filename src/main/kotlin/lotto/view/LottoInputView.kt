package lotto.view

class LottoInputView {
    fun getPurchasePrice(): String? {
        return getInput("구입 금액을 입력해주세요.")
    }

    fun getWinningNumbers(): String? {
        return getInput("지난 주 당첨 번호를 입력해 주세요.")
    }

    private fun getInput(message: String): String? {
        println(message)

        return readlnOrNull()
    }

    fun printPurchasedLottoNumbers(lottoNumbers: List<List<Int>>) {
        println("${lottoNumbers.size}개의 로또를 구매했습니다.")
        lottoNumbers.forEach { printLottoNumbers(it) }
        println()
    }

    private fun printLottoNumbers(lottoNumbers: List<Int>) {
        val message = lottoNumbers.joinToString(LOTTO_NUMBERS_DELIMITER)

        println(message)
    }

    companion object {
        private const val LOTTO_NUMBERS_DELIMITER = ", "
    }
}

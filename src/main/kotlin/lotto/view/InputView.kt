package lotto.view

class InputView {

    fun inputPurchaseAmount(): Int {
        println(INPUT_PURCHASE_AMOUNT_MESSAGE)
        val input = readLine() ?: DEFAULT_PURCHASE_AMOUNT

        return input.toInt()
    }

    fun inputPassivityCount(): Int {
        println(INPUT_PASSIVITY_COUNT)
        val passivityCount = readLine() ?: DEFAULT_PASSIVITY_COUNT

        return passivityCount.toInt()
    }

    fun inputWinningNumber(): String {
        println(INPUT_WINNING_NUMBERS)
        return readLine() ?: DEFAULT_WINNING_NUMBERS
    }

    fun inputPassivityLottoNumbers(passivityCount: Int): List<String> {
        println(INPUT_PASSIVITY_NUMBER)
        val lottoNumbers = mutableListOf<String>()

        repeat(passivityCount) {
            val passivityLottoNumber = readLine() ?: DEFAULT_LOTTO_NUMBERS

            lottoNumbers.add(passivityLottoNumber)
        }

        return lottoNumbers.toList()
    }

    fun inputBonusNumber(): Int {
        println(INPUT_BONUS_NUMBER)
        val bonusNumber = readLine() ?: DEFAULT_BONUS_NUMBER

        return bonusNumber.toInt()
    }

    companion object {
        private const val INPUT_PURCHASE_AMOUNT_MESSAGE = "구매금액을 입력해주세요."
        private const val INPUT_PASSIVITY_COUNT = "수동으로 구매할 로또 수를 입력해 주세요."
        private const val INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER = "보너스 번호를 입력해주세요."
        private const val INPUT_PASSIVITY_NUMBER = "수동으로 구매할 번호를 입력해 주세요."
        private const val DEFAULT_PURCHASE_AMOUNT = "0"
        private const val DEFAULT_WINNING_NUMBERS = "0,0,0,0,0,0"
        private const val DEFAULT_LOTTO_NUMBERS = "1,2,3,4,5,6"
        private const val DEFAULT_BONUS_NUMBER = "0"
        private const val DEFAULT_PASSIVITY_COUNT = "0"
    }
}

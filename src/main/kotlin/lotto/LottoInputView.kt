package lotto

object LottoInputView {
    fun inputPurchaseLottoAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val inputMoney: String = readln()
        require(inputMoney.isNotBlank()) { "구매금액 입력은 빈 값이나 공백이 될 수 없습니다." }
        return inputMoney.toIntOrNull() ?: throw IllegalArgumentException("로또 구매 금액은 정수를 입력해야합니다.")
    }

    fun inputWinningLottoNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val inputWinningNumbers = readln()
        return inputWinningNumbers.split(", ").toList()
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("") }
    }
}

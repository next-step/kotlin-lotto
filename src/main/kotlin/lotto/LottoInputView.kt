package lotto

class LottoInputView {

    val purchaseAmount: Int by lazy {
        println("구입금액을 입력해 주세요.")
        readln().toIntOrNull() ?: 0
    }

    val lastWeekWinLottoNumber: WinningLottoNumber by lazy {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input = readln()
        val numbers = input.split(",").asSequence()
            .map { it.trim().toIntOrNull() ?: 0 }
            .sorted()
            .toList()
        WinningLottoNumber(LottoNumber(numbers))
    }
}

package lotto.view

class InputView {
    fun inputSeedMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputWinningNumbers(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(", ").map { it.toInt() }.toSet()
    }
}

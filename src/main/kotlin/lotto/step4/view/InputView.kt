package lotto.step4.view

import lotto.step4.domain.LottoNumber

object InputView {
    fun getPurchaseAmount(): Long {
        println("구입금액을 입력해 주세요.")
        val money = readln().toLong()
        return money
    }

    fun getLastWeekWinningNumbers(): Set<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = readln().split(",").map { it.trim().toInt() }.toSet()
        require(winningNumbers.size == 6) { "로또 당첨 번호는 중복되지 않고, 6개여야 합니다. [winningNumbers=$winningNumbers]" }
        return winningNumbers.map { LottoNumber(it) }.toSet()
    }

    fun getBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        return LottoNumber(readln().toInt())
    }

    fun getManualPurchaseCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun getManualPurchaseNumbers(count: Int): List<Set<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..count).map {
            val numbers = readln().split(",").map { it.trim().toInt() }.toSet()
//            require(numbers.size == 6) { "로또 번호는 중복되지 않고, 6개여야 합니다. [numbers=$numbers]" }
            numbers
        }
    }
}

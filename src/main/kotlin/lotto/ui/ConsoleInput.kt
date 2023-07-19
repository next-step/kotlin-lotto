package lotto.ui

import lotto.util.Splitter

class ConsoleInput(
    private val splitter: Splitter = Splitter()
) : LottoGameInput {
    override fun money(): Int {
        println("구입 금액을 입력해 주세요.")
        return readln().toInt()
    }

    override fun manualLottos(): List<List<Int>> {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val countOfManualLotto = readln().toInt()
        println("수동으로 구매할 번호를 입력해 주세요.")
        val manualLottoStrs = List(countOfManualLotto) { readln() }
        return manualLottoStrs.map { splitter.toNumbers(it) }
    }

    override fun numbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = readln()
        return splitter.toNumbers(winningNumbers)
    }

    override fun bonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }
}

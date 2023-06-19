package com.nextstep.second.lotto.view

object InputView {
    fun getMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun getManualLottoNumber(total: Int): List<List<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..total).map { readLineForLotto() }
    }

    fun getWinnerNumber(): List<Int> {
        println("지난 추 당첨 번호를 입력해주세요.")
        return readLineForLotto()
    }

    private fun readLineForLotto(): List<Int> {
        return readln().split(", ").map { it.toInt() }
    }

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }
}

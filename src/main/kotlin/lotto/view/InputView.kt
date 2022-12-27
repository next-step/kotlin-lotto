package lotto.view

import lotto.domain.LottoNumber

object InputView {
    fun getPurchaseAmount(): Int {
        println("구매금액을 입력해 주세요.")
        val amount = readln()
        require(amount.isNotEmpty()) { "금액을 입력해주세요." }

        return amount.toInt()
    }

    fun getNumberOfPurchases(count: Int) {
        println("$count 개를 구매했습니다.")
    }

    fun getWinningBalls(): Pair<Set<LottoNumber>, LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumber = readln()
        require(winningNumber.isNotEmpty()) { "당첨 번호를 입력해주세요." }

        val winningBalls = winningNumber.split(", ").map { LottoNumber(it.toInt()) }.toSet()
        require(winningBalls.size == 6) { " 중복없는 6개의 숫자를 입력해주세요." }

        println("보너스 볼을 입력해 주세요.")
        val bonusBall = LottoNumber(readln().toInt())
        require(!winningBalls.contains(bonusBall)) { "보너스 볼은 당첨 번호와 중복될 수 없습니다." }

        return winningBalls to bonusBall
    }
}

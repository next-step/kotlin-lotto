package lotto.ui

import lotto.domain.Lotto

object LottoMatchingView {
    fun match(lottoList: List<Lotto>): Map<Int, Int> {
        val winningLotto = inputWinningLotto()
        return lottoList
            .map { it.match(winningLotto) }
            .groupingBy { it.size }.eachCount()
    }

    private fun inputWinningLotto(): Lotto {
        return Lotto(inputWinningNumber())
    }

    private fun inputWinningNumber(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readLine()!!.split(",")
            .map {
                it.trim().toIntOrNull()
                    ?.takeIf { number -> number in 1..45 }
                    ?: throw IllegalArgumentException()
            }
        require(numbers.size == 6) { "당첨번호 입력이 잘못 되었습니다." }
        return numbers
    }
}

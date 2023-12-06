package camp.nextstep.edu.step.step2.domain.lotto

data class WinningLotto(
    val winningLotto: Lotto,
) {

    init {
        require(winningLotto.numbers.isNotEmpty()) { "당첨번호가 입력되지 않았습니다." }
    }

}

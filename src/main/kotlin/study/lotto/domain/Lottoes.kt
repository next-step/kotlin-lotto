package study.lotto.domain

class Lottoes(private val list: List<Lotto>) : List<Lotto> by list {
    fun getPrizes(winningLotto: Lotto, bonusNumber: LottoNumber) = list.map {
        it.getPrizeGrade(winningLotto, bonusNumber)
    }
}

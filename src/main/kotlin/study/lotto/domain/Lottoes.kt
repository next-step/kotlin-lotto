package study.lotto.domain

class Lottoes(private val list: List<Lotto>) : List<Lotto> by list {
    fun countMatches(winningLotto: Lotto) = list.map { it.countMatches(winningLotto) }

    companion object {
        fun generateLottoes(numberOfLottoes: Int): Lottoes {
            val lottoList = (1..numberOfLottoes).map { Lotto.generate() }
            return Lottoes(lottoList)
        }
    }
}

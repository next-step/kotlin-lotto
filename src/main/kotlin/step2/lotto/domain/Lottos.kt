package step2.lotto.domain

class Lottos private constructor(val elements: List<Lotto>) {
    fun match(winningNumber: WinningNumber): PlayResults {
        val playResults = PlayResults()
        elements.map {
            val matchResult = it.match(winningNumber)
            playResults.add(it, matchResult)
        }
        return playResults
    }

    companion object {
        fun of(lottos: List<Lotto>): Lottos {
            return Lottos(lottos)
        }
    }
}

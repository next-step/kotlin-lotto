package step2.lotto.domain

class Lottos private constructor(private val elements: List<Lotto>) {
    fun match(winningNumber: WinningNumber): MatchResults {
        val matchResults = MatchResults()
        elements.map {
            val matchResult = it.match(winningNumber)
            matchResults.add(matchResult)
        }
        return matchResults
    }
    
    companion object {
        fun of(lottos: List<Lotto>): Lottos {
            return Lottos(lottos)
        }
    }
}

package lotto.model.data

data class Lotto private constructor(val numbers: Set<Int>) {
    fun countOfMatchNumber(other: Lotto) =
        this.numbers.filter(other.numbers::contains).size

    companion object {
        fun Collection<Int>.toLotto() = Lotto(this.sorted().toSet())
    }
}

data class Lottos(val lottoList: List<Lotto>)

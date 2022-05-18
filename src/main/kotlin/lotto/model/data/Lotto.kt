package lotto.model.data

data class Lotto(val numbers: Set<Int>) {

    fun countOfMatchNumber(other: Lotto) =
        this.numbers.filter(other.numbers::contains).size
}

data class Lottos(val lottoList: List<Lotto>)

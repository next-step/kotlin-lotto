package lotto.model.data

import lotto.util.toBlankRemovedIntList

data class Lotto private constructor(val numbers: Set<Int>) {

    fun countOfMatchNumber(other: Lotto) =
        this.numbers.filter(other.numbers::contains).size

    companion object {
        fun Collection<Int>.toLotto(policy: Policy): Lotto {
            policy.validateNumbers(this)
            return Lotto(this.sorted().toSet())
        }

        fun String.toLotto(policy: Policy): Lotto {
            val numbers = this.toBlankRemovedIntList()
            return numbers.toLotto(policy)
        }
    }
}

data class Lottos(val lottoList: List<Lotto>) : List<Lotto> by lottoList

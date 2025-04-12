package lotto.domain

class Lottos(_values: List<Lotto>) {
    var values: List<Lotto> = _values
        private set

    val size: Int
        get() = values.size

    fun compareAllTo(lotto: Lotto) = values.associateWith { it.compareMatches(lotto) }

    infix operator fun plus(other: Lottos): Lottos {
        this.values += other.values
        return this
    }
}

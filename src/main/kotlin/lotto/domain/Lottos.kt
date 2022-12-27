package lotto.domain

@JvmInline
value class Lottos constructor(val elements: List<Lotto>) {
    operator fun plus(other: Lottos) = Lottos(elements + other.elements)

    fun match(winningLotto: WinningLotto): List<Rank> {
        return elements.map { winningLotto.match(it) }
    }
}

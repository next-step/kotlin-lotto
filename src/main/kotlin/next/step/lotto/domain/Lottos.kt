package next.step.lotto.domain

@JvmInline
value class Lottos(val lottos: Set<Lotto>) {

    fun size(): Int = lottos.size

    fun numbers(): Set<Set<Int>> = lottos.map { it.numbers().toSet() }.toSet()

    companion object {
        fun of(lottos: Set<Lotto>): Lottos = Lottos(lottos)
    }

}
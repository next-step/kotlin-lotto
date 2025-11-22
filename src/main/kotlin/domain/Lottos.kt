package domain

class Lottos(val lottos: MutableSet<Lotto> = mutableSetOf()) {
    fun addLotto(lotto: Set<Int>) {
        this.lottos.add(Lotto(lotto))
    }
}

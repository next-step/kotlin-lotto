package domain

class Lottos(val lottos: MutableSet<Set<Int>> = mutableSetOf()) {
    fun addLotto(lotto: Set<Int>) {
        this.lottos.add(lotto)
    }
}

package domain

class Lottos(val lottos: MutableList<List<Int>> = mutableListOf()) {

    fun addLotto(lotto: List<Int>) {
        this.lottos.add(lotto)
    }
}

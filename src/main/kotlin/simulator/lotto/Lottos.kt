package simulator.lotto

data class Lottos(val values: List<Lotto>) {
    fun matches(winningLotto: Lotto): List<Int> {
        return values.map { it.match(winningLotto) }
    }
}
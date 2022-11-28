package simulator.lotto

data class Lottos(val values: List<Lotto>) {
    fun ranks(winningLotto: Lotto, bonusNumber: Int): Ranks {
        return Ranks(values.map { it.rank(winningLotto, bonusNumber) })
    }
}
package lotto

class Lottos(private val amountOfLotto: Int) {
    val lottos = (0 until amountOfLotto).map { Lotto() }
}

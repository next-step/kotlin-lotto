package lotto

object LottoFactory {
    fun create() = Lotto(numbers = (1..45).shuffled().subList(0, 6).sorted())
}

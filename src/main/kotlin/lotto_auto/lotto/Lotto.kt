package lotto_auto.lotto

data class Lotto(
    val number: List<Int> = createLotto(),
) {
    companion object {
        private fun createLotto(): List<Int> = (1..45).shuffled().take(6).sorted()
    }
}

fun List<Int>.toLotto() = Lotto(number = this)

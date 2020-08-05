package lotto.domain

class Lotto(val prizedAmount: Int) {
    var count: Int = 0
        private set

    fun addCount() {
        count++
    }
}

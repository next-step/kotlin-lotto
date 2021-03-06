package lotto.model

object RandomNumber {
    fun getLottoNum(): Int {
        return (1..45).random()
    }
}

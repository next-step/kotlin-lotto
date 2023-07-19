package lottogame.ui

interface LottoGameInput {
    fun money(): Int
    fun manualLottos(): List<List<Int>>
    fun numbers(): List<Int>
    fun bonusNumber(): Int
}

package lotto

interface Lotto<T, V> {
    fun checkWinning(winningValue: T): V
}

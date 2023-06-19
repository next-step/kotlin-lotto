package lotto

interface Lotto<T, V> {
    fun checkWinning(winningLotto: T): V
}

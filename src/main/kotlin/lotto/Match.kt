package lotto

class Match {
    fun match(userLotto: List<Int>, winningLotto: List<Int>): Int {
        return userLotto.count { number -> winningLotto.contains(number) }
    }
}

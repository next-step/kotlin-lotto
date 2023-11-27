package lotto.view

class InputView {
    fun get(prompt: String): Int {
        print(prompt)
        return readln().toInt()
    }
    
    fun getWinningLotto(prompt: String): Set<Int> {
        print(prompt)
        return readln().split(",").map { it.toInt() }.toSet()
    }
    
}

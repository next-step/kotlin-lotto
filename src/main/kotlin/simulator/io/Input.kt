package simulator.io

class Input {
    fun getMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getWinningNumbers(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(",")
            .map { it.toInt() }
            .toSortedSet()
    }
}
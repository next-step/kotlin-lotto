package domain

class Lottery {

    val randomNumber = (1..45).shuffled().take(6)

    fun countMatchingLottery(winningNums: List<Int>): Int {
        return randomNumber.intersect(winningNums.toSet()).size
    }
}

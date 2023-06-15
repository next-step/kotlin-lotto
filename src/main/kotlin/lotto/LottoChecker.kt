package lotto

class LottoChecker {

    fun lottoCheck(winningNumber: String, lottoBundle: List<List<Int>>): List<Int> {

        val numberList = winningNumber.replace("\\s".toRegex(), "").split(",").map { it.toInt() }

        val result = mutableListOf<Int>()
        lottoBundle.forEach { lotto ->
            var count = 0
            lotto.forEach { number ->
                if(numberList.contains(number)) {
                    count++
                }
            }
            result.add(count)
        }
        return result.toList()
    }
}
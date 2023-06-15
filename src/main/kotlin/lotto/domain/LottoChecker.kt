package lotto.domain

object LottoChecker {
    fun checkResult(lottos: List<Lotto>, winNumber: List<Int>): Map<Int, Int> {
        check(winNumber.size == 6) { "당첨번호는 6개여야 합니다" }
        val resultMap = mutableMapOf<Int, Int>()
        lottos.forEach { lotto ->
            val count = winNumber.count { number -> number in lotto.numbers }
            if (count >= 3) {
                resultMap[count] = resultMap.getOrDefault(count, 0) + 1
            }
        }
        return resultMap
    }
}
